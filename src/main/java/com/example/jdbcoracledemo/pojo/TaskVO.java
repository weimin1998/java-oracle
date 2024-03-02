package com.example.jdbcoracledemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskVO {
    private Long id;
    private Long channel;
    private Long reviewStatus;

}
