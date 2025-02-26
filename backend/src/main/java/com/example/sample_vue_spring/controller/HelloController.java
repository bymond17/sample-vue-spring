package com.example.sample_vue_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}