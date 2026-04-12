package com.project.jarvis.service.impl;

import com.project.jarvis.dto.project.ProjectRequest;
import com.project.jarvis.dto.project.ProjectResponse;
import com.project.jarvis.dto.project.ProjectSummaryResponse;
import com.project.jarvis.entity.Project;
import com.project.jarvis.entity.ProjectMember;
import com.project.jarvis.entity.ProjectMemberId;
import com.project.jarvis.entity.User;
import com.project.jarvis.enums.ProjectRole;
import com.project.jarvis.error.ResourceNotFoundException;
import com.project.jarvis.mapper.ProjectMapper;
import com.project.jarvis.repository.ProjectMemberRepository;
import com.project.jarvis.repository.ProjectRepository;
import com.project.jarvis.repository.UserRepository;
import com.project.jarvis.security.AuthUtil;
import com.project.jarvis.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        // getting user details
        Long userId = authUtil.getCurrentUserId();
//        User owner = userRepository.findById(userId).orElseThrow(
//                () -> new ResourceNotFoundException("User", userId.toString())
//        );

        User owner = userRepository.getReferenceById(userId);

        System.out.println(owner);
        // creating project entity object
        Project project = Project.builder().name(request.name()).isPublic(false).build();
        // saving in db
        project = projectRepository.save(project);

        ProjectMemberId projectMemberId =  new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);

        // returning the response by converting to dto
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        return projectMapper.toProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    //@PreAuthorize("@security.hasPermission(#projectId, T(com.project.jarvis.enums.ProjectPermission('project:delete')))")
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    @Override
    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.
                findAccessibleProjectsById(id, userId).
                orElseThrow(() -> new ResourceNotFoundException("Project", id.toString()));
    }
}
