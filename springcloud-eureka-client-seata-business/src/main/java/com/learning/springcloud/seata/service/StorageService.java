package com.learning.springcloud.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client-storage")
public interface StorageService {

    /**
     * 扣除存储数量
     */
    @GetMapping("/storage/deduct")
    void deduct(@RequestParam(name = "commodityCode") String commodityCode, @RequestParam(name = "count")  int count);
}
