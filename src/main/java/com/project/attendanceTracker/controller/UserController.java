package com.project.attendanceTracker.controller;

import com.project.attendanceTracker.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body()
    }


}
