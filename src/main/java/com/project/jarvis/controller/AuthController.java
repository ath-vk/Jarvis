package com.project.jarvis.controller;

import com.project.jarvis.dto.auth.AuthResponse;
import com.project.jarvis.dto.auth.LoginRequest;
import com.project.jarvis.dto.auth.SignupRequest;
import com.project.jarvis.dto.auth.UserProfileResponse;
import com.project.jarvis.service.AuthService;
import com.project.jarvis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<AuthResponse> signup(SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping(path = "/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
