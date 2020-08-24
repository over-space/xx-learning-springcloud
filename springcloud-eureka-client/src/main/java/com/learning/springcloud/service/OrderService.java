package com.learning.springcloud.service;

import com.learning.springcloud.entity.OrderEntity;
import com.learning.springcloud.mapper.OrderMapper;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    private static final String LOCK_ORDER_SHOP_KEY = "order_lock_shop";

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedissonClient redissonClient;

    public void shop(String orderId){
        RLock lock = redissonClient.getLock(LOCK_ORDER_SHOP_KEY);
        try {
            lock.lock(-1, TimeUnit.SECONDS);
            OrderEntity orderEntity = orderMapper.findById(orderId);
            if (orderEntity == null) {
                logger.info("抢单失败!");
                return;
            }

            TimeUnit.SECONDS.sleep(5);

            int num = orderEntity.getNum() - 1;

            if (num >= 0) {
                orderMapper.updateById(orderId, num);
                logger.info("抢单成功,当前库存:{}", num);
            } else {
                logger.info("抢单失败, 库存不足!");
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

}
