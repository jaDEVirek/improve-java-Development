package com.jadevirek.eventsourcingmicroservice.common;


import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutLocatorConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(specPred -> specPred.path("/home")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/guides"))
                        .uri("http://spring.io/"))
                .route("facebook", predicateSpec -> predicateSpec.path("/facebook/@**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/facebook/@(?<handle>.*","/${}handle"))
                        .uri("http://facebook.com/@")).build();
    }

}
