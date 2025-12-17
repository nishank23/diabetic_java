package com.example.diabetic.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidBgReadingException.class)
    public ResponseEntity<?> handle(InvalidBgReadingException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handle(ResourceNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }




}
