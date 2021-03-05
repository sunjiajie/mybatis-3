package org.apache.ibatis.sjj;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author sunjiajie
 * @date 2021/3/5
 */
public class SjjTest extends BaseDataTest{

  private static SqlSessionFactory sqlSessionFactory;

  @BeforeAll
  static void setUp() throws Exception {
    // create a SqlSessionFactory
    try (Reader reader = Resources.getResourceAsReader("org/apache/ibatis/sjj/mybatis-config.xml")) {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    //// populate in-memory database
    //BaseDataTest.runScript(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource(),
    //  "org/apache/ibatis/sjj/db.sql");
  }

  @Test
  public void testMyBatis() throws IOException {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> userList = userMapper.listAllUser();
    System.out.println(JSON.toJSONString(userList));

  }
}
