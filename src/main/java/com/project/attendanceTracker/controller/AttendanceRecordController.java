package com.project.attendanceTracker.controller;

import com.project.attendanceTracker.model.AttendanceRecord;
import com.project.attendanceTracker.model.Employee;
import com.project.attendanceTracker.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class AttendanceRecordController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;

    @PostMapping("/api/attendance/check-in")
    public ResponseEntity<?> checkIn(AttendanceRecord attendanceRecord, Principal principal){
        return ResponseEntity.status(HttpStatus.CREATED).body(attendanceRecordService.checkIn(attendanceRecord, principal.getName()));
    }

    @PutMapping("/api/attendance/check-out")
    public ResponseEntity<?> checkOut(Principal principal)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(attendanceRecordService.checkOut(principal.getName()));
    }

    @GetMapping("/api/attendance/my-attendance")
    public ResponseEntity<?> getMyAttendance(Principal principal, LocalDateTime startDateTime, LocalDateTime endDateTime){
        return ResponseEntity.status(HttpStatus.OK).body(attendanceRecordService.getMyAttendance(principal.getName(), startDateTime, endDateTime));
    }


}
