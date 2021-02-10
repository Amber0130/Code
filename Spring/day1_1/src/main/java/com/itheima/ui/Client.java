package com.itheima.ui;

import com.itheima.factory.beanfactory;
import com.itheima.service.IAccountservice;
import com.itheima.service.impl.Accountserviceimpl;

public class Client {
    public static void main(String[] args) {
        //IAccountservice as=new Accountserviceimpl();
        /**
         * 多例被创建多次，从而执行效率比单例对象低
         */
//        for (int i = 0; i < 5; i++) {
//            //多例的
//            IAccountservice as = (IAccountservice) beanfactory.getBean("accountService");
//            System.out.println(as);
//            as.saveAccount();
//        }

        /**
         * 单例
         * 对象只会创建一次从而类中成员只会初始化一次
         */
        for (int i = 0; i < 5; i++) {
            IAccountservice as = (IAccountservice) beanfactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
