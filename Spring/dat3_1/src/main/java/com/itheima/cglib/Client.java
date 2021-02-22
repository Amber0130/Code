package com.itheima.cglib;

import com.itheima.proxy.Iproducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         * 基于子类的动态代理
         *      设计的类Enhancer
         *      提供者：cglib官方
         * 如何使用代理：
         *      使用Enhancer类中的creater方法
         * 创建代理对象的要求
         *      被代理对不能说最终类
         * create方法的参数
         *       CLass 字节码
         *       它是用于指定被代理对象的字节码
         *       Callback 用于提供增强的代码
         *       他是让我们如何写代理，我们一般都是写一个该接口的实现类通常情况下是匿名内部类，但不是必须的
         *       此处接口的实现类都是谁用谁写
         *       我们一般写的都是该接口的子接口的实现类MethidInterceptor
         */
        Producer cglibproducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * * 执行被代理随想的任何接口方法都会经过该方法
             * @param proxy
             * @param method 当前执行的方法
             * @param args
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglibproducer.saleProduce(12000f);
    }
}
