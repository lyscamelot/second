package system.dao;

import system.entity.SysRoleDept;
import system.entity.SysRoleDeptExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysRoleDeptMapper {
    @SelectProvider(type=SysRoleDeptSqlProvider.class, method="countByExample")
    long countByExample(SysRoleDeptExample example);

    @DeleteProvider(type=SysRoleDeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleDeptExample example);

    @Insert({
        "insert into sys_role_dept (role_id, dept_id)",
        "values (#{roleId,jdbcType=VARCHAR}, #{deptId,jdbcType=VARCHAR})"
    })
    int insert(SysRoleDept record);

    @InsertProvider(type=SysRoleDeptSqlProvider.class, method="insertSelective")
    int insertSelective(SysRoleDept record);

    @SelectProvider(type=SysRoleDeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.VARCHAR),
        @Result(column="dept_id", property="deptId", jdbcType= JdbcType.VARCHAR)
    })
    List<SysRoleDept> selectByExample(SysRoleDeptExample example);

    @UpdateProvider(type=SysRoleDeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    @UpdateProvider(type=SysRoleDeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);
}