package com.itheima.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean在计算机英语中，有可重用组件的含义
 * JaveBean：用Java语言编写的可重用组件
 *      javeBean>实体类
 *
 *  他就是创建我们的service和dao对象的
 *  第一个：需要一个配置文件配置我们的service和dao
 *          配置的内容 唯一标识=全限定类名 （key=value)
 *  第二个：用过读取配置文件中的配置内容，反射创建对象
 *
 *  我的配置文件可以说xml也可以是properties
 */
public class beanfactory {
    //定义一个Properties对象
    private static Properties props;

    //定义一个Map,用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String, Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = beanfactory.class.getClassLoader().getResourceAsStream("Bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //去除配置文件的所有key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key value存入容器中
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties文件失败");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     *
     * @param beanName
     * @return
     */
//    public static Object getBean(String beanName) {
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象，单例只能用一次newInstance
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}