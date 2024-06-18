package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.User;

public interface UserService {
    Boolean verifyUser(User user);
    Boolean verifyPassword(User user);
    Boolean verifyEmail(User user);
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
    void save(User user);
}
