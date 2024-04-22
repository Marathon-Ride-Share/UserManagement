package com.marathon.usermanagement.controllers;

import com.marathon.usermanagement.models.User;
import com.marathon.usermanagement.utils.JwtUtil;
import com.marathon.usermanagement.utils.LoginRes;
import com.marathon.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // POST /users/register - Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);

        if (newUser != null) {
            return ResponseEntity.ok(newUser);
        } else {
            return ResponseEntity.badRequest().body("Failed to register user");
        }
        
    }

    // POST /users/login - Login a user
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String rawPassword = credentials.get("password");
        
        User user = userService.getUserById(username);
        LoginRes res = new LoginRes();

        if (user.getDLInfo() == null) {
            res.setIsDriver(false);
        } else {
            res.setIsDriver(true);
        }

        if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
            final String jwt = jwtUtil.generateToken(user.getUsername());
            res.setJwt(jwt);

            return ResponseEntity.ok(res);
        } else {
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