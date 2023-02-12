package com.mybatis.test.one2one.mapper;

import com.mybatis.test.one2one.entity.User;

import java.util.List;

public interface UserMapper {
  List<User> findAll();
  List<User> findAll2();
}
