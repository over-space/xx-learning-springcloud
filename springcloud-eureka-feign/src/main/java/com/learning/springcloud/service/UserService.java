package com.learning.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("eureka-client")
public interface UserService {

    @GetMapping("/list")
    List<String> list();

    @GetMapping("/findById")
    Map<String, String> findById(@RequestParam(name = "id") String id);

}
