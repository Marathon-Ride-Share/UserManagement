package com.marathon.usermanagement.controllers;

import com.marathon.usermanagement.models.User;
import com.marathon.usermanagement.utils.JwtUtil;
import com.marathon.usermanagement.utils.LoginRes;
import com.marathon.usermanagement.services.UserService;
import com.marathon.usermanagement.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import java.util.Map;

@CrossOrigin
@Controller
@RestController
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final SecurityConfig passwordEncoder;

    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil, SecurityConfig passwordEncoder) {
        System.out.println("UserController!!!");
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // POST /users/register - Register a new user
    @PostMapping("/users/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
         System.out.println("register!!!");
        User newUser = userService.registerUser(user);
        System.out.println("registerUser!!!"+newUser);

        if (newUser != null) {
            return ResponseEntity.ok(newUser);
        } else {
            return ResponseEntity.badRequest().body("Failed to register user");
        }
        
    }

    // POST /users/login - Login a user
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> credentials) {
        System.out.println("login!!!");
        String username = credentials.get("username");
        String rawPassword = credentials.get("password");
        
        User user = userService.getUserById(username);
        LoginRes res = new LoginRes();

        if (user.getDLInfo() == null) {
            res.setIsDriver(false);
        } else {
            res.setIsDriver(true);
        }

        if (user != null && passwordEncoder.checkPassword(rawPassword, user.getPassword())) {
            final String jwt = jwtUtil.generateToken(user.getUsername());
            res.setUsername(user.getUsername());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + jwt);

            return new ResponseEntity<>(res, headers, HttpStatus.OK);
        } else {
            System.out.println("login!!!22222");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error during authentication");
        }
    }

    // PUT /users/{userId} - Update a user's personal information
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user) {
        User updatedUser = userService.updateUser(username, user);
        return ResponseEntity.ok(updatedUser);
    }

    // GET /users/{userId} - Get a user's information
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        User user = userService.getUserById(userId);
       if (user != null) {
            user.setPassword(null);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}