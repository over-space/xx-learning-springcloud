package com.learning.springcloud.common.service;

import com.learning.springcloud.common.entity.EmployeeEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("/eureka-client")
public interface EmployeeService {

    @GetMapping("/employee/findAll")
    List<EmployeeEntity> findAll();
}
