package com.nava.santander.services.impls;

import com.nava.santander.client.viacep.BrazilApiClient;
import com.nava.santander.client.viacep.dto.AddressDto;
import com.nava.santander.services.CalculateShippingService;
import feign.Feign;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class CalculateShippingServicesImpl implements CalculateShippingService {

    private final BrazilApiClient client;

    @Override
    public AddressDto calculate(Object obj) {

        AddressDto a = null;
        try {
            a = client.validateCep(obj.toString());
        } catch (FeignException.BadRequest e) {
            log.info("Error in find cep: {}",e.getMessage());
            throw e;
        } catch (FeignException.NotFound e) {
            log.error("CEP not found: {}",e.getMessage());
            throw  e;
        }

        return a;
    }
}
