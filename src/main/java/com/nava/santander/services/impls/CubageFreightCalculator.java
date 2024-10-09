package com.nava.santander.services.impls;

import com.nava.santander.controller.dtos.FreightRequest;
import com.nava.santander.domain.DistanceApp;
import com.nava.santander.controller.dtos.FreightResponse;
import com.nava.santander.domain.Packages;
import com.nava.santander.services.DistanceService;
import com.nava.santander.services.FreightCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Service
public class CubageFreightCalculator implements FreightCalculator {
    private static final double TARIFF_POR_M3 = 3.00;
    private static final double TARIFF_POR_KM = 2.50;
    private static final double TOTAL_FIX_COST = 10.00;
    private static final double CUBING_FACTOR = 300;

    @Autowired
    private DistanceService distanceService;

    @Override
    public FreightResponse calculateFreight(FreightRequest request) {
        double totalVolume = 0.00;

        for (Packages pak : request.packages()) {
            totalVolume += pak.getVolume();
        }

        DistanceApp distanceApp = distanceService.getDistance(request.addresses());

        double costPackage = totalVolume * CUBING_FACTOR * TARIFF_POR_M3;

        double costFix = TOTAL_FIX_COST;
        double costDistance = distanceApp.getDistance() * TARIFF_POR_KM;
        double estimateDays = Double.valueOf(distanceApp.getDays()).shortValue();

        double totalCost = costPackage + costFix + costDistance;

        return new FreightResponse(
                BigDecimal.valueOf(totalCost).round(new MathContext(2, RoundingMode.HALF_UP)),
                BigDecimal.valueOf(costFix).round(new MathContext(2,RoundingMode.HALF_UP)),
                BigDecimal.valueOf(costDistance).round(new MathContext(2,RoundingMode.HALF_UP)),
                BigDecimal.valueOf(costPackage).round(new MathContext(2, RoundingMode.HALF_UP)),
                estimateDays);
    }
}
