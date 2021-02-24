package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountservice")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceimpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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
        //更新转入账户
        accountDao.updateAccount(tarjet);
    }
}
