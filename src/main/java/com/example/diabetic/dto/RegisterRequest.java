package com.example.diabetic.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

        @NotBlank @Size(max = 50) @Email String email,
        @NotBlank @Size(min = 6, max = 20) String password,
        @NotBlank String displayName,
        String locale,
        String currency
) {
}