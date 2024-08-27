package com.example.jdbcoracledemo.dao;

import com.example.jdbcoracledemo.pojo.UserLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLogMapper {

    //保存用户的日志
    int insert(@Param("tableName")String tableName, @Param("userLog") UserLog userLog);
    /**
     * 查找用户全部的日志
     * @param tableName 用户对应的表名
     */
    List<UserLog> selectAll(@Param("tableName")String tableName);
    /**
     * 是否存在表
     */
    int existTable(@Param("tableName")String tableName);
    /**
     * 删除表
     */
    int dropTable(@Param("tableName")String tableName);
    /**
     * 创建表
     */
    int createTable(@Param("tableName")String tableName);
}
