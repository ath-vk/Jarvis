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
import com.project.jarvis.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        // getting user details
        User owner = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", userId.toString())
        );
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
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
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
