package com.nava.santander.services;


import com.nava.santander.controller.dtos.FreightRequest;
import com.nava.santander.controller.dtos.FreightResponse;

public interface CalculateShippingService {

    FreightResponse calculate(FreightRequest obj);

}
