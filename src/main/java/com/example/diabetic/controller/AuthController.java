package com.example.diabetic.controller;

import com.example.diabetic.dto.RegisterRequest;
import com.example.diabetic.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
        @Autowired
        UserRepository userRepository;

        @PostMapping("/signup")
        public String registerUser(@Valid @RequestBody RegisterRequest request){
            return "test";
        }





}
