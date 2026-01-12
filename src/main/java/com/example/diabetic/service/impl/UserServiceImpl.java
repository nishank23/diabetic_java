package com.example.diabetic.service.impl;

import com.example.diabetic.Utils.Utils;
import com.example.diabetic.dto.LoginRequest;
import com.example.diabetic.dto.OtpSendRequest;
import com.example.diabetic.dto.RegisterRequest;
import com.example.diabetic.model.OtpVerification;
import com.example.diabetic.model.OtpVerifyRequest;
import com.example.diabetic.model.Users;
import com.example.diabetic.model.enums.UserType;
import com.example.diabetic.repository.OtpRepository;
import com.example.diabetic.repository.UserRepository;
import com.example.diabetic.service.EmailService;
import com.example.diabetic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    OtpRepository otpRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Users register(RegisterRequest registerRequest) {
        Optional<Users> user = userRepository.findByEmail(registerRequest.email());

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User already exists");
        }
        Users myUser = new Users();
        myUser.setEmail(registerRequest.email());
        String hashedPassword = passwordEncoder.encode(registerRequest.password());
        myUser.setPasswordHash(hashedPassword);
        myUser.setCreatedAt(Instant.now());
        //hardcoded as of now usertype,currency,locale
        myUser.setUserType(UserType.USER);
        myUser.setCurrency("INR");
        myUser.setLocale("LOCALE");
        myUser.setActive(false);

        return userRepository.save(myUser);
    }

    @Override
    public Users Login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public OtpVerification verifyOtp(OtpVerifyRequest otpRequest) {
        if (!userRepository.existsByEmail(otpRequest.email())) {
            throw new IllegalArgumentException("User Doesn't exits");
        }


        return null;
    }

    @Override
    public OtpVerification sendOtp(OtpSendRequest otpRequest) {
        Users user = userRepository.findByEmail(otpRequest.email())
                .orElseThrow(() -> new IllegalArgumentException("User Doesn't Exist"));

        OtpVerification otpVerification = new OtpVerification();
        otpVerification.setEmail(otpRequest.email());
        otpVerification.setExpiresAt(Instant.now().plusSeconds(300));
        String generatedOtp = Utils.generateOtp();
        otpVerification.setOtpHash(passwordEncoder.encode(generatedOtp));
        otpVerification.setUsed(false);

        otpRepository.save(otpVerification);
        emailService.sendOtpEmail(otpRequest.email(), generatedOtp);
        return otpVerification;
    }


}
