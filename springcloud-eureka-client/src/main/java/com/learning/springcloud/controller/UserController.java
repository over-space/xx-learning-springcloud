package com.learning.springcloud.controller;

import com.github.pagehelper.PageInfo;
import com.learning.springcloud.entity.UserEntity;
import com.learning.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/findIdAndName")
    public List<UserEntity> findIdAndName(){
        return userService.findIdAndName();
    }

    @GetMapping("/findPage")
    public List<UserEntity> findIdAndName(int pageNo, int pageSize){
        return userService.findPage(pageNo, pageSize);
    }

    @GetMapping("/page")
    public PageInfo<UserEntity> page(int pageNo, int pageSize){
        return userService.page(pageNo, pageSize);
    }


    @PostMapping("/insert")
    public List<UserEntity> insert(@RequestBody UserEntity userEntity){
        System.out.println("name:" + userEntity.getName());
        userService.insert(userEntity);
        return userService.findAll();
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/findById")
    public UserEntity findById(@RequestParam(name = "id") String id){
        return userService.findById(id);
    }

    @RequestMapping("/deleteById")
    public int deleteById(String id){
        return userService.deleteById(id);
    }

    @RequestMapping("/updateUserPasswordById")
    public void updateUserPasswordById(String id, String password){
        userService.updateUserPasswordById(id, password);
    }

}
