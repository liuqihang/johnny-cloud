package com.johnny.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
public class TestController {

    @Value("${applicationName}")
    private String applicationName;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("applicationName: " + applicationName);
        return "hello from provider";
    }

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2, 2000,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(500),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        retry:
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("开始执行：" + finalI);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("执行完毕：" + finalI);

            });
            if(finalI == 499){
                break retry;
            }

        }
    }


}
