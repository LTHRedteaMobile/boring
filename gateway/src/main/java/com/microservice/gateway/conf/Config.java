package com.microservice.gateway.conf;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alex Liu
 * @date 2022/05/01
 */
@Configuration
public class Config {

/*    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/*")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://127.0.0.1:18084/test/publishDownload"))
                *//*.route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config.setName("mycmd")))
                        .uri("http://127.0.0.1:18084/test/publishNotification"))*//*
                .build();
    }*/
}
