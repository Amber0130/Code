package com.itheima.service.impl;

import com.itheima.service.IAccountservice;

import java.util.Date;

public class Accountserviceimpl implements IAccountservice {
    //如果是经常变化的数据并不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public Accountserviceimpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了" + name + age + birthday);
    }
}
