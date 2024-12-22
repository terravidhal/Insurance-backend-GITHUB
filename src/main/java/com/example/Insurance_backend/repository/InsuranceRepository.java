package com.example.Insurance_backend.repository;

import com.example.Insurance_backend.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}