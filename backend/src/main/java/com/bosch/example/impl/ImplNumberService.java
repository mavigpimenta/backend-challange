package com.bosch.example.impl;

import com.bosch.example.dto.Number;
import com.bosch.example.services.NumberService;

public class ImplNumberService implements NumberService{
    @Override
    public Number ReAndIm(Double A, double b) {
        Double Re, Im;

        Re = A * Math.sin(b);
        Im = A * Math.cos(b);

        return new Number(Re, Im);
    }
}
