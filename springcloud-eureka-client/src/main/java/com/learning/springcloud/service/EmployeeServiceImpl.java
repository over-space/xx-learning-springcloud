package com.learning.springcloud.service;

import com.learning.springcloud.entity.EmployeeEntity;
import com.learning.springcloud.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeMapper.findAll();
    }
}
