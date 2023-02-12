package com.mybatis.test.one2one;


import com.mybatis.test.one2one.entity.User;
import com.mybatis.test.one2one.mapper.UserMapper;
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


public class AssociateOne2OneTest {
  private Logger logger = LoggerFactory.getLogger(AssociateOne2OneTest.class);

  @Test
  public void cache001Test() throws IOException {
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> userList = userMapper.findAll2();
    //userList.forEach(x -> System.out.println(x.getName()));
    userList.forEach(System.out::println);
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
