package com.example.Insurance_backend.mapper;


import com.example.Insurance_backend.dto.InsuranceDto;
import com.example.Insurance_backend.entity.Insurance;

public class InsuranceMapper {
    public static InsuranceDto mapToInsuranceDto(Insurance insurance) {
        return new InsuranceDto(
                insurance.getId(),
                insurance.getName(),
                insurance.getDescription(),
                insurance.getAmount()
        );
    }

    public static Insurance mapToInsurance(InsuranceDto insuranceDto) {
        return new Insurance(
                insuranceDto.getId(),
                insuranceDto.getName(),
                insuranceDto.getDescription(),
                insuranceDto.getAmount()
        );
    }
}
