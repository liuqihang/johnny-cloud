package com.johnny.controller;

import com.johnny.service.ProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private ProviderClient providerClient;

    @GetMapping("/call")
    public String call() {
        return providerClient.hello();
    }
}
