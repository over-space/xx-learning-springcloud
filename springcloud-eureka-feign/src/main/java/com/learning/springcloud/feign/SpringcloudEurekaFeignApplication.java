package com.learning.springcloud.feign;

import com.learning.springcloud.feign.rule.GrayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("com.learning.springcloud")
@RibbonClient(name = "eureka-client", configuration = GrayConfig.class)
public class SpringcloudEurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaFeignApplication.class, args);
	}
}
