package com.marathon.usermanagement.services;

import org.springframework.stereotype.Service;
import com.marathon.usermanagement.models.User;
import com.marathon.usermanagement.utils.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        User foundUser = userRepository.findById(user.getUsername()).orElse(null);

        if (foundUser == null) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return user;
        } else {
            return null;
        }
    }

    public User updateUser(String username, User user) {
        User foundUser = userRepository.findById(username).orElse(null);

        if (foundUser == null) {
            return null;
        } else {
            user.setUsername(username);
            userRepository.save(user);
            return user;
        }
        
    }

    public User getUserById(String username) {
        return userRepository.findById(username).orElse(null);
    }
}