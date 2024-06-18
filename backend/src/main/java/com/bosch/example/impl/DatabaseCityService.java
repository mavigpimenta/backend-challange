package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.City;
import com.bosch.example.repositories.CityJPARepository;
import com.bosch.example.services.CityService;

public class DatabaseCityService implements CityService {

    @Autowired
    CityJPARepository repo;

    @Override
    public List<City> findbyCity(String city) {
        return repo.findByNameContaining(city);
    }

    @Override
    public List<City> allCities() {
        return repo.findAll();
    }
}

