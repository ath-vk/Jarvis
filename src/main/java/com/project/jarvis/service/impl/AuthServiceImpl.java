package com.project.jarvis.service.impl;

import com.project.jarvis.dto.auth.AuthResponse;
import com.project.jarvis.dto.auth.LoginRequest;
import com.project.jarvis.dto.auth.SignupRequest;
import com.project.jarvis.entity.User;
import com.project.jarvis.error.BadRequestException;
import com.project.jarvis.mapper.UserMapper;
import com.project.jarvis.repository.UserRepository;
import com.project.jarvis.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {

    UserRepository userRespository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRespository.findByUsername(request.username()).ifPresent(user -> {
                    throw new BadRequestException("User already exists with username: "+request.username());
            }
        );

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user =  userRespository.save(user);

        return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
    
}
