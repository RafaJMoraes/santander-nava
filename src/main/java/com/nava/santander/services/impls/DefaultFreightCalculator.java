package com.nava.santander.services.impls;

import com.nava.santander.controller.dtos.FreightRequest;
import com.nava.santander.domain.DistanceApp;
import com.nava.santander.controller.dtos.FreightResponse;
import com.nava.santander.domain.Packages;
import com.nava.santander.services.DistanceService;
import com.nava.santander.services.FreightCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DefaultFreightCalculator implements FreightCalculator {
    private static final double TARIFF_POR_M3 = 3.00;
    private static final double TARIFF_POR_KM = 1.00;
    private static final double TOTAL_FIX_COST = 50.00;
    private static final double CUBING_FACTOR = 300;

    private final DistanceService distanceService;

    @Override
    public FreightResponse calculateFreight(FreightRequest request) {
        double totalVolume = 0.0;
        double totalWeight = 0.0;

        for (Packages pak : request.packages()) {
            totalVolume += pak.getVolume();
            totalWeight += Math.max(pak.getWeightKg(), pak.getCubicWeight(CUBING_FACTOR));
        }

        DistanceApp distanceApp = distanceService.getDistance(request.addresses());

        double costPackage = totalVolume * TARIFF_POR_M3;
        double costFix = TOTAL_FIX_COST / totalWeight;
        double costDistance = distanceApp.getDistance() * TARIFF_POR_KM;
        double estimateDays = distanceApp.getDays();

        double totalCost = costPackage + costFix + costDistance;

        return new FreightResponse(totalCost, costFix, costDistance, costPackage, estimateDays);
    }
}
