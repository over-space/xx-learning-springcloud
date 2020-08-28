package com.learning.springcloud.seata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService{

    private static final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);


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
        logger.info("------------------------------------ business -------------------------------------");
    }
}
