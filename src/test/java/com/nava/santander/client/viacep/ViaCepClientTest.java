package com.nava.santander.client.viacep;

import com.nava.santander.client.viacep.dto.AddressDto;
import com.nava.santander.services.CalculateShippingService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ViaCepClientTest {

    @Autowired
     CalculateShippingService service;

    @Test
    void validateCep() {
        String cep = "17500100";
        AddressDto addressDto = (AddressDto) service.calculate(cep);
        assertNotNull(addressDto);
    }
}