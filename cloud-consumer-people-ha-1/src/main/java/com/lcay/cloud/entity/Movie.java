package com.lcay.cloud.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Movie {
    private int id;
    private String name;
    private int count;
    private double balance;
}
