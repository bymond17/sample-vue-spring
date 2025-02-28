package com.example.sample_vue_spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello", description = "Hello API")
public class HelloController {
    
    @Operation(summary = "Hello 메시지 조회", description = "서버에서 Hello 메시지를 가져옵니다.")
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}