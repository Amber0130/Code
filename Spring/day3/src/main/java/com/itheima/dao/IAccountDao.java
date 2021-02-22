package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户
     * 如果有唯一的结果就返回 如果没有结果就返回Null
     * 如果结果超过一个就抛出异常
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);
}
