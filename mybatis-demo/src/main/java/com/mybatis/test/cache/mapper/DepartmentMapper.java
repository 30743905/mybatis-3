package com.mybatis.test.cache.mapper;


import com.mybatis.test.cache.entity.Department;

import java.util.List;

public interface DepartmentMapper {
  List<Department> findAll();
  Department queryById(String id);
}

