package com.johnny.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();

        String path = exchange.getRequest().getURI().getPath();
        System.out.println("[Gateway] 请求路径: " + path);
        System.out.println("[Gateway] 请求开始时间: " + startTime);

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long endTime = System.currentTimeMillis();
            System.out.println("[Gateway] 请求结束时间: " + endTime);
            System.out.println("[Gateway] 耗时: " + (endTime - startTime) + " ms");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
