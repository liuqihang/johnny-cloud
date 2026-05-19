package com.johnny.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix="custom.rocketmq")
public class MultiProperties {

    public Map<String,MqProperties> configObjects = new HashMap<>();

    public MqProperties get(String key){
        return this.configObjects.get(key);
    }

    public Map<String,MqProperties> getAll(){
        return configObjects;
    }


}
