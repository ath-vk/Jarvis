package com.project.jarvis.dto.auth;

public record AuthResponse(String token, UserProfileResponse user) {
}


// dummy: new AuthResponse("", new UserProfileResponse(..))