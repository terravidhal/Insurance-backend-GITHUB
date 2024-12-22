package com.example.Insurance_backend.dto;

public class InsuranceDto {
    private Long id;
    private String name;
    private String description;
    private Double amount;

    public InsuranceDto() {
    }

    public InsuranceDto(Long id, String name, String description, Double amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
