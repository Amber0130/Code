package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.JdbcSuport;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountdao")
public class accountDaoimpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account findAccountById(Integer id) {
        List<Account> account = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return account.isEmpty() ? null : account.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> account =  jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (account.isEmpty()) {
            return null;
        }
        if (account.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return account.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}
