package com.nava.santander.controller.dtos;

import com.nava.santander.domain.Addresses;
import com.nava.santander.domain.Packages;

import java.math.BigDecimal;
import java.util.List;

public record FreightRequest(
        Addresses addresses,
        List<Packages> packages,
        BigDecimal value
) {
}
