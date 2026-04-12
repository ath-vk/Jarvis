package com.project.jarvis.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {

    EDITOR(Set.of(ProjectPermission.VIEW,
            ProjectPermission.DELETE,
            ProjectPermission.EDIT,
            ProjectPermission.VIEW_MEMBERS)),
    VIEWER(Set.of(ProjectPermission.VIEW, ProjectPermission.VIEW_MEMBERS)),
    OWNER(
            Set.of(ProjectPermission.VIEW,
                    ProjectPermission.DELETE,
                    ProjectPermission.EDIT,
                    ProjectPermission.MANAGE_MEMBERS,
                    ProjectPermission.VIEW_MEMBERS)
    );

    ProjectRole(ProjectPermission... permissions) {
        this.permissions = Set.of(permissions);
    }

    private final Set<ProjectPermission> permissions;
}
