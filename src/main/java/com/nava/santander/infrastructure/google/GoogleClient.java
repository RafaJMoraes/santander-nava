package com.nava.santander.infrastructure.google;


import com.nava.santander.infrastructure.google.dto.GoogleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "google", url = "https://maps.googleapis.com/maps/api/distancematrix/json")
//    @FeignClient(name = "google", url = "http://localhost:8081/api/v1/shipping/calculate")
public interface GoogleClient {

    @GetMapping(path = "", params = {"origins", "destinations", "key"})
    GoogleResponse getDistanceMatrix(@RequestParam("origins") String origin, @RequestParam("destinations") String destinations,
                                     @RequestParam("key") String key);
}
