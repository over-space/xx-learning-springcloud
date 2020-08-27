package com.learning.springcloud.seata.entity;

import java.io.Serializable;

public class AccountEntity implements Serializable {

    private Integer id;

    private String userId;

    private int money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
