package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备spring内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("123456");
        //1.创建对象
        JdbcTemplate jt = new JdbcTemplate();
        //给jt设置数据源
        jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account(name,money)values('ddd',1999)");
    }
}