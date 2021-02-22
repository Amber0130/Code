package com.itheima.Test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll() {
        List<Account> accounts =as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        Account account =as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account =new Account();
        account.setMoney(123456f);
        account.setName("zhang");
        as.saveAccount(account);
    }
//    @Test
//    public void testUpdate() {
//        Account account=as.findAccountById(4);
//        account.setMoney(23456f);
//        as.updateAccount(account);
//    }
    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }
}
