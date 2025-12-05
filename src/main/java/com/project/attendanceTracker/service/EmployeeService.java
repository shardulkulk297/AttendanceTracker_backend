package com.project.attendanceTracker.service;

import com.project.attendanceTracker.model.Employee;
import com.project.attendanceTracker.model.User;
import com.project.attendanceTracker.repository.EmployeeRepository;
import com.project.attendanceTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public Employee registerEmployee(Employee employee) {
        User user = employee.getUser();
        user.setRole("EMPLOYEE");
        user = userService.signUp(user);
        employee.setUser(user);

        return employeeRepository.save(employee);
    }

}
