package com.mybatis.test.one2many.mapper;


import com.mybatis.test.one2many.entity.Department;

import java.util.List;

public interface DepartmentMapper {

  List<Department> findAll();
  List<Department> findAll2();
  Department queryById(String id);

}

