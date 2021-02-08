package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import javax.jws.soap.SOAPBinding;
import java.util.List;
@CacheNamespace
public interface IUserDao {
    @Select("select * from user")
    @Results(id = "usermap",value = {
            @Result(id = true ,property = "userId",column = "id"),
            @Result(property = "userName",column = "username"),
            @Result(property = "userAddress",column = "address"),
            @Result(property = "userBirthday",column = "birthday"),
            @Result(property = "userSex",column = "sex"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.itheima.dao.IAccountDao.findById",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    @ResultMap("usermap")
    User findById(Integer id);

    @Select("select * from user where username like #{username}")
    List<User> findUserByname(String username);

}
