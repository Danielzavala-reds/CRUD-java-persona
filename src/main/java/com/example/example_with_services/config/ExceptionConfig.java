package com.example.example_with_services.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.example_with_services.config.exceptions.BadRequest;
import com.example.example_with_services.config.exceptions.NotFound;

@ControllerAdvice(annotations = RestController.class) /* El restController dentro del ControllerAdvice interceptara todo método que lleve por notación, RestController */
public class ExceptionConfig {
    
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<?> notFoundEx(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<?> badRequestEx(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
