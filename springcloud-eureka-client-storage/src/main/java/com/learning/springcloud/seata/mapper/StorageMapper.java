package com.learning.springcloud.seata.mapper;

import com.learning.springcloud.seata.entity.StorageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageMapper {

    @Select("select * from storage_tbl where commodity_code=#{commodityCode}")
    StorageEntity findByCommodityCode(String commodityCode);

    @Update("update storage_tbl set count=count-#{count} where commodity_code=#{commodityCode}")
    void updateCountByCommodityCode(String commodityCode, int count);

}
