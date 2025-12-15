package com.project.attendanceTracker.controller;

import com.project.attendanceTracker.model.LeaveRequest;
import com.project.attendanceTracker.model.Manager;
import com.project.attendanceTracker.service.ManagerService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
public class ManagerController{

    @Autowired
    private ManagerService managerService;

    @PostMapping("/api/manager/add")
    public ResponseEntity<?> addManager(@RequestBody Manager manager)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.addManager(manager));
    }

    @PutMapping("/api/manager/leave/approve")
    public ResponseEntity<?> approveLeave(@RequestBody LeaveRequest leaveRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.approveLeave(leaveRequest));
    }

    @PutMapping("/api/manager/leave/decline")
    public ResponseEntity<?> declineLeave(@RequestBody LeaveRequest leaveRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.declineLeave(leaveRequest));
    }

}
