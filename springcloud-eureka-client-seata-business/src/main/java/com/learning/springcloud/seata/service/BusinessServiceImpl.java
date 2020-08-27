package com.learning.springcloud.seata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private OrderService orderService;

    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageService.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);
        accountService.debit(userId, 100);
    }
}
