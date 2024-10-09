package com.nava.santander.controller;


import com.nava.santander.controller.dtos.FreightRequest;
import com.nava.santander.services.CalculateShippingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shipping")
public class CalculateShippingController {

    private final CalculateShippingService service;

    @Operation(summary = "Method to calculate Freight")
    @PostMapping(path = "/calculate")
    ResponseEntity<Object> calculateFreight(@RequestBody FreightRequest dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.calculate(dto));
    }
}
