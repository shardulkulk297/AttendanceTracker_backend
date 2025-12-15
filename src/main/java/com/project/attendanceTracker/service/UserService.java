package com.project.attendanceTracker.service;

import com.project.attendanceTracker.model.Employee;
import com.project.attendanceTracker.model.Manager;
import com.project.attendanceTracker.model.User;
import com.project.attendanceTracker.repository.EmployeeRepository;
import com.project.attendanceTracker.repository.ManagerRepository;
import com.project.attendanceTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public User signUp(User user) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }


    public Object getLoggedInUserDetails(String username) {

        User userToFind = userRepository.getByUsername(username);

        switch (userToFind.getRole())
        {
            case "MANAGER"->{
                Manager manager = managerRepository.getByUsername(username);
                return manager;
            }
            case "EMPLOYEE"->{
                Employee employee = employeeRepository.getByUsername(username);
                return employee;
            }
            default -> {
                return null;
            }

        }

    }

}
