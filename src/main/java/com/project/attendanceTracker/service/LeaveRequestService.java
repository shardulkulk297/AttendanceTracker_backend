package com.project.attendanceTracker.service;

import com.project.attendanceTracker.model.Employee;
import com.project.attendanceTracker.model.LeaveRequest;
import com.project.attendanceTracker.repository.EmployeeRepository;
import com.project.attendanceTracker.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class LeaveRequestService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    public LeaveRequest applyForLeave(LeaveRequest leaveRequest, String username) {

        Employee employee = employeeRepository.getByUsername(username);
        leaveRequest.setEmployee(employee);
        leaveRequest.setManager(employee.getManager());
        leaveRequest.setStatus("APPLIED");
        leaveRequest.setRequestedAt(LocalDateTime.now());
        leaveRequest.setUniqueIdentifier(leaveRequest.getRequestedAt() + "-" + leaveRequest.getEmployee().getId());

        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest withdrawLeave(LeaveRequest leaveRequest, String username){

        Employee employee = employeeRepository.getByUsername(username);
        LeaveRequest leaveRequest1 = leaveRequestRepository.getLeaveRequestForWithdrawing(leaveRequest.getRequestedAt() + "-" + employee.getId());

        leaveRequest1.setWithdrawnAt(LocalDateTime.now());
        leaveRequest1.setStatus("WITHDRAWN");
        return leaveRequestRepository.save(leaveRequest1);
    }
}
