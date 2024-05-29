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
 * @Date: 2024/5/27
 * @Time: 11:49
 * @Remark:
 * 路由拦截器
 */
@Component
public class AdminFilterFactory extends AbstractGatewayFilterFactory<AdminFilterFactory.RouteConfig> {


    public AdminFilterFactory() {
        super(RouteConfig.class);
    }

    @Override
    public GatewayFilter apply(RouteConfig config) {
        System.out.println("RouteFilter::apply(TigerFilterConfig config)");
        return (exchange, chain) -> {
            // 在这里添加你的过滤逻辑
            if (config.isEnabled()) {
                // 判断是否启用过滤器
            }
            //动态添加token
            String token = exchange.getRequest().getHeaders().getFirst(config.getRequestHeaderTokenName());
            if (Objects.isNull(token)) {
                token = "token:" + UUID.randomUUID();
            }
            //动态设置token
            exchange.getRequest().mutate().header(config.getAdminHeaderTokenName(), token);
            System.out.println("Processing request with RouteFilter");

            // 前置处理逻辑
            //exchange.getRequest().mutate().header(config.getName(), config.getValue()).build();

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // 后置处理逻辑
                System.out.println("Post-processing request with RouteFilter");
            }));
        };
    }

    @Override
    public GatewayFilter apply(String routeId, Consumer<RouteConfig> consumer) {
        System.out.println("RouteFilter::apply(String routeId, Consumer<TigerFilterConfig> consumer),routeId=" + routeId);
        RouteConfig config = new RouteConfig();
        consumer.accept(config);
        return apply(config);
    }

    /**
     * 配置规则
     */
    public static class RouteConfig {
        @NotEmpty(message = "requestHeaderTokenName is not null")
        private String requestHeaderTokenName;
        @NotEmpty(message = "adminHeaderTokenName is not null")
        private String adminHeaderTokenName;
        @NotNull(message = "enabled is not null")
        private boolean enabled;

        public String getRequestHeaderTokenName() {
            return requestHeaderTokenName;
        }

        public void setRequestHeaderTokenName(String requestHeaderTokenName) {
            this.requestHeaderTokenName = requestHeaderTokenName;
        }

        public String getAdminHeaderTokenName() {
            return adminHeaderTokenName;
        }

        public void setAdminHeaderTokenName(String adminHeaderTokenName) {
            this.adminHeaderTokenName = adminHeaderTokenName;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }


}
