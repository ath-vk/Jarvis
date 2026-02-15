package com.project.jarvis.service;


import com.project.jarvis.dto.auth.AuthResponse;
import com.project.jarvis.dto.auth.LoginRequest;
import com.project.jarvis.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);
    AuthResponse login(LoginRequest request);
}
