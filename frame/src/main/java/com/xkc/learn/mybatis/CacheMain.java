package com.xkc.learn.mybatis;

import com.xkc.learn.mybatis.dao.UserMapper;
import com.xkc.learn.mybatis.domain.UserModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMain {
    /**
     * 一级缓存
     */
    @Test
    public void testFirstCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserModel user1 = mapper.findUserById(1);
        System.out.println(user1);

        // 直接从一级缓存中读取
        UserModel user2 = mapper.findUserById(1);
        System.out.println(user2);

        sqlSession.close();
    }

    /**
     * 二级缓存
     * @throws IOException
     */
    @Test
    public void testSecondCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);

        UserModel user1 = mapper1.findUserById(1);
        // 必须关闭Session才会把缓存写到二级缓存中
        sqlSession1.close();
        System.out.println(user1);

        UserModel user2 = mapper2.findUserById(1);
        System.out.println(user2);

        UserModel user3 = mapper3.findUserById(1);
        System.out.println(user3);


        sqlSession2.close();
        sqlSession3.close();
    }
}
