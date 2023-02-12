package com.mybatis.test.basic;

import com.mybatis.test.basic.entity.Department;
import com.mybatis.test.basic.mapper.DepartmentMapper;
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

public class BasicTest {
  private Logger logger = LoggerFactory.getLogger(BasicTest.class);

  @Test
  public void basic001Test() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List<Department> departmentList = sqlSession.selectList("com.mybatis.test.basic.mapper.DepartmentMapper.findAll");
    departmentList.forEach(System.out::println);
  }

  /**
   * 方式二：基于Mapper方式
   * @throws IOException
   */
  @Test
  public void basicMapperTest() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    List<Department> departmentList2 = departmentMapper.findAll();
    departmentList2.forEach(System.out::println);
    logger.info("mapper测试完成");
  }

}
