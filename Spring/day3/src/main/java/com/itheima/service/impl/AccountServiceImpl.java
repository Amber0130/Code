package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事务的控制都是在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
            return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String tarjetName, Float money) {
        System.out.println("transfer....");
        Account source = accountDao.findAccountByName(sourceName);
        //根据名称查询转入账户
        Account tarjet = accountDao.findAccountByName(tarjetName);
        //转出账户减钱
        source.setMoney(source.getMoney() - money);
        //转入账户加钱
        tarjet.setMoney(tarjet.getMoney() + money);
        //更新转出账户
        accountDao.updateAccount(source);
        //更新转入账户
        accountDao.updateAccount(tarjet);
    }
}
