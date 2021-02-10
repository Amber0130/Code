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
     * 获取Spring的IOC的核心容器
     * ApplicationContext的三个常用实现类
     * ClassPathXmlApplicationContext 他可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话加载不了(更常用相对于第二个)
     * FileSystemXmlApplicationContext 他可以加载磁盘任意路径下的配置文件（必须有访问权限）
     * <p>
     * AnnotationConfigApplicationContext 它是用于读取注解创建容器的
     * <p>
     * 核心容器的两个接口
     * ApplicationContext   单例对象使用  采用此接口
     * 他在创建核心容器时，创建对象采用的策略是采用立即加载的方式，也就是说只要一读取完配置文件马上就创建配置文件中配置的对象
     * BeanFactory      多例对象使用
     * 他在创建核心容器时，创建对象采取的策略是采取延迟加载的方式，也就是说什么时候根据id获取对象了什么时候真正的创建对象
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\shich\\Desktop\\day1_2\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        IAccountservice as = (IAccountservice) ac.getBean("accountService");
        //IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        as.saveAccount();
//        System.out.println(adao);
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        IAccountservice as = (IAccountservice) beanFactory.getBean("accountService");
//        System.out.println(as);
    }
}