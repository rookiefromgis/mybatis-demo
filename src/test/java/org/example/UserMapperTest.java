package org.example;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.BrandMapper;
import org.example.mapper.UserMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

        @Test
        public void testSelect() throws IOException {
            //1.加载mybatis的核心配置文件，获取SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.获取SqlSession对象，用它来执行sql
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3 获取UserMapper接口的代理对象
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);

            //4.执行方法
            String username = "zhangsan";
            String password = "123";

            User user = userMapper.select(username,password);
            System.out.println(user);

            //5.释放资源
            sqlSession.close();
        }

        @Test
        public void testSelectById() throws IOException {
            //1.加载mybatis的核心配置文件，获取SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.获取SqlSession对象，用它来执行sql
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3 获取UserMapper接口的代理对象
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);

            //4.执行方法
            User user = userMapper.selectById(1);
            System.out.println(user);

            //5.释放资源
            sqlSession.close();
        }

}

