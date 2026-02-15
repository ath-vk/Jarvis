package com.project.jarvis.dto.member;

import com.project.jarvis.enums.ProjectRole;

public record MemberResponse(
        Long id,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role
) {
}
