package com.example.sample_vue_spring.web.controller;

import com.example.sample_vue_spring.service.UserService;
import com.example.sample_vue_spring.web.dto.UserDto;
import com.example.sample_vue_spring.web.dto.UserLoginDto;
import com.example.sample_vue_spring.web.dto.UserRegistrationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "사용자 관리 API")
public class UserController {
    private final UserService userService;

    @Operation(summary = "사용자 등록", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserRegistrationDto userRegistrationDto) {
        UserDto userDto = userService.register(userRegistrationDto);
        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "사용자 로그인", description = "사용자 인증을 수행합니다.")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }
}
