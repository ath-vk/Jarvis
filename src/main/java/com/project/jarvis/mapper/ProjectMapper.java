package com.project.jarvis.mapper;
import com.project.jarvis.dto.project.ProjectResponse;
import com.project.jarvis.dto.project.ProjectSummaryResponse;
import com.project.jarvis.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(source = "owner", target = "user")
    ProjectResponse toProjectResponse(Project project);

    List<ProjectSummaryResponse>  toProjectSummaryResponse(List<Project> projects);
}
