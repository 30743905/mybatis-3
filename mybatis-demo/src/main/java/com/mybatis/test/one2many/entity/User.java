package com.mybatis.test.one2many.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
  private String id;
  private String name;
  private Integer age;
  private Date birthday;
  private Department department;
}
