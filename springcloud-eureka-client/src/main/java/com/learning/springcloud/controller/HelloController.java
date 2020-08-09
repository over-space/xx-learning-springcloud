package com.learning.springcloud.controller;

import com.google.common.collect.Lists;
import com.learning.springcloud.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private HealthService healthService;

    @GetMapping("/hello")
    public String hello(){
        return "hello spring cloud, port=" + port;
    }

    @GetMapping("/list")
    public List<String> list(){
        return Lists.newArrayList("red", "yellow", "green");
    }


    @GetMapping("/updateServiceStatus")
    public Health updateServiceStatus(boolean status){
        healthService.updateServiceStatus(status);
        return healthService.health();
    }
}
