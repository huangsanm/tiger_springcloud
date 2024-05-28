package com.tiger.tigeradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class TigerAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TigerAdminApplication.class, args);
    }

}
