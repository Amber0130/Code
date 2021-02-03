package com.itheima.Dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findById(Integer userId);

    List<User> findByUser(String username);

    List<User> findByUser1(User user);

    int findTotal();

    List<User> findUserByVo(QueryVo vo);
}
