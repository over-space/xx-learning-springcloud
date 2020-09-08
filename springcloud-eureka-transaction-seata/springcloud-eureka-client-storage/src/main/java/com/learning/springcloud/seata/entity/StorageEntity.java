package com.learning.springcloud.seata.entity;

import java.io.Serializable;

public class StorageEntity implements Serializable {

    private Integer id;

    private String commodityCode;

    private int count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
