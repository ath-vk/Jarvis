package com.project.jarvis.service.impl;

import com.project.jarvis.dto.subscription.CheckoutRequest;
import com.project.jarvis.dto.subscription.CheckoutResponse;
import com.project.jarvis.dto.subscription.PortalResponse;
import com.project.jarvis.dto.subscription.SubscriptionResponse;
import com.project.jarvis.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
