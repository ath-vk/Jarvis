package com.project.jarvis.service.impl;

import com.project.jarvis.dto.subscription.PlanLimitResponse;
import com.project.jarvis.dto.subscription.UsageTodayResponse;
import com.project.jarvis.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }

}
