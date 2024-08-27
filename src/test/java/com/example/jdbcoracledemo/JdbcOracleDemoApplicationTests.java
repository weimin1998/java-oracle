package com.example.jdbcoracledemo;

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
}
