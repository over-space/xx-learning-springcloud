package com.learning.springcloud.mapper;

import com.learning.springcloud.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    List<UserEntity> findAll();

    @Select("select id,name from t_user")
    List<UserEntity> findIdAndName();


    @Select("select * from t_user where id=#{id}")
    UserEntity findById(@Param("id") String id);

    @Delete("delete from t_user where id=#{id}")
    int deleteById(@Param("id") String id);

    @Update("update t_user set password=#{password} where id=#{id}")
    void updateUserPasswordById(String id, String password);

    @Insert("INSERT INTO t_user (name,password) VALUES (#{name}, #{password})")
    int insert(UserEntity user);
}
