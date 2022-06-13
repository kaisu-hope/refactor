package com.kaisu.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author kaisu
 */
@EnableFeignClients
@SpringBootApplication
public class FeignBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(FeignBootstrap.class, args);
    }
}
