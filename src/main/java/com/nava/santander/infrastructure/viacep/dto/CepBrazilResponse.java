package com.nava.santander.infrastructure.viacep.dto;

public record CepBrazilResponse(
        String cep,
        String state,
        String city,
        String neighborhood,
        String street,
        LocationRecord location) {
}
