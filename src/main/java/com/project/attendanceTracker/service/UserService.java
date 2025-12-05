package com.project.attendanceTracker.service;

import com.project.attendanceTracker.model.User;
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

            }
            case "EMPLOYEE"->{

            }
            default -> {
                return null;
            }

        }
        return null;

    }

}
