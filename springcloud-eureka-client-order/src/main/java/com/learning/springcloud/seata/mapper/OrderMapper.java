package com.learning.springcloud.seata.mapper;

import com.learning.springcloud.seata.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {


    @Insert("insert into order_tbl(user_id, commodity_code, count, money) values(#{userId}, #{commodityCode}, #{count}, #{money})")
    void insert(OrderEntity order);
}
