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

import java.io.InputStream;

public class Second {
    private InputStream in;
    private SqlSession sqlSession1;
    private IUserDao userDao1;
    private SqlSessionFactory factory;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);

    }

    @After
    public void destory() throws Exception {
//        sqlSession.commit();
//        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindone(){
        sqlSession1=factory.openSession();
        userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user= userDao1.findById(41);
        System.out.println(user);
        sqlSession1.close();

        SqlSession sqlSession2=factory.openSession();
        IUserDao userDao2=sqlSession2.getMapper(IUserDao.class);
        User use2=userDao2.findById(41);
        sqlSession2.close();;
        System.out.println(use2==user);
    }
}
