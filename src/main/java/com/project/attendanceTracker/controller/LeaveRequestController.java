package com.project.attendanceTracker.controller;

import com.project.attendanceTracker.model.LeaveRequest;
import com.project.attendanceTracker.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/api/leave/apply")
    public ResponseEntity<?> applyForLeave(@RequestBody LeaveRequest leaveRequest, Principal principal){

        return ResponseEntity.status(HttpStatus.CREATED).body(leaveRequestService.applyForLeave(leaveRequest, principal.getName()));

    }

    @PutMapping("/api/leave/withdraw")
    public ResponseEntity<?> withdrawLeave(@RequestBody LeaveRequest leaveRequest, Principal principal){
        return ResponseEntity.status(HttpStatus.CREATED).body(leaveRequestService.withdrawLeave(leaveRequest, principal.getName()));
    }

}
