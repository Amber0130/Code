package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUse(Integer userId);
    User findById(Integer userId);
    List<User> findbyName(String username);
    int findToTal();
    List<User> findUserByVo(QueryVo vo);
}
