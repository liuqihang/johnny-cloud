package com.johnny.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("johnny-provider-service")
public interface ProviderClient {

    @GetMapping("/hello")
    String hello();

}
