package com.learning.springcloud.feign.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class GrayConfig {

    @Bean
    IRule grayRule(){
        return new GrayRule();
    }
}

