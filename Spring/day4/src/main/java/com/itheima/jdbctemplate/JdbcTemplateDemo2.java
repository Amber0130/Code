package com.itheima.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate最基本用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1获取容器
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        //2获取对象
        JdbcTemplate jt= ac.getBean("jdbctemplte",JdbcTemplate.class);
        //3.执行操作
        jt.execute("insert into account(name,money)values('fff',6669)");
    }
}