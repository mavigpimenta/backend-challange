package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.Collatz;
import com.bosch.example.services.CollatzService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CollatzController {
    @Autowired
    CollatzService service;
    
    @GetMapping("/collatz")
    public Collatz getNumbersCollatz(@RequestParam Integer current, @RequestParam Integer step) {
        return service.CollatzFormula(current, step);
    }
}
