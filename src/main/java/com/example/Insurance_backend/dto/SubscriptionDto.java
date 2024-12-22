package com.example.Insurance_backend.dto;



import java.time.LocalDate;

public class SubscriptionDto {
    private Long id;
    private LocalDate subscriptionDate;
    private LocalDate coverageStartDate;
    private LocalDate coverageEndDate;
    private Double totalAmount;
    private Long product;
    private Long user;

    public SubscriptionDto() {

    }

    public SubscriptionDto(Long id, LocalDate subscriptionDate, LocalDate coverageStartDate, LocalDate coverageEndDate, Double totalAmount, Long product, Long user) {
        this.id = id;
        this.subscriptionDate = subscriptionDate;
        this.coverageStartDate = coverageStartDate;
        this.coverageEndDate = coverageEndDate;
        this.totalAmount = totalAmount;
        this.product = product;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public LocalDate getCoverageStartDate() {
        return coverageStartDate;
    }

    public void setCoverageStartDate(LocalDate coverageStartDate) {
        this.coverageStartDate = coverageStartDate;
    }

    public LocalDate getCoverageEndDate() {
        return coverageEndDate;
    }

    public void setCoverageEndDate(LocalDate coverageEndDate) {
        this.coverageEndDate = coverageEndDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }


    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
