package com.learning.springcloud.feign.controller;

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

    @Value("${server.port}")
    private String port;


    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        logger.info("------------------------ ribbon feign --------------------port : {}", port);

        return helloService.hello();
    }

}
