package com.learning.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String sayHello(){
        return restTemplate.getForObject("http://eureka-client/hello",String.class);
    }
}
