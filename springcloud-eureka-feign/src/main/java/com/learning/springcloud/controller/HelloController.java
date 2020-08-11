package com.learning.springcloud.controller;

import com.learning.springcloud.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        logger.info("------------------------ ribbon feign -------------------------");

        return helloService.hello();
    }
}
