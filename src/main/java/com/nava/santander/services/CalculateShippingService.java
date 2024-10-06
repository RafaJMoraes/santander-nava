package com.nava.santander.services;


import com.nava.santander.client.viacep.dto.AddressDto;

public interface CalculateShippingService {

    AddressDto calculate(Object obj);

}
