package com.learning.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.learning.springcloud.entity.UserEntity;
import com.learning.springcloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> findPage(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<UserEntity> lists = userMapper.findAll();
        return lists;
    }

    public PageInfo<UserEntity> page(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<UserEntity> lists = userMapper.findAll();
        return new PageInfo<>(lists);
    }

    public List<UserEntity> findIdAndName(){
        return userMapper.findIdAndName();
    }


    public List<UserEntity> findAll(){
        return userMapper.findAll();
    }

    public UserEntity findById(String id) {
        return userMapper.findById(id);
    }

    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    public void updateUserPasswordById(String id, String password) {
        userMapper.updateUserPasswordById(id, password);
    }

    public void insert(UserEntity userEntity){
        userMapper.insert(userEntity);
    }
}
