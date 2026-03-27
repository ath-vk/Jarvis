package com.project.jarvis.service.impl;

import com.project.jarvis.dto.auth.UserProfileResponse;
import com.project.jarvis.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
