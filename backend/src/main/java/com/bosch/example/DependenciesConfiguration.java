package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseCityService;
import com.bosch.example.impl.DatabaseUserService;
import com.bosch.example.impl.ImplCEPService;
import com.bosch.example.impl.ImplCPFService;
import com.bosch.example.impl.ImplCollatzService;
import com.bosch.example.impl.ImplNumberService;
import com.bosch.example.impl.ImplPasswordService;
import com.bosch.example.impl.ImplReverseService;
import com.bosch.example.impl.KeyPairManager;
import com.bosch.example.services.CEPService;
import com.bosch.example.services.CPFService;
import com.bosch.example.services.CityService;
import com.bosch.example.services.CollatzService;
import com.bosch.example.services.PasswordService;
import com.bosch.example.services.ReverseService;
import com.bosch.example.services.UserService;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope("singleton")
    public ImplReverseService reverseService() {
        return new ImplReverseService();
    }

    @Bean
    @Scope("singleton")
    public ImplNumberService numberService() {
        return new ImplNumberService();
    }

    @Bean
    @Scope("singleton")
    public CollatzService collatzService() {
        return new ImplCollatzService();
    }

    @Bean
    @Scope("singleton")
    public CEPService CEPService() {
        return new ImplCEPService();
    }

    @Bean
    @Scope("singleton")
    public CPFService CPFService() {
        return new ImplCPFService();
    }

    @Bean
    @Scope("singleton")
    public CityService cityService() {
        return new DatabaseCityService();
    }

    @Bean 
    @Scope("singleton")
    public UserService userService() {
        return new DatabaseUserService();
    }
    
    @Bean
    @Scope("singleton")
    public PasswordService passService() {
        return new ImplPasswordService();
    }

    @Bean
    @Scope("singleton")
    public KeyPairManager keyManager() {
        return new KeyPairManager();
    }
}
