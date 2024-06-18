package com.bosch.example.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.Password;
import com.bosch.example.model.User;
import com.bosch.example.services.PasswordService;
import com.bosch.example.services.UserService;

@RestController
public class ChangePassword {
    @Autowired
    UserService service;
    @Autowired
    PasswordService servicePass;

    @PatchMapping("/changepassword")
    public String postUser(@RequestBody Password pass) {
        List<User> listUsers = service.findByUsername(pass.username());
        
        if (listUsers.size() <= 0) {
            return "Usuário não existe";
        }

        User user = listUsers.get(0);

        if (!user.getPassword().equals(pass.password())) {
            return "Senha incorreta";
        }

        if (!servicePass.verifyPassword(pass)) {
            return "Senha em formato errado. Digite pelo menos um caractere maiúsculo, um caractere especial, um número e mais de 8 dígitos";
        }

        if (!pass.newPassword().equals(pass.repeatPassword())) {
            return "As senhas não se coincidem";
        }

        user.setPassword(pass.newPassword());
        service.save(user);
        return "A senha foi alterada com sucesso!";
    }
}
