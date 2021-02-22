package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountservice;
import com.itheima.service.impl.Accountserviceimpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountservice as = (IAccountservice) ac.getBean("accountservice");
//        IAccountDao ad=(IAccountDao)ac.getBean("accountDaoImpl");
//        System.out.println(as);
////        System.out.println(ad);
        as.saveAccount();
        ac.close();
    }
}