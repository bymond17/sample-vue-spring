package com.example.sample_vue_spring.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.sample_vue_spring.web.dto.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleException(Exception e) {
        return ApiResponse.builder().status("error").message(e.getMessage()).build();
    }
} 