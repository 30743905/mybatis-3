package com.mybatis.test.cache.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
  private String id;
  private String name;
  private Integer age;
  private Date birthday;
}
