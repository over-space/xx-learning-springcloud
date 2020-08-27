package com.learning.springcloud.seata.controller;

import com.learning.springcloud.seata.service.BusinessService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/business", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/purchase")
    @GlobalTransactional(rollbackFor = Exception.class)
    public void purchase(@RequestParam String userId, @RequestParam String commodityCode){
        businessService.purchase(userId, commodityCode,1);
    }
}
