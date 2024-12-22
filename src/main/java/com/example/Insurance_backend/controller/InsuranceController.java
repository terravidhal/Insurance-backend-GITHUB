package com.example.Insurance_backend.controller;

import com.example.Insurance_backend.dto.InsuranceDto;
import com.example.Insurance_backend.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {

    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {

        this.insuranceService = insuranceService;
    }

    // Create Insurance Product
    @PostMapping
    public ResponseEntity<InsuranceDto> createInsuranceProduct(@RequestBody InsuranceDto insuranceDto) {
        InsuranceDto savedProduct = insuranceService.saveInsuranceProduct(insuranceDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Get All Insurance Products
    @GetMapping
    public ResponseEntity<List<InsuranceDto>> getAllInsuranceProducts() {
        List<InsuranceDto> products = insuranceService.getAllInsuranceProducts();
        return ResponseEntity.ok(products);
    }

    // Get Insurance Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceDto> getInsuranceProductById(@PathVariable("id") Long productId) {
        InsuranceDto product = insuranceService.getInsuranceProductById(productId);
        return ResponseEntity.ok(product);
    }

    // Update Insurance Product
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceDto> updateInsuranceProduct(
            @PathVariable("id") Long productId,
            @RequestBody InsuranceDto insuranceDto) {
        InsuranceDto updatedProduct = insuranceService.updateInsuranceProduct(productId, insuranceDto);
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete Insurance Product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsuranceProduct(@PathVariable("id") Long productId) {
        insuranceService.deleteInsuranceProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
