package com.example.sample_vue_spring.web.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String email;
    private String password;
    private String username;
}
