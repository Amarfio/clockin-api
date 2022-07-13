package com.example.clockinapi.controller;


import com.example.clockinapi.EmailSenderService;
import com.example.clockinapi.exception.ResourceNotFoundException;
import com.example.clockinapi.model.Clockin;
import com.example.clockinapi.model.User;
import com.example.clockinapi.repository.ClockinRepository;
import com.example.clockinapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("clockin/api/v1")
public class ClockinController {

    @Autowired
    private ClockinRepository clockinRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EmailSenderService senderService;

    //method to set up and send email
    public void sendClockInEmail(String toEmail, String userFirstName, String process, String time, String goodWish){

        //commented for debugging purposes
        // toEmail = "joshuaamarfio1@gmail.com";

        //subject of the email
        String subject="ClockIn System Update";

        //stuff for check in
        //user name, time of check in and process

        //message of the email
        String body = "Welcome " +userFirstName+", "+
                      //end the line
                      "\nYou "+process+" to the office at "+time+
                      //end the line
                      "\n\n"
                      +goodWish+"!!!";

        senderService.sendEmail(toEmail, subject, body);
    }

    //get clockins: get all the clockin records saved in the database
    @GetMapping("/clockins")
    public List<Clockin> getAllClockins(){
        return this.clockinRepository.findAll();
    }

    //get clockin details by id : get a particular clockin details by the specified id
    @GetMapping("/clockins/{id}")
    public ResponseEntity<Clockin> getClockinById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Clockin clockin = clockinRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Clockin not found for this id::"+ id));
        return ResponseEntity.ok().body(clockin);
    }


    //post clockin details using the check in method
    @PostMapping("/checkin")
    public Clockin userCheckIn(@RequestParam String userid){
        User user = userRepository.findByUserid(userid);
        Clockin checkindetails = new Clockin();

        checkindetails.setUserid(user.getUserid());
        checkindetails.setFirstname(user.getFirstname());
        checkindetails.setOthername(user.getOthername());
        checkindetails.setLastname(user.getLastname());
        checkindetails.setGroupname(user.getGroupname());
        checkindetails.setDate(LocalDate.now());
        checkindetails.setCheckintime(LocalTime.now());
        checkindetails.setCreated_at(LocalDateTime.now());

        //get the time user checked in
        LocalTime checkInTime = checkindetails.getCheckintime();

        sendClockInEmail(user.getEmail(), user.getFirstname(),"checked in", checkInTime.toString(), "Have a productive day yeah");
        return this.clockinRepository.save(checkindetails);
    }

    //update clockin details using the check out method
    //this actually checks the user out
    @PutMapping("/checkout")
    public ResponseEntity userCheckOut(@RequestParam String userid) throws ResourceNotFoundException{
        LocalDate checkoutdate = LocalDate.now();
        Clockin checkoutdetails = clockinRepository.findByUseridAndDate(userid, checkoutdate);
        User user = userRepository.findByUserid(userid);
        checkoutdetails.setCheckouttime(LocalTime.now());
        checkoutdetails.setUpdated_at(LocalDateTime.now());

        //send email when user checks out of the office
        sendClockInEmail(user.getEmail(), user.getFirstname(),"checked out", checkoutdetails.getCheckouttime().toString(), "See you tomorrowx");
        return ResponseEntity.ok(this.clockinRepository.save(checkoutdetails));
    }

}
