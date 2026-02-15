package com.project.jarvis.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
