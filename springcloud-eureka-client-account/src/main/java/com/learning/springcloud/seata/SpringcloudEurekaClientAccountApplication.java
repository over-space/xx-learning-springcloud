package com.learning.springcloud.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudEurekaClientAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaClientAccountApplication.class, args);
    }

}
