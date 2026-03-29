package com.johnny.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayApplication.class, args);

        // 打印 Nacos 配置是否拉到
        Environment env = context.getEnvironment();
        System.out.println("spring.cloud.gateway.routes: " + env.getProperty("spring.cloud.gateway.routes"));
    }

    @Autowired
    RouteDefinitionLocator locator;

    @PostConstruct
    public void test() {
        locator.getRouteDefinitions().subscribe(System.out::println);
    }
}
