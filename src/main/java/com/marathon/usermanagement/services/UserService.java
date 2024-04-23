package com.marathon.usermanagement.services;

import org.springframework.stereotype.Service;
import com.marathon.usermanagement.models.User;
import com.marathon.usermanagement.models.UserDto;
import com.marathon.usermanagement.factory.UserFactory;
import com.marathon.usermanagement.utils.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.marathon.usermanagement.config.SecurityConfig;

@Service
public class UserService {

    private UserRepo userRepository;
    private SecurityConfig passwordEncoder;
    private UserFactory userFactory;

    @Autowired
    public UserService(UserRepo userRepository, SecurityConfig passwordEncoder, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userFactory = userFactory;
    }

    public User registerUser(UserDto userDTO) {
        UserDto foundUser = userRepository.findById(userDTO.getUsername()).orElse(null);
        User newUser;
        if (foundUser == null) {
            String encodedPassword = passwordEncoder.hashPassword(userDTO.getPassword());
            userDTO.setPassword(encodedPassword);
            
            if (userDTO.getDLInfo() != null) {
                newUser = userFactory.makeDriver(userDTO);
            } else {
                newUser = userFactory.makeRider(userDTO);
            }

            UserDto savedUser = userRepository.save(userDTO);
            return newUser; 
        } else {
            return null;
        }
    }

    public User updateUser(String username, UserDto userDTO) {
        UserDto foundUser = userRepository.findById(username).orElse(null);
        User newUser;

        if (foundUser == null) {
            return null;
        } else {
            userDTO.setUsername(username);
            userRepository.save(userDTO);

            if (userDTO.getDLInfo() != null) {
                newUser = userFactory.makeDriver(userDTO);
            } else {
                newUser = userFactory.makeRider(userDTO);
            }
            return newUser;
        }
        
    }

    public UserDto getUserById(String username) {
        return userRepository.findById(username).orElse(null);
    }
}