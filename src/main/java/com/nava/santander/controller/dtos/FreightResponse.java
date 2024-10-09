package com.nava.santander.controller.dtos;

import java.math.BigDecimal;

public record FreightResponse(
        BigDecimal totalCost, BigDecimal costFix, BigDecimal costDistance, BigDecimal costPackage, double estimateDays) {
}
