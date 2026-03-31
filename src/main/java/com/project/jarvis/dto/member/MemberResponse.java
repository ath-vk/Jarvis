package com.project.jarvis.dto.member;

import com.project.jarvis.enums.ProjectRole;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        ProjectRole projectRole
) {
}
