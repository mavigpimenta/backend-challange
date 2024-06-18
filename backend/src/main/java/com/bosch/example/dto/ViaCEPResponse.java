package com.bosch.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCEPResponse {

    @JsonProperty("localidade")
    private String localidade;

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
