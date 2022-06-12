package com.example.clockinapi.controller;

import com.example.clockinapi.model.User;
import com.example.clockinapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //save user: post new user details
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return this.userRepository.save(user);
    }
}
