package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();
        /**
         * 动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：不修改源码的基础上对方法增强
         * 分类：
         *      基于接口的
         *      基于子类的动态代理
         * 基于接口的动态代理
         *      设计的类proxy
         *      提供者：JDK官方
         * 如何使用代理：
         *      使用proxy类中的newproxyInstance方法
         * 创建代理对象的要求
         *      被代理对象至少实现一个接口秒如果没有则不能使用
         * newproxyInstance方法的参数
         *       CLsaaloder 类加载器
         *       它是用于加载代理对象字节码的和被代理对象使用相同的类加载器 写法是固定写法
         *       Class[]
         *       它是用于让代理对象和被代理对象有相同的方法 写法是固定写法
         *       invocationHandler 用于提供增强的代码
         *       他是让我们如何写代理，我们一般都是写一个该接口的实现类通常情况下是匿名内部类，但不是必须的
         *       此处接口的实现类都是谁用谁写
         */
        Iproducer proxyProducer = (Iproducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理随想的任何接口方法都会经过该方法
                     * 方法参数的含义
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args   当前执行方法所需的参数
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        //获取方法执行的参数
                        Float money = (Float) args[0];
                        if ("saleProduce".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduce(10000f);
    }
}
