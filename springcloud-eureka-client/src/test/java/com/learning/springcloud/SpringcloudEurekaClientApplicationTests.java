package com.learning.springcloud;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@SpringBootTest
class SpringcloudEurekaClientApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringcloudEurekaClientApplicationTests.class);

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    void contextLoads() {
        logger.info("client:{}", client.getClass());
        List<String> services = client.getServices();
        int index = 1;
        for (String service : services) {
            logger.info("server-{}:{}", index++, service);
        }

        List<ServiceInstance> instances = client.getInstances("eureka-client");
        index = 1;
        for (ServiceInstance instance : instances) {
            get(instance);
        }
    }

    @Test
    void testRibbon(){
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        get(instance);
    }

    private void get(ServiceInstance instance){
        logger.info("instance:{}", ToStringBuilder.reflectionToString(instance));

        URI uri = instance.getUri();
        String host = uri.getHost();
        int port = uri.getPort();

        logger.info("host:{}", host);
        logger.info("port:{}", port);

        String address = "http://" + host + ":" + port + "/hello";

        ResponseEntity<String> resp = new RestTemplate().getForEntity(address, String.class);

        logger.info("resp:{}", resp);
    }
}
