package com.example.Insurance_backend.controller;

import com.example.Insurance_backend.dto.SubscriptionDto;
import com.example.Insurance_backend.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    // Create Subscription
    @PostMapping
    public ResponseEntity<SubscriptionDto> createSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        SubscriptionDto savedSubscription = subscriptionService.saveSubscription(subscriptionDto);
        return new ResponseEntity<>(savedSubscription, HttpStatus.CREATED);
    }

    // Get Subscription by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDto> getSubscriptionById(@PathVariable("id") Long subscriptionId) {
        SubscriptionDto subscriptionDto = subscriptionService.getSubscriptionById(subscriptionId);
        return ResponseEntity.ok(subscriptionDto);
    }

    // Get All Subscriptions
    @GetMapping
    public ResponseEntity<List<SubscriptionDto>> getAllSubscriptions() {
        List<SubscriptionDto> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    // Update Subscription
    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDto> updateSubscription(
            @PathVariable("id") Long subscriptionId,
            @RequestBody SubscriptionDto subscriptionDto) {
        SubscriptionDto updatedSubscription = subscriptionService.updateSubscription(subscriptionId, subscriptionDto);
        return ResponseEntity.ok(updatedSubscription);
    }

    // Delete Subscription
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable("id") Long subscriptionId) {
        subscriptionService.deleteSubscriptionById(subscriptionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
