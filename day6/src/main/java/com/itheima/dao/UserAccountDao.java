package com.itheima.dao;

import com.itheima.domain.UserAccount;

import java.util.List;

public interface UserAccountDao {
    List<UserAccount> findAll();
}
