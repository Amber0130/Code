package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

public class AccountServiceimpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        System.out.println("transfer....");
        Account source = accountDao.findAccountByName(sourceName);
        //根据名称查询转入账户
        Account tarjet = accountDao.findAccountByName(targetName);
        //转出账户减钱
        source.setMoney(source.getMoney() - money);
        //转入账户加钱
        tarjet.setMoney(tarjet.getMoney() + money);
        //更新转出账户
        accountDao.updateAccount(source);
        int i=1/0;
        //更新转入账户
        accountDao.updateAccount(tarjet);
    }
}
