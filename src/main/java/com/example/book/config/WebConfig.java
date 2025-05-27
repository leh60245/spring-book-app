package com.example.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로 허용 (혹은 "/api/**")
                .allowedOrigins("http://localhost:3000") // React 개발 서버 주소
                .allowedMethods("*") // GET, POST, PUT 등 모든 HTTP 메서드 허용
                .allowedHeaders("*"); // 모든 헤더 허용
    }
}
