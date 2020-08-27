package com.learning.springcloud.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client-account")
public interface AccountService {

    /**
     * 从用户账户中借出
     */
    @GetMapping("/account/debit")
    void debit(@RequestParam(name = "userId") String userId, @RequestParam(name = "money") int money);
}
