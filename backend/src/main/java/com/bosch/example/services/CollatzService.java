package com.bosch.example.services;

import com.bosch.example.dto.Collatz;

public interface CollatzService {
    public Collatz CollatzFormula(Integer current, Integer step);
}
