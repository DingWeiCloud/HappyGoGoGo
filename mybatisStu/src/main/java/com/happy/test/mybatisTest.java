package com.happy.test;

import com.happy.dao.UserMapper2;
import com.happy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class mybatisTest {
    /**
     * 原始方式
     * session 調用方法的時候 直接調用
     * * @throws IOException
     */

    @Test
    public void test() throws IOException {
        String resoures = "mybatis.xml";
        Reader resourceAsReader = Resources.getResourceAsReader(resoures);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        try {
            User user = sqlSession.selectOne("org.mybatis.example.UserMapper.selectBlog", 1);
            System.err.println(user);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 接口式編程
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        String resoures = "mybatis.xml";
        Reader resourceAsReader = Resources.getResourceAsReader(resoures);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        try {
            UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
            User userById = mapper.getUserById(2);
            System.err.println(userById);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 接口直接寫sql
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        String resoures = "mybatis.xml";
        Reader resourceAsReader = Resources.getResourceAsReader(resoures);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        try {
            UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
            User userById = mapper.getUserById2(2);
            System.err.println(userById);
        } finally {
            sqlSession.close();
        }
    }
}
