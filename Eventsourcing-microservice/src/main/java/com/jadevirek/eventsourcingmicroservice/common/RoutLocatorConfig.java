package com.jadevirek.eventsourcingmicroservice.common;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Redirection config for cloud gatwey for localhost:9999
 *
 */
@Configuration
public class RoutLocatorConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(specPred -> specPred.path("/home")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/guides"))
                         .uri("http://spring.io/"))
                .route("github", predicateSpec -> predicateSpec.path("/github/**")
                        .filters(fs -> fs.rewritePath("/github/(?<handle>.*)","/${handle}"))
                        .uri("http://github.com/@")).build();
    }


}
