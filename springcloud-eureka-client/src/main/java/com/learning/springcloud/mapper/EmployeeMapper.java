package com.learning.springcloud.mapper;

import com.learning.springcloud.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select * from t_employee")
    List<EmployeeEntity> findAll();
}
