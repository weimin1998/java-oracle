package com.example.jdbcoracledemo.dao;

import com.example.jdbcoracledemo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    void insert(User user);

    User getById(Integer id);

    List<User> getByList(@Param("ids") List<Integer> ids);

    List<User> getByListStr(String listStr);

    List<User> getByListTuple(@Param("ids") List<Integer> ids);

    List<User> getByList3(@Param("ids") List<Integer> ids);

    List<User> getByList4(@Param("ids") List<Integer> ids);
}
