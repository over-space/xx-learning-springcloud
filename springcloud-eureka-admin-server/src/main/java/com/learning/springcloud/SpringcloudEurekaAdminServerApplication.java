package com.learning.springcloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringcloudEurekaAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaAdminServerApplication.class, args);
    }

}
