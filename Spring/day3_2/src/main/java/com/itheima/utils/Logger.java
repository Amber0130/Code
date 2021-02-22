package com.itheima.utils;

public class Logger {
    //用于打印日志，之切入点方法执行之前（切入点方法业务层方法）
    public void printLog(){
        System.out.println("Logger类中切入点方法执行了");
    }
}
