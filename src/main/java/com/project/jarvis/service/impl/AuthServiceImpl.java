package com.project.jarvis.service.impl;

import com.project.jarvis.dto.auth.AuthResponse;
import com.project.jarvis.dto.auth.LoginRequest;
import com.project.jarvis.dto.auth.SignupRequest;
import com.project.jarvis.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
    
}
