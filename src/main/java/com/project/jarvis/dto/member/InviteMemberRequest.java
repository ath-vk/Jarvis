package com.project.jarvis.dto.member;

import com.project.jarvis.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
