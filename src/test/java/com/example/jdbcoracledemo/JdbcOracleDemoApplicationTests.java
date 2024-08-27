package com.example.jdbcoracledemo;

import com.example.jdbcoracledemo.dao.UserLogMapper;
import com.example.jdbcoracledemo.dao.UserMapper;
import com.example.jdbcoracledemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class JdbcOracleDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserLogMapper userLogMapper;


    @Test
    public void testInsert() {
        userMapper.insert(new User(1, "weimin"));
    }

    @Test
    public void select() {
        User user = userMapper.getById(1);

        System.out.println(user);
    }

    @Test
    public void insert10000Data() {
        for (int i = 0; i < 10000; i++) {
            userMapper.insert(new User(i, "user" + i));
        }
    }

    @Test
    public void addUserAndLog() {

        User user = new User(1, "weimin");


        // 插入
        userMapper.insert(user);
        // 添加用户时，创建日志存储表
        Integer id = user.getId();
        //定义用户日志表表名
        String tableName = "t_user_log_" + id;
        //查询表是否存在
        if (userLogMapper.existTable(tableName) > 0) {
            //删除用户对应的日志表
            userLogMapper.dropTable(tableName);
        }
        //新创建表
        userLogMapper.createTable(tableName);

    }
}
