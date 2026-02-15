package com.project.jarvis.service;

import com.project.jarvis.dto.project.ProjectRequest;
import com.project.jarvis.dto.project.ProjectResponse;
import com.project.jarvis.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);
    ProjectResponse getUserProjectById(Long id, Long userId);
    ProjectResponse createProject(ProjectRequest request, Long userId);
    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);
    void softDelete(Long id, Long userId);
}