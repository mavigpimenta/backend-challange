package com.bosch.example.impl;

import org.springframework.web.client.RestTemplate;
import com.bosch.example.dto.ViaCEPResponse;
import com.bosch.example.services.CEPService;

public class ImplCEPService implements CEPService {
    RestTemplate restTemplate;

    @Override
    public Boolean CEPValidate(String cep) {

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ViaCEPResponse response = restTemplate.getForObject(url, ViaCEPResponse.class);
        
        if (response != null && response.getLocalidade() != null && response.getLocalidade().equalsIgnoreCase("Curitiba")) {
            return true;
        } else {
            return false;
        }
    }   
}
