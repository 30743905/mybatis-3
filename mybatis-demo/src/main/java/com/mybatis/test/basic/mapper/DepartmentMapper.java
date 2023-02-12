package com.mybatis.test.basic.mapper;

import com.mybatis.test.basic.entity.Department;

import java.util.List;

public interface DepartmentMapper {

  List<Department> findAll();

}
