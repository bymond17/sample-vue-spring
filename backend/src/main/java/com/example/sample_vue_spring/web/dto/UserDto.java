package com.example.sample_vue_spring.web.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String username;
    private String profileImage;
}
