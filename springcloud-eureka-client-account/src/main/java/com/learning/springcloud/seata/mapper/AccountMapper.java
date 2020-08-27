package com.learning.springcloud.seata.mapper;

import com.learning.springcloud.seata.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    @Select("select * from account_tbl where user_id=#{userId}")
    AccountEntity findByUserId(String userId);

    @Update("update account_tbl set money=#{money} where user_id=#{userId}")
    void updateMoneyByUserId(String userId, int money);
}
