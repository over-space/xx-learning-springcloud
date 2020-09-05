package com.learning.springcloud.feign.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.learning.springcloud.feign.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @SentinelResource(value="hello")
    public String hello(){
        return helloService.hello();
    }

    @RequestMapping("/header")
    @SentinelResource(value="header")
    public String header(){
        return helloService.header();
    }

}
