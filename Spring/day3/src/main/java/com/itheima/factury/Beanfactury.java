package com.itheima.factury;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 创建service代理对象的工厂
 */
public class Beanfactury {
    private IAccountService accountService;
    private TransactionManager manager;

    public void setManager(TransactionManager manager) {
        this.manager = manager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取service代理对象
     *
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtvalue = null;
                        try {
                            //开启事务
                            manager.beginTransaction();
                            //执行操作
                            rtvalue = method.invoke(accountService, args);
                            //List<Account> accounts = accountDao.findAllAccount();
                            //提交事务
                            manager.commit();
                            //返回结果
                            return rtvalue;
                        } catch (Exception e) {
                            //回滚
                            manager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            manager.release();
                        }
                    }
                }
        );
    }
}
