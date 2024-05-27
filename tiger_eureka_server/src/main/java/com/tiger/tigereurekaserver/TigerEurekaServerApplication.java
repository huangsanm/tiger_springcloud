package com.tiger.tigereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: achilles
 * @Date: 2024/5/26
 * @Time: 21:29
 * @Remark:
 */

@SpringBootApplication
@EnableEurekaServer
public class TigerEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TigerEurekaServerApplication.class, args);
    }

}
