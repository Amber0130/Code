package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.util.List;

/**
 * 事务的控制都是在业务层
 */
public class AccountServiceImpl1 implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager manager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setManager(TransactionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //开启事务
            manager.beginTransaction();
            //执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //提交事务
            manager.commit();
            //返回结果
            return accounts;
        } catch (Exception e) {
            //回滚
            manager.rollback();
            throw new RuntimeException(e);
        } finally {
            //释放连接
            manager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //开启事务
            manager.beginTransaction();
            //执行操作
            Account account = accountDao.findAccountById(accountId);
            //提交事务
            manager.commit();
            //返回结果
            return account;
        } catch (Exception e) {
            //回滚
            manager.rollback();
            throw new RuntimeException(e);
        } finally {
            //释放连接
            manager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //开启事务
            manager.beginTransaction();
            //执行操作
            accountDao.saveAccount(account);
            //提交事务
            manager.commit();
            //返回结果
        } catch (Exception e) {
            //回滚
            manager.rollback();
        } finally {
            //释放连接
            manager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //开启事务
            manager.beginTransaction();
            //执行操作
            accountDao.updateAccount(account);
            //提交事务
            manager.commit();
            //返回结果
        } catch (Exception e) {
            //回滚
            manager.rollback();
        } finally {
            //释放连接
            manager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            //开启事务
            manager.beginTransaction();
            //执行操作
            accountDao.deleteAccount(accountId);
            //提交事务
            manager.commit();
            //返回结果
        } catch (Exception e) {
            //回滚
            manager.rollback();
        } finally {
            //释放连接
            manager.release();
        }
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String tarjetName, Float money) {
        try {
            //开启事务
            manager.beginTransaction();
            //执行操作
            //根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //根据名称查询转入账户
            Account tarjet = accountDao.findAccountByName(tarjetName);
            //转出账户减钱
            source.setMoney(source.getMoney() - money);
            //转入账户加钱

            tarjet.setMoney(tarjet.getMoney() + money);
            //更新转出账户
            accountDao.updateAccount(source);
            //更新转入账户
            int i = 1 / 0;
            accountDao.updateAccount(tarjet);
            //提交事务
            manager.commit();
            //返回结果
        } catch (Exception e) {
            //回滚
            manager.rollback();
            e.printStackTrace();
        } finally {
            //释放连接
            manager.release();
        }
    }
}
