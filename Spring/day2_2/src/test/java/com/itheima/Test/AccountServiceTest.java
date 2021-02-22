package com.itheima.Test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindALl() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as=(IAccountService) ac.getBean("accountservice");
        List<Account> accounts =as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as=(IAccountService) ac.getBean("accountservice");
        Account account =as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as=(IAccountService) ac.getBean("accountservice");
        Account account =new Account();
        account.setMoney(123456f);
        account.setName("zhang");
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as=(IAccountService) ac.getBean("accountservice");
        Account account=as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as=(IAccountService) ac.getBean("accountservice");
        as.deleteAccount(4);
    }
}
