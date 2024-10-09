package com.nava.santander.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

public record Packages(
        @Schema( description = "altura em cm") Integer height,
        @Schema(description = "largura em cm") Integer width,
        @Schema(description = "profundidade em cm") Integer depth,
        @Schema(description = "peso em gr") Integer weight
) {

    @JsonIgnore
    public double getVolume() {
        return (depth / 100.00) * (weight / 100.00) * (height / 100.00);
    }
    @JsonIgnore
    public double getWeightKg() {
        return weight / 1000.0;
    }
    @JsonIgnore
    public double getCubicWeight(double factor) {
        return getVolume() * factor;
    }
}
