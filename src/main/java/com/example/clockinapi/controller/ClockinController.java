package com.example.clockinapi.controller;


import com.example.clockinapi.exception.ResourceNotFoundException;
import com.example.clockinapi.model.Clockin;
import com.example.clockinapi.model.User;
import com.example.clockinapi.repository.ClockinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clockin/api/v1")
public class ClockinController {

    @Autowired
    private ClockinRepository clockinRepository;

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

    //
}
