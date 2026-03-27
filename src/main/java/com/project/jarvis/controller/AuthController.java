package com.project.jarvis.controller;

import com.project.jarvis.dto.auth.AuthResponse;
import com.project.jarvis.dto.auth.LoginRequest;
import com.project.jarvis.dto.auth.SignupRequest;
import com.project.jarvis.dto.auth.UserProfileResponse;
import com.project.jarvis.service.AuthService;
import com.project.jarvis.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    AuthService authService;
    UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping(path = "/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
