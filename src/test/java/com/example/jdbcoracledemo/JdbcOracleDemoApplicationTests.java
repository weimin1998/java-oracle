package com.example.jdbcoracledemo;

import com.example.jdbcoracledemo.dao.SourceMapper;
import com.example.jdbcoracledemo.dao.TaskMapper;
import com.example.jdbcoracledemo.dao.UserMapper;
import com.example.jdbcoracledemo.pojo.Source;
import com.example.jdbcoracledemo.pojo.Task;
import com.example.jdbcoracledemo.pojo.TaskVO;
import com.example.jdbcoracledemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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
            if (i < ids.size() - 1) {
                stringBuilder.append(",");
            }
        }


        System.out.println(stringBuilder);

        long start = System.currentTimeMillis();
        List<User> users = userMapper.getByListStr(stringBuilder.toString());
        long end = System.currentTimeMillis();

        System.out.println(users);
        System.out.println(users.size());
        System.out.println(end - start);
    }

    @Test
    public void getByListTuple() {
        List<Integer> ids = getIds();
        long start = System.currentTimeMillis();
        List<User> users = userMapper.getByListTuple(ids);
        long end = System.currentTimeMillis();

        System.out.println(users);
        System.out.println(users.size());
        System.out.println(end - start);

    }

    @Test
    public void getByList3() {
        List<Integer> ids = getIds();

        long start = System.currentTimeMillis();
        List<User> users = userMapper.getByList3(ids);
        long end = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(users);
        System.out.println(users.size());

    }

    @Test
    public void getByList4() {
        List<Integer> ids = getIds();

        long start = System.currentTimeMillis();
        List<User> users = userMapper.getByList4(ids);
        long end = System.currentTimeMillis();

        System.out.println(end - start);
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


    @Autowired
    TaskMapper taskMapper;

    @Test
    public void getTasks() {
        TaskVO taskVO = new TaskVO();

        taskVO.setChannel(0L);
        taskVO.setReviewStatus(4L);
        List<Task> tasks = taskMapper.getTasks(taskVO);

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    @Autowired
    SourceMapper sourceMapper;

    @Test
    public void insert10000Source() {
        LocalDate startDate = LocalDate.of(1998, 8, 21); // 设置特定日期，格式为年-月-日
        LocalDate nextDay = startDate.plusDays(1);

        for (int i = 0; i < 10000; i++) {
            java.util.Date date = java.sql.Date.valueOf(nextDay);

            Source source = new Source(i + "", date, i + "");
            sourceMapper.insert(source);
            nextDay = nextDay.plusDays(1);
        }

//        for (int i = 0; i < 30; i++) {
//            System.out.println(nextDay);
//            nextDay = nextDay.plusDays(1);
//        }
    }
}
