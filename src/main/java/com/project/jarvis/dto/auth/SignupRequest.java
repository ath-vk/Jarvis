package com.project.jarvis.dto.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
