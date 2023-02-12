package com.mybatis.test.one2many.mapper;

import com.mybatis.test.one2many.entity.User;

import java.util.List;

public interface UserMapper {
  List<User> findAll();
  List<User> findAll2();
}
