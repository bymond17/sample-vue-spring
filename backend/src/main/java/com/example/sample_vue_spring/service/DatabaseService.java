package com.example.sample_vue_spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DatabaseService {
    private final JdbcTemplate jdbcTemplate;

    public Map<String, Object> checkConnection() {
        return jdbcTemplate.queryForMap("SELECT version(), current_database()");
    }
} 