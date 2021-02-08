package com.itheima.Test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnounceTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//            System.out.println(user.getAccounts());
//
//        }
        User user1=userDao.findById(41);
        System.out.println(user1);
        User user2=userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1==user2);
    }
    @Test
    public void testFindByid(){
        User user= userDao.findById(41);
        System.out.println(user);
    }
}
