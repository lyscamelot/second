package system.dao;

import system.entity.SysUserDept;
import system.entity.SysUserDeptExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysUserDeptMapper {
    @SelectProvider(type=SysUserDeptSqlProvider.class, method="countByExample")
    long countByExample(SysUserDeptExample example);

    @DeleteProvider(type=SysUserDeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserDeptExample example);

    @Delete({
        "delete from sys_user_dept",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into sys_user_dept (user_id, dept_id)",
        "values (#{userId,jdbcType=VARCHAR}, #{deptId,jdbcType=VARCHAR})"
    })
    int insert(SysUserDept record);

    @InsertProvider(type=SysUserDeptSqlProvider.class, method="insertSelective")
    int insertSelective(SysUserDept record);

    @SelectProvider(type=SysUserDeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="dept_id", property="deptId", jdbcType= JdbcType.VARCHAR)
    })
    List<SysUserDept> selectByExample(SysUserDeptExample example);

    @Select({
        "select",
        "user_id, dept_id",
        "from sys_user_dept",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="dept_id", property="deptId", jdbcType= JdbcType.VARCHAR)
    })
    SysUserDept selectByPrimaryKey(String userId);

    @UpdateProvider(type=SysUserDeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUserDept record, @Param("example") SysUserDeptExample example);

    @UpdateProvider(type=SysUserDeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUserDept record, @Param("example") SysUserDeptExample example);

    @UpdateProvider(type=SysUserDeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUserDept record);

    @Update({
        "update sys_user_dept",
        "set dept_id = #{deptId,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysUserDept record);
}