package com.nava.santander.services.impls;

import com.nava.santander.controller.dtos.GoogleRequest;
import com.nava.santander.domain.Addresses;
import com.nava.santander.domain.DistanceApp;
import com.nava.santander.infrastructure.google.GoogleClient;
import com.nava.santander.infrastructure.google.dto.GoogleResponse;
import com.nava.santander.services.DistanceService;
import com.nava.santander.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class DistanceServiceImpl implements DistanceService {
    private GoogleClient googleClient;

    @Value("${google.maps.key}")
    private String googleKey;

    @Override
    public DistanceApp getDistance(Addresses addresses) {
        GoogleRequest request  = GoogleRequest.builder()
                .originLatitude(addresses.originLatitude().toString())
                .originLongitude(addresses.originLongitude().toString())
                .destinationLatitude(addresses.destinationLatitude().toString())
                .destinationLongitude(addresses.destinationLongitude().toString())
                .build();
        GoogleResponse response  = googleClient.getDistanceMatrix(
                generateQueryParamIFOrigin(request, true),
                generateQueryParamIFOrigin(request, false),
                googleKey
        );
        return DistanceApp.builder()
                .distance(response.rows().getFirst().elements().getFirst().distance().getValue())
                .hours(response.rows().getFirst().elements().getFirst().duration().getValue())
                .build();
    }

    private String generateQueryParamIFOrigin(GoogleRequest dto, boolean origin) {
        if(origin)
            return dto.originLatitude() +
                    StringUtils.toConcat +
                    dto.originLongitude();
        return dto.destinationLatitude() +
                StringUtils.toConcat +
                dto.destinationLongitude();
    }



}
