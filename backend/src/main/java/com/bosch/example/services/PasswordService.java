package com.bosch.example.services;

import com.bosch.example.dto.Password;

public interface PasswordService {
    Boolean verifyPassword(Password pass);
} 
