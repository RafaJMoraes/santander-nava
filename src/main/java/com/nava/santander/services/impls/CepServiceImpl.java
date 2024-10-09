package com.nava.santander.services.impls;

import com.nava.santander.domain.CepApp;
import com.nava.santander.infrastructure.viacep.BrazilApiClient;
import com.nava.santander.infrastructure.viacep.dto.CepBrazilResponse;
import com.nava.santander.services.CepService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Log4j2
@RequiredArgsConstructor
@Service
public class CepServiceImpl implements CepService {

    private final BrazilApiClient client;

    @Override
    public CepApp validateCEP(String cep) {
        try {
            CepBrazilResponse responseClient = client.validateCep(cep);
            return CepApp.builder()
                    .cep(responseClient.cep())
                    .state(responseClient.state())
                    .street(responseClient.street())
                    .latitude(String.valueOf(responseClient.location().coordinates().latitude()))
                    .longitude(String.valueOf(responseClient.location().coordinates().longitude()))
                    .build();
        } catch (FeignException.BadRequest e) {
            log.info("Error in find cep: {}",e.getMessage());
            throw e;
        } catch (FeignException.NotFound e) {
            log.error("CEP not found: {}",e.getMessage());
            throw  e;
        }
    }
}
