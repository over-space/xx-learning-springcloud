package com.learning.springcloud.dubbo.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author lifang
 * @since 2021/1/20
 */
@Service(version = "1.0.0", timeout = 1000, interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String name) {
        System.out.println(name + " say hello world!");
    }
}
