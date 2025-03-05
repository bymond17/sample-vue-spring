package com.example.sample_vue_spring.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Sample Vue.js + Spring Boot API").description("Vue.js와 Spring Boot를 사용한 샘플 프로젝트 API 문서").version("v1.0").contact(new Contact().name("bymond17").email("your.email@example.com")));
    }
} 