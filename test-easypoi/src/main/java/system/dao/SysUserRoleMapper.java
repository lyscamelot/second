package system.dao;

import system.entity.SysUserRole;
import system.entity.SysUserRoleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysUserRoleMapper {
    @SelectProvider(type=SysUserRoleSqlProvider.class, method="countByExample")
    long countByExample(SysUserRoleExample example);

    @DeleteProvider(type=SysUserRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserRoleExample example);

    @Insert({
        "insert into sys_user_role (user_id, role_id)",
        "values (#{userId,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR})"
    })
    int insert(SysUserRole record);

    @InsertProvider(type=SysUserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysUserRole record);

    @SelectProvider(type=SysUserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType= JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.VARCHAR)
    })
    List<SysUserRole> selectByExample(SysUserRoleExample example);

    @UpdateProvider(type=SysUserRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    @UpdateProvider(type=SysUserRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);
}