package com.example.jdbcoracledemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLog {
    private String id;
    private String userName;
    private String method;
    private String params;
    private Date date;
    private String ip;
}
