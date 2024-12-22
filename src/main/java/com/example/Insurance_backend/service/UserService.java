package com.example.Insurance_backend.service;

import com.example.Insurance_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto saveUser(UserDto userDto);
    UserDto getUserById(Long userId);
    UserDto updateUser(Long userId, UserDto userDto);
    void deleteUserById(Long userId);
}
