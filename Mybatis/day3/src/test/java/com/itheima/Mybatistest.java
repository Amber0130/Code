package com.itheima;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Mybatistest {
    InputStream in;
    SqlSession sqlSession;
    IUserDao iUserDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void teseSaveUser() {
        User user = new User();
        user.setUserName("Mybatis save User");
        user.setUserBirthday(new Date());
        user.setUserAddress("北京海淀");
        user.setUserSex("男");
        System.out.println(user);
        iUserDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void teseupdateUser() {
        User user = new User();
        user.setUserId(43);
        user.setUserName("Mybatis S User");
        user.setUserBirthday(new Date());
        user.setUserAddress("北京海淀");
        user.setUserSex("男");
        iUserDao.updateUser(user);
    }

    @Test
    public void tesedeleteUser() {
        iUserDao.deleteUse(41);
    }

    @Test
    public void tesefindById() {
        User user = iUserDao.findById(46);
        System.out.println(user);
    }

    @Test
    public void tesefindByName() {
        List<User> users = iUserDao.findbyName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void tesefindTotal() {
        int count = iUserDao.findToTal();
        System.out.println(count);
    }

    @Test
    public void tesefindUserByVo() {
        User user = new User();
        QueryVo vo = new QueryVo();
        user.setUserName("%王%");
        vo.setUser(user);
        List<User> users = iUserDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}