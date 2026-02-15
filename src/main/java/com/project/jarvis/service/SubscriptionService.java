package com.project.jarvis.service;

import com.project.jarvis.dto.subscription.CheckoutRequest;
import com.project.jarvis.dto.subscription.CheckoutResponse;
import com.project.jarvis.dto.subscription.PortalResponse;
import com.project.jarvis.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);
    PortalResponse openCustomerPortal(Long userId);
}
