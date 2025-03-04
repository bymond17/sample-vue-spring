package com.example.sample_vue_spring.web.dto;

import lombok.Data;

@Data
public class UserLoginDto {
    private String email;
    private String password;
}
