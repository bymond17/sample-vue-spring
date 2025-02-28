package com.example.sample_vue_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Database", description = "데이터베이스 연결 체크 API")
public class DbCheckController {

    private final DatabaseService databaseService;

    @Operation(summary = "DB 연결 확인", 
              description = "데이터베이스 연결 상태와 버전 정보를 확인합니다.")
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
