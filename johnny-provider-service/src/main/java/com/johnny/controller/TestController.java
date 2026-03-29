package com.johnny.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${applicationName}")
    private String applicationName;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("applicationName: " + applicationName);
        return "hello from provider";
    }
}
