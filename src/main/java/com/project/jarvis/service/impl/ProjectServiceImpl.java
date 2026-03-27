package com.project.jarvis.service.impl;

import com.project.jarvis.dto.project.ProjectRequest;
import com.project.jarvis.dto.project.ProjectResponse;
import com.project.jarvis.dto.project.ProjectSummaryResponse;
import com.project.jarvis.entity.Project;
import com.project.jarvis.entity.User;
import com.project.jarvis.mapper.ProjectMapper;
import com.project.jarvis.repository.ProjectRepository;
import com.project.jarvis.repository.UserRepository;
import com.project.jarvis.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        // getting user details
        User owner = userRepository.findById(userId).orElseThrow();
        System.out.println(owner);
        // creating project entity object
        Project project = Project.builder().name(request.name()).isPublic(false).owner(owner).build();
        // saving in db
        project = projectRepository.save(project);
        // returning the response by converting to dto
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
