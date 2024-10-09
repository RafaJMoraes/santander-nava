package com.nava.santander.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public record Addresses(
        @Schema(description = "Latitude da Origem") Long originLatitude,
        @Schema(description = "Longitude da Origem") Long originLongitude,
        @Schema(description = "Latitude do Destino") Long destinationLatitude,
        @Schema(description = "Longitude do Destino") Long destinationLongitude
) {
}
