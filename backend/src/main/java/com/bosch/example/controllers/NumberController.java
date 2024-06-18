package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bosch.example.dto.Number;
import com.bosch.example.impl.ImplNumberService;

@RestController
public class NumberController {
    @Autowired
    ImplNumberService service;

    @GetMapping("/imaexp")
    public Number getNumbers(@RequestParam Double A, @RequestParam Double b) {
        return service.ReAndIm(A, b);
    }   
}
