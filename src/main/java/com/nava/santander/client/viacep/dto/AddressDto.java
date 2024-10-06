package com.nava.santander.client.viacep.dto;

public record AddressDto(
        String cep,
        String state,
        String city,
        String neighborhood,
        String street,
        LocationRecord location) {
}
