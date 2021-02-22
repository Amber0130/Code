package com.itheima.jdbctemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate最基本用法
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
        account.setMoney(78889f);
        accountDao.updateAccount(account);
    }
}