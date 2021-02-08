package com.itheima.dao;

import com.itheima.daomain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
