package com.tiger.tigerapp.core;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: achilles
 * @Date: 2024/5/29
 * @Time: 14:52
 * @Remark:
 */
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate ribbonRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }


}
