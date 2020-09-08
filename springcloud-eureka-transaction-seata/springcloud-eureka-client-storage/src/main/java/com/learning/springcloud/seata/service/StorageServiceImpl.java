package com.learning.springcloud.seata.service;

import com.learning.springcloud.seata.entity.StorageEntity;
import com.learning.springcloud.seata.mapper.StorageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService{

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);


    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void deduct(String commodityCode, int count) {

        StorageEntity storageEntity = storageMapper.findByCommodityCode(commodityCode);

        if(storageEntity == null){
            throw new RuntimeException("该商品暂时无货!");
        }

        if(storageEntity.getCount() <= 0){
            throw new RuntimeException("该商品库存不足!");
        }

        storageMapper.updateCountByCommodityCode(commodityCode, count);

        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
