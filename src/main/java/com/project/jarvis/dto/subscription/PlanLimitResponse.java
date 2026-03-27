package com.project.jarvis.dto.subscription;

public record PlanLimitResponse(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {
}
