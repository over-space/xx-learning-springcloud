package com.learning.springcloud.dubbo.controller;

import com.learning.springcloud.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifang
 * @since 2021/1/20
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @GetMapping("/say")
    public ResponseEntity<String> say(){
        helloService.sayHello("jack");
        return new ResponseEntity("hello world!", HttpStatus.OK);
    }
}
