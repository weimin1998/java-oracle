package com.example.jdbcoracledemo.dao;

import com.example.jdbcoracledemo.pojo.Task;
import com.example.jdbcoracledemo.pojo.TaskVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {

    List<Task> getTasks(@Param("vo") TaskVO vo);
}
