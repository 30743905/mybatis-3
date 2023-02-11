package com.mybatis.mapper;

import com.mybatis.entity.Department;

import java.util.List;

public interface DepartmentMapper {

  List<Department> findAll();

}
