package com.example.Insurance_backend.service;

import com.example.Insurance_backend.dto.InsuranceDto;

import java.util.List;

public interface InsuranceService {
    List<InsuranceDto> getAllInsuranceProducts();
    InsuranceDto saveInsuranceProduct(InsuranceDto productDto);
    InsuranceDto getInsuranceProductById(Long productId);
    InsuranceDto updateInsuranceProduct(Long productId, InsuranceDto productDto);
    void deleteInsuranceProductById(Long productId);
}

