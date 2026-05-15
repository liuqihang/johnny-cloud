package com.johnny.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="smarto")
@Data
public class TestConfig {

    private Boolean uass = true;
    private Boolean ucc = true;


}
