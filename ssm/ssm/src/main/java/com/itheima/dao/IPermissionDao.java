package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(id,permissionName,url) values((select substring(MD5(RAND()),1,32)),#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
