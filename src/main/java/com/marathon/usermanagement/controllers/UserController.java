package com.marathon.usermanagement.controllers;

import com.marathon.usermanagement.dto.DriverInfo;
import com.marathon.usermanagement.dto.UserInfo;
import com.marathon.usermanagement.dto.VehicleInfo;
import com.marathon.usermanagement.models.User;
import com.marathon.usermanagement.utils.JwtUtil;
import com.marathon.usermanagement.utils.LoginRes;
import com.marathon.usermanagement.services.UserService;
import com.marathon.usermanagement.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import java.util.Map;

//@CrossOrigin
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
         System.out.println("register!!!"+user);
        User newUser = userService.registerUser(user);
        System.out.println("registerUser!!!"+newUser);

        if (newUser != null) {
            return ResponseEntity.ok(newUser);
        } else {
            return ResponseEntity.badRequest().body("Failed to register user");
        }
        
    }

    // POST /users/login - Login a user
    @PostMapping("/users/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> credentials) {

        String username = credentials.get("username");
        String rawPassword = credentials.get("password");

        User user = userService.getUserById(username);
        System.out.println("createAuthenticationToken userName!!!"+user);

        LoginRes res = new LoginRes();

        if (user.getDLInfo().equals("")) {
            res.setIsDriver(false);
        } else {
            res.setIsDriver(true);
        }

        if (user != null && passwordEncoder.checkPassword(rawPassword, user.getPassword())) {
            final String jwt = jwtUtil.generateToken(user.getUsername());

            ResponseCookie cookie = ResponseCookie.from("token", jwt)
                    .httpOnly(true)
                    .path("/")
                    .maxAge(7 * 24 * 60 * 60) // Set maxAge as appropriate
                    .sameSite("None") // Use "None" if the cookie should be sent in cross-site requests. Remember to use "Secure" as well
                    .build();

            res.setUsername(user.getUsername());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + jwt);

            System.out.println("createAuthenticationToken!!! res : "+res.toString());

            return new ResponseEntity<>(res, headers, HttpStatus.OK);
        } else {
            System.out.println("login!!!22222");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error during authentication");
        }
    }

    // PUT /users/{userId} - Update a user's personal information
    @PutMapping("/users/{userId}/{rating}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @PathVariable float rating) {
        User updatedUser = userService.updateUserRating(userId, rating);
        return ResponseEntity.ok(updatedUser);
    }

    // GET /users/{userId} - Get a user's information
    @GetMapping("users/drivers/{driverId}")
    public ResponseEntity<?> getUser(@PathVariable String driverId) {
        User user = userService.getUserById(driverId);
        DriverInfo driverInfo = DriverInfo.builder()
                .driverName(user.getUsername())
                .rating(user.getRating())
                .build();

        VehicleInfo vehicleInfo = VehicleInfo.builder()
                .make(user.getMake())
                .model(user.getModel())
                .color(user.getColor())
                .licensePlate(user.getPlate_number())
                .build();

        UserInfo userInfo = UserInfo.builder()
                .driverInfo(driverInfo)
                .vehicleInfo(vehicleInfo)
                .build();

        return ResponseEntity.ok(userInfo);
    }
}