package com.nava.santander.controller.controller;


import com.nava.santander.client.viacep.dto.AddressDto;
import com.nava.santander.services.CalculateShippingService;
import com.nava.santander.services.impls.CalculateShippingServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shipping")
public class CalculateShippingController {

    private final CalculateShippingService service;


    @GetMapping(path = "/{cep}")
    ResponseEntity<AddressDto> getAddress(@PathVariable String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(service.calculate(cep));
    }

    @PostMapping(path = "/calculate")
    ResponseEntity<AddressDto> calculate(@PathVariable String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(service.calculate(cep));
    }
}
