package com.bosch.example.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserEncoder {
    public String getEncoder(String pass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pass);
    }

    public boolean compare(String pass, String expected)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(pass, expected);
    }
}
