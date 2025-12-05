package com.project.attendanceTracker.service;

import com.project.attendanceTracker.model.AttendanceRecord;
import com.project.attendanceTracker.model.Employee;
import com.project.attendanceTracker.repository.AttendanceRecordRepository;
import com.project.attendanceTracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.AttributeException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceRecordService {

    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public AttendanceRecord checkIn(AttendanceRecord attendanceRecord, String name) {

        Employee employee = employeeRepository.getByUsername(name);
        LocalDate date = LocalDate.now();
        int id = employee.getId();
        String uniqueConstraint = date + "-" + id;
        AttendanceRecord checkTodaysCheckIn = attendanceRecordRepository.checkTodaysCheckIn(uniqueConstraint);
        if(checkTodaysCheckIn != null){
            throw new RuntimeException("You have already CheckedIn for Today");
        }
        attendanceRecord.setUniqueConstraint(uniqueConstraint);
        attendanceRecord.setEmployee(employee);
        attendanceRecord.setStatus("PRESENT");
        attendanceRecord.setPunchInAt(LocalDateTime.now());

        return attendanceRecordRepository.save(attendanceRecord);
    }

    public AttendanceRecord checkOut(String name) {
        Employee employee = employeeRepository.getByUsername(name);
        String uniqueConstraint = LocalDate.now() + "-" + employee.getId();
        AttendanceRecord attendanceRecord = attendanceRecordRepository.checkTodaysCheckIn(uniqueConstraint);

        attendanceRecord.setPunchOutAt(LocalDateTime.now());
        attendanceRecord.setRecordDate(LocalDate.now());

        return attendanceRecordRepository.save(attendanceRecord);
    }


    public List<AttendanceRecord> getMyAttendance(String name, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Employee employee = employeeRepository.getByUsername(name);

        List<AttendanceRecord> attendanceRecords = attendanceRecordRepository.getMyAttendanceRecords(employee.getId(), startDateTime, endDateTime);

        return attendanceRecords;
    }


}
