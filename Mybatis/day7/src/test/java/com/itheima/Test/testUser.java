package com.itheima.Test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testUser {
    InputStream in;
    SqlSession sqlSession;
    IUserDao userDao;
    SqlSessionFactory factory;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        //sqlSession.commit();
        //sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession1= factory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User use1 = userDao1.findUserByid(41);
        sqlSession1.close();
        System.out.println(use1);
        SqlSession sqlSession2= factory.openSession();
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User use2 = userDao2.findUserByid(41);
        sqlSession2.close();
        System.out.println(use2);
        System.out.println(use1==use2);
    }
}
