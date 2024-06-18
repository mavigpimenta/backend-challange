package com.bosch.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.City;
import com.bosch.example.services.CityService;

@RestController
public class CityController {
    @Autowired
    CityService service;

    @GetMapping("cities")
    public List<City> getAllCities() {
        return service.allCities();
    }

    @GetMapping("cities/{query}")
    public List<City> getSearchCity(@PathVariable String query) {
        return service.findbyCity(query);
    }
}
