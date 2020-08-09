package com.learning.springcloud.controller;

import com.learning.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/sayHello")
    public String sayHello(){
        return helloService.sayHello();
    }

}
