package com.project.jarvis.dto.auth;

public record UserProfileResponse(
    Long id,
    String username,
    String name
) {

}
