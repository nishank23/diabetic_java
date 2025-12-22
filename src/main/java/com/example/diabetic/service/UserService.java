package com.example.diabetic.service;

import com.example.diabetic.dto.LoginRequest;
import com.example.diabetic.dto.OtpRequest;
import com.example.diabetic.dto.OtpSendRequest;
import com.example.diabetic.dto.RegisterRequest;
import com.example.diabetic.model.OtpVerification;
import com.example.diabetic.model.Users;

public interface UserService {

    Users register (RegisterRequest registerRequest);
    Users Login (LoginRequest loginRequest);
    OtpVerification verifyOtp(OtpRequest otpRequest);
    OtpVerification sendOtp(OtpSendRequest otpRequest);
}
