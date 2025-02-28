package com.example.sample_vue_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.HashMap;

import com.example.sample_vue_spring.service.DatabaseService;
import com.example.sample_vue_spring.dto.ApiResponse;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DbCheckController {

    private final DatabaseService databaseService;

    @GetMapping("/db-check")
    public ApiResponse<Map<String, Object>> checkDatabaseConnection() {
        try {
            Map<String, Object> result = databaseService.checkConnection();
            return ApiResponse.<Map<String, Object>>builder()
                .status("success")
                .data(result)
                .build();
        } catch (Exception e) {
            return ApiResponse.<Map<String, Object>>builder()
                .status("error")
                .message("Database connection failed")
                .data(Map.of("error", e.getMessage()))
                .build();
        }
    }
}
