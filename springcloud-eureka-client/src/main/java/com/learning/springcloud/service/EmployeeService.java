package com.learning.springcloud.service;

import com.learning.springcloud.entity.EmployeeEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface EmployeeService {

    @GetMapping("/employee/findAll")
    List<EmployeeEntity> findAll();
}
