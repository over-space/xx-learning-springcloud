package com.learning.springcloud.seata.controller;

import com.learning.springcloud.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public void create(@RequestParam(name = "userId") String userId,
                       @RequestParam(name = "commodityCode") String commodityCode,
                       @RequestParam(name = "orderCount") int orderCount){
        orderService.create(userId, commodityCode, orderCount);
    }
}
