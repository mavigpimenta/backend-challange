package com.bosch.example.impl;

import com.bosch.example.services.CPFService;

public class ImplCPFService implements CPFService {
    @Override
    public Boolean CPFValidate(String cpf) {
        if (cpf.length() != 11) {
            return false;
        } 
      
        int sum = 0;
      
        for (int i = 0; i < 9; i++) {
            sum += (10 - i) * (int)(cpf.charAt(i) - 48);
        }
        int r = 11 - (sum % 11);
        char firstDigit = r == 10 || r == 11 ? '0' : (char)(r + 48);
      
        sum = 0;
      
        for (int i = 0; i < 10; i++) {
            sum += (11 - i) * (int)(cpf.charAt(i) - 48);
        }
      
        r = 11 - (sum % 11);
        char secondDigit = r == 10 || r == 11 ? '0' : (char)(r + 48);
      
        if ((firstDigit == cpf.charAt(9)) && (secondDigit == cpf.charAt(10)))
            return true;
        else {
            return false;
        }
    }
}
    

