package com.bosch.example.impl;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class KeyPairManager {
    private KeyPair keyPair;

    public KeyPairManager() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            this.keyPair = kpg.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na geração de chaves RSA");
        }
    }

    public RSAPublicKey getRSAPublicKey() {
        return (RSAPublicKey) this.keyPair.getPublic();
    }

    public RSAPrivateKey getRSAPrivateKey() {
        return (RSAPrivateKey) this.keyPair.getPrivate();
    }
}
