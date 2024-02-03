package com.example.jdbcoracledemo;

import com.example.jdbcoracledemo.dao.UserMapper;
import com.example.jdbcoracledemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void getByList() {
        List<Integer> ids = getIds();

        // ORA-01795: maximum number of expressions in a list is 1000
        List<User> users = userMapper.getByList(ids);

        System.out.println(users);
        System.out.println(users.size());

    }

    @Test
    public void getByListStr() {
        List<Integer> ids = getIds();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            stringBuilder.append(ids.get(i));
            if(i<ids.size()-1){
                stringBuilder.append(",");
            }
        }


        System.out.println(stringBuilder);

        long start = System.currentTimeMillis();
        List<User> users = userMapper.getByListStr(stringBuilder.toString());
        long end = System.currentTimeMillis();

        System.out.println(users);
        System.out.println(users.size());
        System.out.println(end-start);
    }

    @Test
    public void getByListTuple() {
        List<Integer> ids = getIds();
        long start = System.currentTimeMillis();
        List<User> users = userMapper.getByListTuple(ids);
        long end = System.currentTimeMillis();

        System.out.println(users);
        System.out.println(users.size());
        System.out.println(end-start);

    }

    @Test
    public void getByList3() {
        List<Integer> ids = getIds();

        long start = System.currentTimeMillis();
        List<User> users = userMapper.getByList3(ids);
        long end = System.currentTimeMillis();

        System.out.println(end-start);
        System.out.println(users);
        System.out.println(users.size());

    }
    private static List<Integer> getIds() {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 4000; i++) {
            if (i % 2 == 0) {
                ids.add(i);
            }
        }
        return ids;
    }


}
