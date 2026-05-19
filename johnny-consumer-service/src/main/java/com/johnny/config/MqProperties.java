package com.johnny.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="spring.rocketmq")
@Data
public class MqProperties {

    private String namesrv;
    private String producerGroup;

}


