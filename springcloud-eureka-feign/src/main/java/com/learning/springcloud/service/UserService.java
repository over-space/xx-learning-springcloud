package com.learning.springcloud.service;

import com.learning.springcloud.service.fallback.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "eureka-client", fallback = UserServiceHystrix.class)
public interface UserService {

    @GetMapping("/list")
    List<String> list();

    @GetMapping("/findById")
    Map<String, String> findById(@RequestParam(name = "id") String id);

}
