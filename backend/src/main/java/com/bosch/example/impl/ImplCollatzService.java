package com.bosch.example.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.bosch.example.dto.Collatz;
import com.bosch.example.services.CollatzService;

public class ImplCollatzService implements CollatzService {
    @Override
    public Collatz CollatzFormula(Integer current, Integer step) {
        if (current < 0 || step < 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "Number < 0!!!"
            );
        }

        for (int i = 0; i < step; i ++) {
            if (current % 2 == 0) {
                current = current / 2;
            } else {
                current = 3 * current + 1;
            }
        }
        return new Collatz(current);
    }
}