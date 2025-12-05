package com.project.attendanceTracker.controller;

import com.project.attendanceTracker.model.Manager;
import com.project.attendanceTracker.service.ManagerService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController{

    @Autowired
    private ManagerService managerService;

    @PostMapping("/api/manager/add")
    public ResponseEntity<?> addManager(@RequestBody Manager manager)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.addManager(manager));
    }

}
