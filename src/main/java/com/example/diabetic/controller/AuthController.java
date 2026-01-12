package com.example.diabetic.controller;

import com.example.diabetic.dto.OtpSendRequest;
import com.example.diabetic.dto.RegisterRequest;
import com.example.diabetic.model.OtpVerification;
import com.example.diabetic.model.OtpVerifyRequest;
import com.example.diabetic.repository.UserRepository;
import com.example.diabetic.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
        @Autowired
        UserRepository userRepository;

        @Autowired
        UserService userService;

        @PostMapping("/signup")
        public String registerUser(@Valid @RequestBody RegisterRequest request){
            return "test";
        }

        @PostMapping("/sendOtp")
        public ResponseEntity<OtpVerification> sendOtp(@Valid @RequestBody OtpSendRequest request){
              return ResponseEntity.ok().body(userService.sendOtp(request));
        }

        @PostMapping("/verifyOtp")
        public ResponseEntity<OtpVerification> verifyOtp(@Valid @RequestBody OtpVerifyRequest request){
                return ResponseEntity.ok().body(userService.verifyOtp(request));
        }




}
