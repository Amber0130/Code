package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "roleName", property = "roleName"),
                    @Result(column = "roleDesc", property = "roleDesc"),
                    @Result(column = "id", property = "permissions", javaType = List.class, many = @Many(select = "com.itheima.dao.IPermissionDao.findByRoleId"))
            })
    List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert({"insert into role(id,roleName,roleDesc) values((select substring(MD5(RAND()),1,32)),#{roleName},#{roleDesc})"})
    void save(Role role) throws Exception;

    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(String roleId) throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
