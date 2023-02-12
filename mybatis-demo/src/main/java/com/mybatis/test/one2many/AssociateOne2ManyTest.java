package com.mybatis.test.one2many;


import com.mybatis.test.one2many.entity.Department;
import com.mybatis.test.one2many.entity.User;
import com.mybatis.test.one2many.mapper.DepartmentMapper;
import com.mybatis.test.one2many.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AssociateOne2ManyTest {
  private Logger logger = LoggerFactory.getLogger(AssociateOne2ManyTest.class);

  @Test
  public void one2many001Test() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    List<Department> departments = departmentMapper.findAll();
    //userList.forEach(x -> System.out.println(x.getName()));
    logger.info("开始输出查询数据");
    departments.forEach(System.out::println);

    /*userList.forEach(x -> {
      System.out.println(x.getId());
      System.out.println(x.getName());
      System.out.println(x.getAge());
      System.out.println(x.getBirthday());
    });
    System.out.println("===========");*/
    //userList.forEach(x -> System.out.println(x.getDepartment().getName()));
  }

  @Test
  public void one2many002Test() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    List<Department> departments = departmentMapper.findAll2();
    logger.info("开始输出查询数据");
    departments.forEach(System.out::println);
  }

  @Test
  public void one2many003Test() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> users = userMapper.findAll2();
    //userList.forEach(x -> System.out.println(x.getName()));
    logger.info("开始输出查询数据");
    users.forEach(System.out::println);

    /*userList.forEach(x -> {
      System.out.println(x.getId());
      System.out.println(x.getName());
      System.out.println(x.getAge());
      System.out.println(x.getBirthday());
    });
    System.out.println("===========");*/
    //userList.forEach(x -> System.out.println(x.getDepartment().getName()));
  }

}
