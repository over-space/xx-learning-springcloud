package com.learning.springcloud.seata.service;

import com.learning.springcloud.seata.entity.OrderEntity;
import com.learning.springcloud.seata.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    @Autowired
    private OrderMapper orderMapper;


    public void create(String userId, String commodityCode, int orderCount) {

        int orderMoney = 100;

        //accountService.debit(userId, orderMoney);

        OrderEntity order = new OrderEntity();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);

        // INSERT INTO orders ...
         orderMapper.insert(order);

        logger.info("---------------------------------------------------");
    }
}
