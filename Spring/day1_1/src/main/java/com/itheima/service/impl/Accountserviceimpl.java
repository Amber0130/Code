package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccuntDaoimpl;
import com.itheima.factory.beanfactory;
import com.itheima.service.IAccountservice;

public class Accountserviceimpl implements IAccountservice {
    //private IAccountDao accountDao = new AccuntDaoimpl();//有独立控制
    private IAccountDao accountDao =(IAccountDao) beanfactory.getBean("accountDao");//没有独立控制，把对象创建的权力给对象
    private int i=1;
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
