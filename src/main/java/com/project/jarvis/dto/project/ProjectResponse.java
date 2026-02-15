package com.project.jarvis.dto.project;

import com.project.jarvis.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
    Long id,
    String name,
    Instant createdAt,
    Instant updatedAt,
    UserProfileResponse user
) {

}

