package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);
}
