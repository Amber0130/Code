package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccuntDaoimpl;
import com.itheima.service.IAccountservice;

public class Accountserviceimpl implements IAccountservice {
    private IAccountDao accountDao = null;//有独立控制
    public Accountserviceimpl(){
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
