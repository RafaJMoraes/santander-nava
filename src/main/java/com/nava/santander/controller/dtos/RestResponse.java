package com.nava.santander.controller.dtos;


import lombok.Builder;

@Builder
public record RestResponse(
        String message,
        Integer code,
        Object data,
        Object errors) {

}
