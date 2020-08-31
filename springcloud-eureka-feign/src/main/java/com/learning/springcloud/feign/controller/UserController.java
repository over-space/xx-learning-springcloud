package com.learning.springcloud.feign.controller;

import com.learning.springcloud.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findById")
    public Map<String, String> findById(@RequestParam(name = "id") String id){
        return userService.findById(id);
    }
}
