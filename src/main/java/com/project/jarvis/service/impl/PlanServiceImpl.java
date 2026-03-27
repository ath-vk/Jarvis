package com.project.jarvis.service.impl;

import com.project.jarvis.dto.subscription.PlanResponse;
import com.project.jarvis.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
