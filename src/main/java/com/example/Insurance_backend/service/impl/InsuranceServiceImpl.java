package com.example.Insurance_backend.service.impl;

import com.example.Insurance_backend.dto.InsuranceDto;
import com.example.Insurance_backend.entity.Insurance;
import com.example.Insurance_backend.exception.ResourceNotFoundException;
import com.example.Insurance_backend.mapper.InsuranceMapper;
import com.example.Insurance_backend.repository.InsuranceRepository;
import com.example.Insurance_backend.service.InsuranceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {

        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public List<InsuranceDto> getAllInsuranceProducts() {
        return insuranceRepository.findAll()
                .stream()
                .map(InsuranceMapper::mapToInsuranceDto)
                .toList();
    }

    @Override
    public InsuranceDto saveInsuranceProduct(InsuranceDto productDto) {
        Insurance product = InsuranceMapper.mapToInsurance(productDto);
        Insurance savedProduct = insuranceRepository.save(product);
        return InsuranceMapper.mapToInsuranceDto(savedProduct);
    }

    @Override
    public InsuranceDto getInsuranceProductById(Long productId) {
        Insurance product = insuranceRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance Product not found with ID: " + productId));
        return InsuranceMapper.mapToInsuranceDto(product);
    }

    @Override
    public InsuranceDto updateInsuranceProduct(Long productId, InsuranceDto productDto) {

        Insurance existingInsurance = insuranceRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance product not found with ID: " + productId));


        existingInsurance.setName(productDto.getName());
        existingInsurance.setDescription(productDto.getDescription());
        existingInsurance.setAmount(productDto.getAmount());


        Insurance updatedInsurance = insuranceRepository.save(existingInsurance);


        return InsuranceMapper.mapToInsuranceDto(updatedInsurance);
    }

    @Override
    public void deleteInsuranceProductById(Long productId) {
        if (!insuranceRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Insurance Product not found with ID: " + productId);
        }
        insuranceRepository.deleteById(productId);
    }
}

