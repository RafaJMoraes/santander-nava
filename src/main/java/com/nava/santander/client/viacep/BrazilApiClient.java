package com.nava.santander.client.viacep;


import com.nava.santander.client.viacep.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brasil-api", url = "https://brasilapi.com.br/api/cep/v2/")
public interface BrazilApiClient {

    @GetMapping(path = "{cep}")
    AddressDto validateCep(@PathVariable("cep") String cep);

}
