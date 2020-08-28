package com.learning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudEurekaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaGatewayApplication.class, args);
	}


	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("path_route_1", r -> r.path("/csdn")
						.filters(f -> f.addRequestHeader("hello", "world~~"))
						.uri("https://blog.csdn.net"))
				.route("path_route_2", r -> r.path("/foo").uri("lb://eureka-client"))
				.build();
	}

}
