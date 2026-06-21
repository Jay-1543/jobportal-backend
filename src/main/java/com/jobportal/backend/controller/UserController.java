package com.jobportal.backend.controller;

import com.jobportal.backend.model.User;
import com.jobportal.backend.security.JwtService;
import com.jobportal.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Map<String, Object> login(
            @RequestBody Map<String, String> request) {

        User user = userService.login(
                request.get("email"),
                request.get("password")
        );

        Map<String, Object> response = new HashMap<>();

        if (user != null) {

            String token = jwtService.generateToken(
                    user.getEmail()
            );

            response.put("message", "Login Success");
            response.put("token", token);
            response.put("user", user);

        } else {

            response.put("message", "Invalid Credentials");
        }

        return response;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}