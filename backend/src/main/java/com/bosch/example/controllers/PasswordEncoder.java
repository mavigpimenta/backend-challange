package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.impl.UserEncoder;
import com.bosch.example.model.User;
import com.bosch.example.services.UserService;

@RestController
public class PasswordEncoder {
    @Autowired 
    UserService service;

    UserEncoder encoder = new UserEncoder();

    @PostMapping("/user")
    public String postUser(@RequestBody User user) {
        Boolean verifyUser = service.verifyUser(user);
        Boolean verifyPass = service.verifyPassword(user);
        Boolean verifyEmail = service.verifyEmail(user);

        if (!verifyUser) {
            return "Usuário ou Email já existem";
        }
        if (!verifyEmail) {
            return "Email em formato errado. Digite 'exemplo@exemplo.exemplo'";
        }
        if (!verifyPass) {
            return "Senha em formato errado. Digite pelo menos um caractere maiúsculo, um caractere especial, um número e mais de 8 dígitos";
        }
        
        String newPass = encoder.getEncoder(user.getPassword());
        user.setPassword(newPass);
        service.save(user);
        return "Usuário salvo com sucesso!";
    }
}
