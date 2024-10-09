package com.nava.santander.client.viacep;

import com.nava.santander.domain.CepApp;
import com.nava.santander.infrastructure.viacep.BrazilApiClient;
import com.nava.santander.infrastructure.viacep.dto.CepBrazilResponse;
import com.nava.santander.infrastructure.viacep.dto.CoordinatesRecord;
import com.nava.santander.infrastructure.viacep.dto.LocationRecord;
import com.nava.santander.services.CepService;
import com.nava.santander.services.impls.CalculateShippingServicesImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ViaCepClientTest {

    @Mock
    BrazilApiClient brazilApiClient;
    @InjectMocks
    CepService service;

    @Test
    void validateCep() {
        CepBrazilResponse dto = new CepBrazilResponse("123","teste","city","bairro","rua 7",
                new LocationRecord("",new CoordinatesRecord(12,12)));
        when(brazilApiClient.validateCep("17500100")).thenReturn(dto);
        String cep = "17500100";
        CepApp cepApp = service.validateCEP(cep);
        assertEquals("123",cepApp.cep());
        assertNotEquals("test",cepApp.state());
        assertNotNull(cepApp);
    }
}