
package com.nava.santander.infrastructure.google.dto;

public record Distance (
     String text,
     Integer value){


    public long getValue() {
        return value/1000;
    }
}
