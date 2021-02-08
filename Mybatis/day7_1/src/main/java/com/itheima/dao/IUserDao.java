package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,birthday,sex,address) value(#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

//    @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%' ")
    List<User> findUserByname(String username);

    @Select("select count(*) from user")
    int TotalUser();
}
