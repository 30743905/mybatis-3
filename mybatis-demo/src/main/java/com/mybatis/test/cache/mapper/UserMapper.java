package com.mybatis.test.cache.mapper;

import com.mybatis.test.cache.entity.User;

import java.util.List;

public interface UserMapper {
  List<User> findAll();
  int cleanCache();
}
