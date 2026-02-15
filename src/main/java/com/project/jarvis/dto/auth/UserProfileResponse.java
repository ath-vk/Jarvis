package com.project.jarvis.dto.auth;

public record UserProfileResponse(
    Long id,
    String email,
    String name,
    String avatar
) {

}
