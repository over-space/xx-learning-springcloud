package com.learning.springcloud.controller;

import com.learning.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<String> list(){
        return userService.list();
    }

    @RequestMapping("/findById")
    public Map<String, String> findById(@RequestParam(name = "id") String id){
        return userService.findById(id);
    }
}
