package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 <bean id="accountService" class="com.itheima.service.impl.Accountserviceimpl"
 scope="" init-method="" init-method=""
 >
 <property name="" value="" ref=""></property>
 </bean>
 * 用于创建对象的
 *  他们的作用就和在xml文件中编写一个<bean>标签实现的功能是一样的
 *  @Component
 *  用于把当前类对象存入Spring容器中
 *  属性 value 用于指定bean的id当我们不写时，它的默认值是当前类名 且首字母变小写
 *
 @Controller  一般用在表现层
 @Service       一般用业务层
 @Repository 一般用在持久层
 以上三个注解的作用和属性与Component一摸一样他们三个是Spring框架为我们提供明确的三层使用的注解

 * 用于注入数据
 * 他们的作用就和在xml文件中编写一个<property></>标签实现的功能是一样的
 @Autowired
 *  作用 自动按照类型注入，只要容器中有唯一一个bean对象类型和要注入的的变量类型匹配姐可以注入成功
  *     如果IOC容器中没有任何bean的类型和要注入的变量类型相匹配，则报错
  *     如果IOC容器中有多个类型相匹配，
  *
  * 出现位置 可以说成员变量，也可以是方法上
  *
 @Qualifier
 作用：在按照类中注入的基础之上再按照名称注入，他在给类成员注入时不能单独使用，但是单给方法参数注入时可以
 属性value用于指定beande

 @Resource
    作用直接按照bean的id注入他可以单独使用
    属性 name用于指定bean的id
  以上三种只能注入其他bean类型，而基本类型和String类型无法使用上述注解实现
  另外集合类型的注入只能使用xml实现
  * 细节：使用注解注入时set方法就不是必须的了
  * @Value()
 *  作用：用于注入基本类型和String类型的数据
 *  属性：
 *      value 用于指定数据的值它可以使用Spring中的SpEL(也就是Spring的el表达式）
 *      SpEl的写法：$(表达式)
 * 用于改变作用范围
 * 他们的作用集合在bean标签中使用scope属性实现的功能是一样的
 *
 @Scope 作用：用于指定bean的作用范围
        属性  指定范围取值 singleton prototype
 * 和生命周期相关 了解
 * 他们的作用集合在bean标签中使用init-method=""init-method=""实现的功能是一样的
 *
 @PreDestroy 指定销毁方法
 @PostConstruct 指定初始化方法
 */
@Service(value = "accountservice")
//@Scope(value = "prototype")
public class Accountserviceimpl implements IAccountservice {
    @Resource(name = "accountDao2")
    private IAccountDao accountDao = null;

    public void saveAccount() {
        accountDao.saveAccount();
    }
    @PostConstruct
    public void init() {
        System.out.println("iniut");
    }

    @PreDestroy
    public void destory() {
        System.out.println("destory");
    }
}
