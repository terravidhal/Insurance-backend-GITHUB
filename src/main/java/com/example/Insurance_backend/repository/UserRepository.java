package com.example.Insurance_backend.repository;


import com.example.Insurance_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
