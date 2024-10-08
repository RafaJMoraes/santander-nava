package com.nava.santander.services.impls;

import com.nava.santander.client.google.GoogleClient;
import com.nava.santander.client.viacep.BrazilApiClient;
import com.nava.santander.client.viacep.dto.AddressDto;
import com.nava.santander.controller.dtos.GoogleTestDto;
import com.nava.santander.services.CalculateShippingService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class CalculateShippingServicesImpl implements CalculateShippingService {

    private final BrazilApiClient client;
    private final GoogleClient googleClient;
    @Value("${google.maps.key}")
    private String googleKey;

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

    @Override
    public Object test(GoogleTestDto dto) {
        var response  = googleClient.getDistanceMatrix(
                generateQueryParamIFOrigin(dto, true),
                generateQueryParamIFOrigin(dto, false),
                googleKey
        );

        log.info("response {}", response);

        return response;
    }

    private String generateQueryParamIFOrigin(GoogleTestDto dto, boolean origin) {
        final String toConcat = "%2C";
        if(origin)
            return dto.originLatitude() +
                    toConcat +
                    dto.originLongitude();
        return dto.destinationLatitude() +
                toConcat +
                dto.destinationLongitude();
    }
}
