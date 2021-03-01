package cn.itcast.test;

import cn.itcast.dao.IAccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testmtbatis {
    @Test
    public void run1() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }
    @Test
    public void run2() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        Account account = new Account();
        account.setMoney(666666.6);
        account.setName("hhhhh");
        accountDao.saveAccount(account);
        //提交事务
        session.commit();
        session.close();
        in.close();
    }
}
