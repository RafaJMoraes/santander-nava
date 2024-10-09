package com.nava.santander.services.impls;

import com.nava.santander.controller.dtos.FreightRequest;
import com.nava.santander.controller.dtos.FreightResponse;
import com.nava.santander.services.FreightCalculator;
import com.nava.santander.infrastructure.google.GoogleClient;
import com.nava.santander.infrastructure.viacep.BrazilApiClient;
import com.nava.santander.services.CalculateShippingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class CalculateShippingServicesImpl implements CalculateShippingService {

    private final FreightCalculator calculator;

    @Autowired
    CalculateShippingServicesImpl(CubageFreightCalculator calculator) {
        this.calculator = Optional.ofNullable(calculator).orElse(new CubageFreightCalculator());
    }

    /**
     * @param freightRequest request
     * */
    @Override
    public FreightResponse calculate(FreightRequest freightRequest) {
        return calculator.calculateFreight(freightRequest);
    }



}
