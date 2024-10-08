package com.nava.santander.controller.dtos;

public record GoogleTestDto(
        String originLatitude,
        String originLongitude,
        String destinationLatitude,
        String destinationLongitude
) {
}
