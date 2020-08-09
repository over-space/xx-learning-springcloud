package com.learning.springcloud.user.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("eureka-client")
public interface UserAPI {

    @GetMapping("/list")
    List<String> list();
}
