package com.mybatis.test.one2one.mapper;


import com.mybatis.test.one2one.entity.Department;

import java.util.List;

public interface DepartmentMapper {

  List<Department> findAll();
  Department queryById(String id);

}

