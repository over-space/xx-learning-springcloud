package com.learning.springcloud.controller;

import brave.http.HttpServerRequest;
import com.google.common.collect.Lists;
import com.learning.springcloud.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    //@Value("${foo}")
    private String foo;

    @Autowired
    private HealthService healthService;

    @GetMapping("/hello")
    public String hello(){
        return "hello spring cloud, port=" + port + ", foo=" + foo;
    }

    @GetMapping("/header")
    public String header(HttpServletRequest request){
        String token = request.getHeader("token");
        return "hello spring cloud, port=" + port + ", token=" + token;
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
