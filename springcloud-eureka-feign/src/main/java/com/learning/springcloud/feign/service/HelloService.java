package com.learning.springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface HelloService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/header")
    String header();
}
