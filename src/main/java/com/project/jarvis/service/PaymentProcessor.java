package com.project.jarvis.service;

import com.project.jarvis.dto.subscription.CheckoutRequest;
import com.project.jarvis.dto.subscription.CheckoutResponse;
import com.project.jarvis.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);
    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
