package com.learning.springcloud.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client-order")
public interface OrderService {

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    void create(@RequestParam(name = "userId") String userId,
                @RequestParam(name = "commodityCode") String commodityCode,
                @RequestParam(name = "orderCount") int orderCount);
}
