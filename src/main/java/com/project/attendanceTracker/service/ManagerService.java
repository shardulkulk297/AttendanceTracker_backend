package com.project.attendanceTracker.service;

import com.project.attendanceTracker.model.Manager;
import com.project.attendanceTracker.model.User;
import com.project.attendanceTracker.repository.ManagerRepository;
import com.project.attendanceTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private UserService userService;

    public Manager addManager(Manager manager) {
        User user = manager.getUser();
        user.setRole("MANAGER");
        user = userService.signUp(user);
        manager.setUser(user);
        return managerRepository.save(manager);
    }
}
