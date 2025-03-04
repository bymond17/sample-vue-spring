package com.example.sample_vue_spring.service;

import com.example.sample_vue_spring.domain.User;
import com.example.sample_vue_spring.infrastructure.UserRepository;
import com.example.sample_vue_spring.web.dto.UserDto;
import com.example.sample_vue_spring.web.dto.UserLoginDto;
import com.example.sample_vue_spring.web.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto register(@Valid UserRegistrationDto registrationDto) {
        validateNewUser(registrationDto);
        User user = createUser(registrationDto);
        log.info("새로운 사용자 등록: {}", registrationDto.getEmail());
        return convertToDto(userRepository.save(user));
    }

    public UserDto login(@Valid UserLoginDto loginDto) {
        User user = findUserByEmail(loginDto.getEmail());
        validatePassword(loginDto.getPassword(), user.getPassword());
        log.info("사용자 로그인 성공: {}", loginDto.getEmail());
        return convertToDto(user);
    }

    private void validateNewUser(UserRegistrationDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            log.warn("중복된 이메일 등록 시도: {}", dto.getEmail());
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
    }

    private User createUser(UserRegistrationDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .username(dto.getUsername())
                .build();
    }

    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.warn("존재하지 않는 이메일로 로그인 시도: {}", email);
                    return new IllegalArgumentException("존재하지 않는 이메일입니다.");
                });
    }

    private void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            log.warn("잘못된 비밀번호 시도");
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}