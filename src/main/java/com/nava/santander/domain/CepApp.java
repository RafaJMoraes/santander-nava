package com.nava.santander.domain;


import lombok.Builder;

@Builder
public record CepApp(String cep, String street, String state, String latitude, String longitude) {
}
