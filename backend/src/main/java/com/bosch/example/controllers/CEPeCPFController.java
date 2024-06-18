package com.bosch.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bosch.example.dto.CEP;
import com.bosch.example.services.CEPService;
import com.bosch.example.services.CPFService;

@RestController
public class CEPeCPFController {
    @Autowired
    CEPService cepService;

    @Autowired
    CPFService cpfService;
    
    @GetMapping("/curitiba")
    public CEP getCEPeCPF(@RequestParam String cep, @RequestParam String cpf) {
        Boolean resultCPF = cpfService.CPFValidate(cpf);
        Boolean resultCEP = cepService.CEPValidate(cep);
        List<String> list = new ArrayList<>();

        if (cep == null || cpf == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "CEP or CPF is null"
            );
        }
        
        if (!resultCPF) {
            list.add("cpf wrong");
        }
        if (!resultCEP) {
            list.add("cep wrong");
        }
        if (list.size() == 0) {
            list.add("Sucess");
        }

        return new CEP(list, resultCEP && resultCPF);
    }
}
