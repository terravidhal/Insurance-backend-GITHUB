package com.example.Insurance_backend.service.impl;

import com.example.Insurance_backend.dto.SubscriptionDto;
import com.example.Insurance_backend.entity.Insurance;
import com.example.Insurance_backend.entity.Subscription;
import com.example.Insurance_backend.entity.User;
import com.example.Insurance_backend.exception.ResourceNotFoundException;
import com.example.Insurance_backend.mapper.SubscriptionMapper;
import com.example.Insurance_backend.repository.SubscriptionRepository;
import com.example.Insurance_backend.service.SubscriptionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<SubscriptionDto> getAllSubscriptions() {
        return subscriptionRepository.findAll()
                .stream()
                .map(SubscriptionMapper::mapToSubscriptionDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDto getSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found with ID: " + id));
        return SubscriptionMapper.mapToSubscriptionDto(subscription);
    }

    @Override
    public SubscriptionDto saveSubscription(SubscriptionDto subscriptionDto) {

        Subscription subscription = SubscriptionMapper.mapToSubscription(subscriptionDto);

        Subscription savedSubscription = subscriptionRepository.save(subscription);

        return SubscriptionMapper.mapToSubscriptionDto(savedSubscription);
    }

    @Override
    public SubscriptionDto updateSubscription(Long id, SubscriptionDto subscriptionDto) {

        Subscription existingSubscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found with ID: " + id));


        existingSubscription.setSubscriptionDate(subscriptionDto.getSubscriptionDate());
        existingSubscription.setCoverageStartDate(subscriptionDto.getCoverageStartDate());
        existingSubscription.setCoverageEndDate(subscriptionDto.getCoverageEndDate());
        existingSubscription.setTotalAmount(subscriptionDto.getTotalAmount());


        if (subscriptionDto.getProduct() != null) {
            Insurance insurance = new Insurance();
            insurance.setId(subscriptionDto.getProduct());
            existingSubscription.setProduct(insurance);
        }

        if (subscriptionDto.getUser() != null) {
            User user = new User();
            user.setId(subscriptionDto.getUser());
            existingSubscription.setUser(user);
        }


        Subscription updatedSubscription = subscriptionRepository.save(existingSubscription);


        return SubscriptionMapper.mapToSubscriptionDto(updatedSubscription);
    }

    @Override
    public void deleteSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found with ID: " + id));
        subscriptionRepository.delete(subscription);
    }
}
