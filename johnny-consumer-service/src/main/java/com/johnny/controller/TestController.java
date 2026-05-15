package com.johnny.controller;

import com.johnny.config.TestConfig;
import com.johnny.service.ProviderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class TestController {

    @Resource
    private ProviderClient providerClient;

    @Resource
    private TestConfig testConfig;

    @Value("${lxqy.jkyp}")
    private String jkyp;

    @Value("${lxqy.zhfw}")
    private String zhfw;

    @GetMapping("/call")
    public String call() {
        System.out.println(testConfig.getUcc());
        System.out.println(testConfig.getUass());
        System.out.println(jkyp);
        System.out.println(zhfw);
//        return providerClient.hello();
        return "success";
    }
}
