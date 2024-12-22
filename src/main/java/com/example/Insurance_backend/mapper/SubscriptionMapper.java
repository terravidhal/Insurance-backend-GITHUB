package com.example.Insurance_backend.mapper;


import com.example.Insurance_backend.dto.SubscriptionDto;
import com.example.Insurance_backend.entity.Insurance;
import com.example.Insurance_backend.entity.Subscription;
import com.example.Insurance_backend.entity.User;
public class SubscriptionMapper {

    public static SubscriptionDto mapToSubscriptionDto(Subscription subscription) {
        SubscriptionDto dto = new SubscriptionDto();
        dto.setId(subscription.getId());
        dto.setSubscriptionDate(subscription.getSubscriptionDate());
        dto.setCoverageStartDate(subscription.getCoverageStartDate());
        dto.setCoverageEndDate(subscription.getCoverageEndDate());
        dto.setTotalAmount(subscription.getTotalAmount());


        if (subscription.getProduct() != null) {
            dto.setProduct(subscription.getProduct().getId());
        }


        if (subscription.getUser() != null) {
            dto.setUser(subscription.getUser().getId());
        }

        return dto;
    }

    public static Subscription mapToSubscription(SubscriptionDto dto) {
        Subscription subscription = new Subscription();
        subscription.setId(dto.getId());
        subscription.setSubscriptionDate(dto.getSubscriptionDate());
        subscription.setCoverageStartDate(dto.getCoverageStartDate());
        subscription.setCoverageEndDate(dto.getCoverageEndDate());
        subscription.setTotalAmount(dto.getTotalAmount());


        if (dto.getProduct() != null) {
            Insurance insurance = new Insurance();
            insurance.setId(dto.getProduct());
            subscription.setProduct(insurance);
        }


        if (dto.getUser() != null) {
            User user = new User();
            user.setId(dto.getUser());
            subscription.setUser(user);
        }

        return subscription;
    }
}


