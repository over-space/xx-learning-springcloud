package com.learning.springcloud.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class SpringcloudEurekaClientOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaClientOrderApplication.class, args);
	}

}
