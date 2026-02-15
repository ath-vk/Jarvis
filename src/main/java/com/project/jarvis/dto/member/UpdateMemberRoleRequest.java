package com.project.jarvis.dto.member;

import com.project.jarvis.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
