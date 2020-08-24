package com.learning.springcloud.mapper;

import com.learning.springcloud.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {

    @Update("update t_order set num=#{num} where id=#{id}")
    void updateById(@Param("id") String id, @Param("num") int num);

    @Select("select * from t_order where id=#{id}")
    OrderEntity findById(@Param("id") String id);
}
