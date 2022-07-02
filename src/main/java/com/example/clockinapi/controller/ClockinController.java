package com.example.clockinapi.controller;


import com.example.clockinapi.exception.ResourceNotFoundException;
import com.example.clockinapi.model.Clockin;
import com.example.clockinapi.model.User;
import com.example.clockinapi.repository.ClockinRepository;
import com.example.clockinapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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

//    @PostMapping("/users")
//    public User createUser(@RequestBody User user){
//        user.setUserid(generateUserId());
//        return this.userRepository.save(user);
//    }
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
        checkindetails.setDate(new Date());
        checkindetails.setCheckintime(LocalTime.now());

        return this.clockinRepository.save(checkindetails);
    }

}
