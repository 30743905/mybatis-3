package com.mybatis.test.cache;

import com.mybatis.test.cache.mapper.DepartmentMapper;
import com.mybatis.test.cache.entity.Department;
import com.mybatis.test.cache.mapper.UserMapper;
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

public class CacheTest {
  private Logger logger = LoggerFactory.getLogger(CacheTest.class);

  /**
   * 方式二：基于Mapper方式
   * @throws IOException
   */
  @Test
  public void cache001Test() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 连续查询两次同一个Department
    DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    Department department = departmentMapper.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    System.out.println(department);
    Department department2 = departmentMapper.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    System.out.println("department == department2 : " + (department == department2));
    logger.info(System.identityHashCode(department)+":"+System.identityHashCode(department2));
    // 关闭第一个SqlSession使二级缓存保存
    sqlSession.close();

    SqlSession sqlSession2 = sqlSessionFactory.openSession();
    DepartmentMapper departmentMapper2 = sqlSession2.getMapper(DepartmentMapper.class);
    // 再次查询Department
    Department department3 = departmentMapper2.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    departmentMapper2.findAll();

    UserMapper userMapper = sqlSession2.getMapper(UserMapper.class);
    // 触发缓存清除
    userMapper.cleanCache();
    System.out.println("==================cleanCache====================");

    // 再再次查询Department
    Department department4 = departmentMapper2.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    System.out.println("department3 == department4 : " + (department3 == department4));
    departmentMapper2.findAll();

    sqlSession2.close();
    logger.info("测试用例执行完成.");
  }

  @Test
  public void cache002Test() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 连续查询两次同一个Department
    DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    Department department = departmentMapper.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    System.out.println(department);
    Department department2 = departmentMapper.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    System.out.println("department == department2 : " + (department == department2));
    logger.info(System.identityHashCode(department)+":"+System.identityHashCode(department2));
    // 关闭第一个SqlSession使二级缓存保存
    sqlSession.close();

    SqlSession sqlSession2 = sqlSessionFactory.openSession();
    DepartmentMapper departmentMapper2 = sqlSession2.getMapper(DepartmentMapper.class);
    // 再次查询Department
    Department department3 = departmentMapper2.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    departmentMapper2.findAll();

    UserMapper userMapper = sqlSession2.getMapper(UserMapper.class);
    // 触发缓存清除
    userMapper.cleanCache();
    System.out.println("==================cleanCache====================");

    // 再再次查询Department
    Department department4 = departmentMapper2.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    System.out.println("department3 == department4 : " + (department3 == department4));
    departmentMapper2.findAll();

    sqlSession2.close();
    logger.info("测试用例执行完成.");

    SqlSession sqlSession3 = sqlSessionFactory.openSession();
    DepartmentMapper departmentMapper3 = sqlSession3.getMapper(DepartmentMapper.class);
    Department department5 = departmentMapper3.queryById("53e3803ebbf4f97968e0253e5ad4cc83");
    System.out.println("department3 == department4 : " + (department3 == department4));
    departmentMapper3.findAll();
    logger.info("===========");
  }


}
