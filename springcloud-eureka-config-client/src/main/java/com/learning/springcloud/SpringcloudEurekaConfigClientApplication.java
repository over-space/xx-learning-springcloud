package com.learning.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringcloudEurekaConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaConfigClientApplication.class, args);
	}

	@Value("${foo}")
	private String foo;

	@Value("${server.port}")
	private String port;

	@GetMapping("/foo")
	public String foo(){
		return "port: "+ port + ", foo: " + foo;
	}
}
