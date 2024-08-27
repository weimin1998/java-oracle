package com.example.jdbcoracledemo.dao;

import com.example.jdbcoracledemo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    void insert(User user);

    User getById(Integer id);

}
