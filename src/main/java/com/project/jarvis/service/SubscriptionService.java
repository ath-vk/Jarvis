package com.project.jarvis.service;

import com.project.jarvis.dto.subscription.CheckoutRequest;
import com.project.jarvis.dto.subscription.CheckoutResponse;
import com.project.jarvis.dto.subscription.PortalResponse;
import com.project.jarvis.dto.subscription.SubscriptionResponse;
import com.project.jarvis.enums.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription();

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String subscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String subscriptionId);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    void markSubscriptionPastDue(String subId);
}
