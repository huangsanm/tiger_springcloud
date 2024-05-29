package com.tiger.tigerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TigerAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(TigerAppApplication.class, args);
    }
}
