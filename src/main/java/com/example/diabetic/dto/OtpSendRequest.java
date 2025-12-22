package com.example.diabetic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OtpSendRequest(

        @NotBlank @Size(max = 50) String email

) {
}
