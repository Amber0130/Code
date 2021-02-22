package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect //当前类是一个切面
public class Logger {
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 前置通知
     */
  //  @Before("pt1()")
    public void beforeprintLog() {
        System.out.println("前置通知Logger类中切入点方法执行了");
    }

    /**
     * 后置通知
     */
 //   @AfterReturning("pt1()")
    public void afterreturnprintLog() {
        System.out.println("后置通知Logger类中切入点方法执行了");
    }

    /**
     * 异常通知
     */
  //  @AfterThrowing("pt1()")
    public void beforethrowingprintLog() {
        System.out.println("异常通知Logger类中切入点方法执行了");
    }

    /**
     * 最终通知
     */
 //   @After("pt1()")
    public void afterprintLog() {
        System.out.println("最终通知Logger类中切入点方法执行了");
    }

    /**
     * 环绕通知
     * 问题配置环绕通知之后 切入点方法没有执行，而通知方法执行了
     * 分析
     * 通过对比动态代理中环绕通知代码 发现动态代理环绕通知中有明确的方法调用而我们中的没有
     * 解决：
     * spring为我们实现了一个接口 proceedingjoinpoint 该接口有一个方法proceed 此方法就相当于明确调用切入点的方法
     * 该接口可以作为环绕通知的方法参数在程序执行时spring框架会为我们提供该接口的实现类供我们使用
     * 环绕通知
     * spring为我们提供的一种方法
     * 在代码中手动控制增强方法何时执行的方式
     */
    @Around("pt1()")
    public Object arroundpringlog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            System.out.println("前置通知");
            Object[] args = pjp.getArgs();//得到方法的所用的参数
            rtValue = pjp.proceed(args);//明确调用切入点方法
            System.out.println("hou置通知");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("异常通知");
            throw new RuntimeException(t);
        } finally {
            System.out.println("最终通知");
        }
    }
}
