package com.example.clockinapi.controller;

import com.example.clockinapi.exception.ResourceNotFoundException;
import com.example.clockinapi.model.User;
import com.example.clockinapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clockin/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get users: get all the user records saved in the database
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    //get user details by id : get a particular user details by the specified id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value="id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found for this id::"+ userId));
        return ResponseEntity.ok().body(user);
    }

    //save user: post new user details
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        user.setUserid(generateUserId());
        return this.userRepository.save(user);
    }

    //update user: post to edit user details by a specified id
    @PutMapping("/users/{id}")
    public ResponseEntity updateUser(@PathVariable(value="id") Long userId, @Validated @RequestBody User userDetails) throws ResourceNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found for this id::"+ userId));
        user.setEmail(userDetails.getEmail());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setOthername(userDetails.getOthername());
        user.setDepartment(userDetails.getDepartment());
        user.setDateofbirth(userDetails.getDateofbirth());
        user.setContact(userDetails.getContact());
        user.setPosition(userDetails.getPosition());
        user.setOccupation(userDetails.getOccupation());
        user.setGender(userDetails.getGender());
        user.setGroupname(userDetails.getGroupname());
        user.setResidence(userDetails.getResidence());
        user.setUpdatedby(userDetails.getUpdatedby());
        user.setUpdatingdate(userDetails.getUpdatingdate());

        return ResponseEntity.ok(this.userRepository.save(user));
    }

    //method to get the number of records in the users table
    public long getUsersCount(){
        return this.userRepository.count();
    }

    //method to get user id
    public String generateUserId(){
        //get the number of records in the table
        long numberofUsers = getUsersCount();

        //add one to the total of the records
        long plusOne = numberofUsers + 1;
        String stringId = String.valueOf(plusOne);

        for(int numLength=stringId.length(); numLength<4; ++numLength ){
            stringId = "0" + stringId;
        }

        return stringId;
    }

}
