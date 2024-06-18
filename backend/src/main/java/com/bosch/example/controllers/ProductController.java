package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.bosch.example.dto.Product;
import com.bosch.example.impl.KeyPairManager;

@RestController
public class ProductController {
    
    @Autowired
    KeyPairManager keyPair;

    @PostMapping("/product")
    public String createProduct(@RequestBody Product product) {
        DecodedJWT decodedJWT;

        try {
            Algorithm algorithm = Algorithm.RSA256(
                keyPair.getRSAPublicKey(), 
                keyPair.getRSAPrivateKey()
            );

            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();

            decodedJWT = verifier.verify(product.token());

            return "Sucesso, token válido!";
        } catch (JWTVerificationException exception){
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Token não válido!"
            );
        }  
    }
}
