package com.nava.santander.controller.dtos;


import lombok.Builder;

@Builder
public record GoogleRequest(
        String originLatitude,
        String originLongitude,
        String destinationLatitude,
        String destinationLongitude
) {
}
