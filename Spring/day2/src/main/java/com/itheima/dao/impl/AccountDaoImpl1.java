package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao1")
public class AccountDaoImpl1 implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存账户1");
    }
}
