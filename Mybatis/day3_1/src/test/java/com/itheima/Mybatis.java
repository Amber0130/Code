package com.itheima;

import com.itheima.Dao.IUserDao;
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

public class Mybatis {
    public InputStream in;
    public IUserDao userDao;
    public SqlSession sqlSession;

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
        user.setUsername("Mybatis last id");
        user.setBirthday(new Date());
        user.setAddress("北京海淀");
        user.setSex("男");
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(46);
        user.setUsername("Mybatis save user");
        user.setBirthday(new Date());
        user.setAddress("北京海淀");
        user.setSex("男");
        userDao.updateUser(user);
    }

    @Test
    public void testdeleteUser() {
        userDao.deleteUser(45);
    }

    @Test
    public void testfindById() {
        User user = userDao.findById(43);
        System.out.println(user);
    }

    @Test
    public void testfindByUser() {
        List<User> users = userDao.findByUser("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testfindByUser1() {
        User user = new User();
        user.setUsername("%王%");
        List<User> users = userDao.findByUser1(user);
        for (User u : users) {
            System.out.println(u);
        }
    }
    @Test
    public void testfindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }
    @Test
    public void testfindVo(){
        QueryVo vo=new QueryVo();
        User user =new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users =userDao.findUserByVo(vo);
        for (User u :users){
            System.out.println(u);
        }
    }
}