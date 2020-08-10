package com.learning.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface HelloService {

    @GetMapping("/hello")
    String hello();
}
