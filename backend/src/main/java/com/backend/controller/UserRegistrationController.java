package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.User;
import com.backend.service.UserRegistration;




@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {
    
    @Autowired
    private  UserRegistration userRegistration;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userRegistration.registerUser(user);
        
        return ResponseEntity.ok("user registrsition successful");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        userRegistration.userLogin(user.getEmail(), user.getPassword());
        return ResponseEntity.ok("login successful");
    }

}
