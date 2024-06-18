package com.bosch.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CityData")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id;  
    
    @Column(name = "Name")
    private String name;

    @Column(name = "State")
    private String state;
    
    @Column(name = "Country")
    private String country;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String city) {
        this.name = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String contry) {
        this.country = contry;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


