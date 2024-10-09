package com.nava.santander.controller.dtos;

public record FreightResponse(
        double totalCost, double costFix, double costDistance, double costPackage, double estimateDyas) {
}
