package com.learning.springcloud.seata.service;

import com.learning.springcloud.seata.entity.OrderEntity;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(String userId, String commodityCode, int orderCount);
}
