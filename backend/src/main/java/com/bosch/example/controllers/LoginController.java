package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bosch.example.dto.Login;
import com.bosch.example.dto.Token;
import com.bosch.example.impl.KeyPairManager;
import com.bosch.example.impl.UserEncoder;
import com.bosch.example.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginController {
    @Autowired
    UserService service;

    @Autowired
    KeyPairManager keyPair;

    UserEncoder encoder = new UserEncoder();

    @PostMapping("/login")
    public Token tryLogin(@RequestBody Login login) {
        var users = service.findByUsername(login.login());
        users = users.size() > 0 ? users :
            service.findByEmail(login.login());

        if (users.size() == 0) {
            return new Token(null, "Usuário não encontrado");
        }

        var user = users.get(0);

        if (!encoder.compare(login.password(), user.getPassword())) {
            return new Token(null, "Senha incorreta");
        }

        Algorithm algorithm = Algorithm.RSA256(
            keyPair.getRSAPublicKey(), 
            keyPair.getRSAPrivateKey()
        );

        String token = JWT.create()
            .withIssuer("auth0")
            .withSubject(user.getId().toString())
            .sign(algorithm);

        return new Token(token, "Sucesso!");
    }
}
