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
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("Mybatis");
        user.setAddress("北京海淀");
        user.setSex("男");
        userDao.saveUser(user);
    }
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(41);
        user.setUsername("Mybatis");
        user.setAddress("北京海淀");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(42);
    }
    @Test
    public void testFindUserById() {
        User user=userDao.findById(43);
        System.out.println(user);
    }
    @Test
    public void testFindUserByName() {
        List<User> users=userDao.findUserByname("王");
        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testTotalUser() {
        int count=userDao.TotalUser();
        System.out.println(count);
    }

}
