package com.learning.springcloud.controller;

import com.google.common.collect.Lists;
import com.learning.springcloud.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private HealthService healthService;

    @GetMapping("/hello")
    public String hello(){
        try {
            Thread.sleep(500);
        }catch (Exception e){

        }
        System.out.println("===========================:" + port);
        return "hello spring cloud, port=" + port;
    }

    @GetMapping("/list")
    public List<String> list(){
        return Lists.newArrayList("red", "yellow", "green");
    }

    @GetMapping("/findById")
    public Map<String, String> findById(@RequestParam(name = "id") String id){
        Map<String, String> map = new HashMap<>(2);
        map.put("id", id);
        map.put("name", "lisi");
        return map;
    }

    @GetMapping("/updateServiceStatus")
    public Health updateServiceStatus(boolean status){
        healthService.updateServiceStatus(status);
        return healthService.health();
    }
}
