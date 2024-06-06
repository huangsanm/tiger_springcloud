package com.tiger.tigergateway.filter;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: achilles
 * @Date: 2024/5/27
 * @Time: 22:23
 * @Remark: 全局拦截器
 */
@Component
public class GlobalsFilter implements GlobalFilter, Ordered {


    //可考虑从数据库、mongodb 中读取
    @Value("${spring.cloud.gateway.globalfilters[0].args.blacklist}")
    List<String> blackIpList;

    /**
     * 可以实现黑、白IP名单处理
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params =  request.getQueryParams();
        params.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        String clientIp = request.getRemoteAddress().getAddress().getHostAddress();
        System.out.println("全局拦截器:" + clientIp);
        if (blackIpList.contains(clientIp)) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("全局拦截器结束");
        }));
    }

    /**
     * 定义了过滤器的顺序，值越小，优先级越高。
     * @return
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
