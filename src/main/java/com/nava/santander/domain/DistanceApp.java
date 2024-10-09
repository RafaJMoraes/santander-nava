package com.nava.santander.domain;

import lombok.Builder;

@Builder
public record DistanceApp(long distance, long hours) {
    public double getDays() {
        return hours / 24.0 + 1;
    }
    public double getDistance() {
        return distance * 2;
    }
}
