package com.project.jarvis.service.impl;

import com.project.jarvis.dto.subscription.CheckoutRequest;
import com.project.jarvis.dto.subscription.CheckoutResponse;
import com.project.jarvis.dto.subscription.PortalResponse;
import com.project.jarvis.dto.subscription.SubscriptionResponse;
import com.project.jarvis.entity.Subscription;
import com.project.jarvis.enums.SubscriptionStatus;
import com.project.jarvis.repository.SubscriptionRepository;
import com.project.jarvis.security.AuthUtil;
import com.project.jarvis.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final AuthUtil authUtil;
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public SubscriptionResponse getCurrentSubscription() {
        Long userId = authUtil.getCurrentUserId();

        var currentSubscription = subscriptionRepository.findByUserIdAndStatusIn(userId, Set.of(
                SubscriptionStatus.ACTIVE, SubscriptionStatus.PAST_DUE,
                SubscriptionStatus.TRIALING
        )).orElse(
                new Subscription()
        );

        return subscriptionMapper.toSubscriptionResponse(currentSubscription);
    }

    @Override
    public void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId) {

    }

    @Override
    public void updateSubscription(String subscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId) {

    }

    @Override
    public void cancelSubscription(String subscriptionId) {

    }

    @Override
    public void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd) {

    }

    @Override
    public void markSubscriptionPastDue(String subId) {

    }
}
