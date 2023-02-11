package com.mybatis.test;

import com.mybatis.entity.Department;
import com.mybatis.mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisApplication1 {

  public static void main(String[] args) throws Exception {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List<Department> departmentList = sqlSession.selectList("com.mybatis.mapper.DepartmentMapper.findAll");
    departmentList.forEach(System.out::println);
    System.out.println("=================>>");
    DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    List<Department> departmentList2 = departmentMapper.findAll();
    departmentList2.forEach(System.out::println);

  }
}
