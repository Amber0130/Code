package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate CRUD
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2获取对象
        JdbcTemplate jt = ac.getBean("jdbctemplte", JdbcTemplate.class);
        //3.执行操作
        //保存
        jt.update("insert into account(name,money) values(?,?)", "ggg", 123f);
        //更新
        jt.update("update account set name=?,money=? where id=?", "kkk", 4567f, 1);
        //删除
        jt.update("delete from account where id=?", 8);
        //查询所有
        //List<Account> accounts=jt.query("select * from account where money>?", new AccountRowMapper(), 1000f);
        List<Account> accounts=jt.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);

        for (Account account:accounts){
            System.out.println(account);
        }
        //查询一个
        List<Account> account = jt.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 9);
        System.out.println(account.isEmpty()?"没有内容":account.get(0));

        //查询返回一行(使用聚合函数)
        Integer i=jt.queryForObject("select count(*) from account where money>?",Integer.class,1000f);
        System.out.println(i);
    }
}
