package system.dao;

import system.entity.SysRoleMenu;
import system.entity.SysRoleMenuExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysRoleMenuMapper {
    @SelectProvider(type=SysRoleMenuSqlProvider.class, method="countByExample")
    long countByExample(SysRoleMenuExample example);

    @DeleteProvider(type=SysRoleMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleMenuExample example);

    @Insert({
        "insert into sys_role_menu (role_id, menu_id)",
        "values (#{roleId,jdbcType=VARCHAR}, #{menuId,jdbcType=VARCHAR})"
    })
    int insert(SysRoleMenu record);

    @InsertProvider(type=SysRoleMenuSqlProvider.class, method="insertSelective")
    int insertSelective(SysRoleMenu record);

    @SelectProvider(type=SysRoleMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.VARCHAR),
        @Result(column="menu_id", property="menuId", jdbcType= JdbcType.VARCHAR)
    })
    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);
}