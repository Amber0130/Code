package com.itheima.ui;

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
        //1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\shich\\Desktop\\day1_2\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        IAccountservice as = (IAccountservice) ac.getBean("accountService");
        IAccountservice as1 = (IAccountservice) ac.getBean("accountService");
        as.saveAccount();
        ac.close();
    }
}