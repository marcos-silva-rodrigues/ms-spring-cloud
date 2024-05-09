package com.rodrigues.silva.marcos.hrgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
public class HrGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
						.route("worker", r -> r.path("/workers/**")
										.uri("lb://hr-worker"))
						.route("payment", r -> r.path("/payments/**")
										.uri("lb://hr-payrool"))
						.route("user", r -> r.path("/users/**")
										.uri("lb://hr-user"))
						.build();
	}

}
