package com.nava.santander.services;


import com.nava.santander.client.viacep.dto.AddressDto;
import com.nava.santander.controller.dtos.GoogleTestDto;

public interface CalculateShippingService {

    AddressDto calculate(Object obj);

    Object test(GoogleTestDto dto);
}
