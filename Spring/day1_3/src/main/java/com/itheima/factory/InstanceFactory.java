package com.itheima.factory;

import com.itheima.service.IAccountservice;
import com.itheima.service.impl.Accountserviceimpl;

/**
 * 模拟一个工厂类，（此类可能是存在于jar包中的我们无法通过修改源码的方式来提供默认构造函数
 */
public class InstanceFactory {
    public IAccountservice getAccountService(){
        return new Accountserviceimpl();
        }
}
