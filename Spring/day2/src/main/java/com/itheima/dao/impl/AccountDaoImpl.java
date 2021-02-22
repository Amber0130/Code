package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao2")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存账户2");
    }
}
