package com.learning.springcloud.controller;

import com.learning.springcloud.entity.EmployeeEntity;
import com.learning.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/findAll")
    public List<EmployeeEntity> findAll(){
        return employeeService.findAll();
    }

}
