package com.project.jarvis.service;

import com.project.jarvis.dto.subscription.PlanLimitResponse;
import com.project.jarvis.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
