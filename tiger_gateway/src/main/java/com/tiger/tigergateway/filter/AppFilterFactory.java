package com.tiger.tigergateway.filter;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @Author: achilles
 * @Date: 2024/5/29
 * @Time: 11:18
 * @Remark:
 */

@Component
public class AppFilterFactory extends AbstractGatewayFilterFactory<AppFilterFactory.AppConfig> {


    public AppFilterFactory() {
        super(AppFilterFactory.AppConfig.class);
    }

    @Override
    public GatewayFilter apply(String routeId, Consumer<AppConfig> consumer) {
        return super.apply(routeId, consumer);
    }

    @Override
    public GatewayFilter apply(AppFilterFactory.AppConfig config) {
        System.out.println("AppFilterFactory::apply(TigerFilterConfig config)");
        return (exchange, chain) -> {
            // 在这里添加你的过滤逻辑
            if (config.isEnabled()) {
                // 判断是否启用过滤器
            }
            //动态添加token
            String token = exchange.getRequest().getHeaders().getFirst(config.getFromRequestHeaderToken());
            if (Objects.isNull(token)) {
                token = "token:" + UUID.randomUUID();
            }
            //动态设置token
            exchange.getRequest().mutate().header(config.getToAppHeaderToken(), token);
            System.out.println("Processing request with RouteFilter");

            // 前置处理逻辑
            //exchange.getRequest().mutate().header(config.getName(), config.getValue()).build();

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // 后置处理逻辑
                System.out.println("Post-processing request with RouteFilter");
            }));
        };
    }

    public static class AppConfig {
        @NotEmpty(message = "fromRequestHeaderToken is not null")
        private String fromRequestHeaderToken;
        @NotEmpty(message = "toAppHeaderToken is not null")
        private String toAppHeaderToken;
        @NotNull(message = "enabled is not null")
        private boolean enabled;

        public String getFromRequestHeaderToken() {
            return fromRequestHeaderToken;
        }

        public void setFromRequestHeaderToken(String fromRequestHeaderToken) {
            this.fromRequestHeaderToken = fromRequestHeaderToken;
        }

        public String getToAppHeaderToken() {
            return toAppHeaderToken;
        }

        public void setToAppHeaderToken(String toAppHeaderToken) {
            this.toAppHeaderToken = toAppHeaderToken;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }


}
