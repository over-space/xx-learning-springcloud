package com.learning.springcloud.seata.service;

import com.learning.springcloud.seata.entity.AccountEntity;
import com.learning.springcloud.seata.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void debit(String userId, int money) {
        AccountEntity accountEntity = accountMapper.findByUserId(userId);

        int amount = accountEntity.getMoney() - money;

        accountMapper.updateMoneyByUserId(userId, amount);
    }
}
