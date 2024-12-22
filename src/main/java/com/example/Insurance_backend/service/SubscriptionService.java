package com.example.Insurance_backend.service;

import com.example.Insurance_backend.dto.SubscriptionDto;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionDto> getAllSubscriptions();
    SubscriptionDto getSubscriptionById(Long id);
    SubscriptionDto saveSubscription(SubscriptionDto subscriptionDto);
    SubscriptionDto updateSubscription(Long id, SubscriptionDto subscriptionDto);
    void deleteSubscriptionById(Long id);
}
