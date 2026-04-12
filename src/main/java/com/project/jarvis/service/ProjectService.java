package com.project.jarvis.service;

import com.project.jarvis.dto.project.ProjectRequest;
import com.project.jarvis.dto.project.ProjectResponse;
import com.project.jarvis.dto.project.ProjectSummaryResponse;
import com.project.jarvis.entity.Project;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();
    ProjectResponse getUserProjectById(Long id);
    ProjectResponse createProject(ProjectRequest request);
    ProjectResponse updateProject(Long id, ProjectRequest request);
    void softDelete(Long id);
    Project getAccessibleProjectById(Long id, Long userId);
}