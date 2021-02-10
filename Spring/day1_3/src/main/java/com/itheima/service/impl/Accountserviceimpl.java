package com.itheima.service.impl;

import com.itheima.service.IAccountservice;

public class Accountserviceimpl implements IAccountservice {
    public Accountserviceimpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }
    public void init(){
        System.out.println("对象初始化");
    }
    public void destory(){
        System.out.println("对象销毁了");
    }
}
