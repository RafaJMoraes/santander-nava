package com.nava.santander.infrastructure.viacep;


import com.nava.santander.infrastructure.viacep.dto.CepBrazilResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "brasil-api", url = "https://brasilapi.com.br/api/cep/v2/")
@FeignClient(name = "brasil-api", url = "http://localhost:8081/api/v1/shipping")
public interface BrazilApiClient {

    @GetMapping(path = "{cep}")
    CepBrazilResponse validateCep(@PathVariable("cep") String cep);

}
