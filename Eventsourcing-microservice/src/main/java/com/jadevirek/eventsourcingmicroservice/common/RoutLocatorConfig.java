package com.jadevirek.eventsourcingmicroservice.common;

import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

/**
 * Redirection config for cloud gatwey for localhost:9999
 */
@Configuration
public class RoutLocatorConfig {

    private static final String HOST_PATTERN = "*.spring.io";

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(specPred -> specPred.path("/home")
                        .and()
                        .host(HOST_PATTERN)
//                        .and()
//                        .asyncPredicate(serviceExch -> getPublisher().apply(serviceExch))
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/guides"))
                        .uri("http://spring.io/"))
                .route("github", predicateSpec -> predicateSpec.path("/github/**")
                        .filters(fs -> fs.rewritePath("/github/(?<handle>.*)", "/${handle}"))
                        .uri("http://github.com/@"))
                .build();
    }

    /**
     *
     *
     * @return
     */
    private Function<ServerWebExchange, Publisher<Boolean>> getPublisher() {
        Function<ServerWebExchange, Publisher<Boolean>> fn = new Function<>() {
            @Override public Publisher<Boolean> apply(ServerWebExchange serverWebExchange) {
                return Mono.just(Objects.requireNonNull(serverWebExchange.getAttribute("foo")));
            }
        };
        return fn;
    }
}
