package com.nava.santander.controller;


import com.nava.santander.controller.dtos.RestResponse;
import com.nava.santander.services.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class CepController {


    private final CepService cepService;

    @GetMapping(path = "/{cep}")
    public ResponseEntity<RestResponse> getAddress(@PathVariable String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(RestResponse.builder()
                .data(cepService.validateCEP(cep))
                        .code(200)
                        .message("Success!")
                .build());
    }




}
