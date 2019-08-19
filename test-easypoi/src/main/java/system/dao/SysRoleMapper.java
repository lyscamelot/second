package system.dao;

import system.entity.SysRole;
import system.entity.SysRoleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysRoleMapper {
    @SelectProvider(type=SysRoleSqlProvider.class, method="countByExample")
    long countByExample(SysRoleExample example);

    @DeleteProvider(type=SysRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleExample example);

    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_role (id, enname, ",
        "name, create_by, ",
        "create_date, update_by, ",
        "update_date, remarks)",
        "values (#{id,jdbcType=VARCHAR}, #{enname,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR})"
    })
    int insert(SysRole record);

    @InsertProvider(type=SysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysRole record);

    @SelectProvider(type=SysRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="enname", property="enname", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    List<SysRole> selectByExample(SysRoleExample example);

    @Select({
        "select",
        "id, enname, name, create_by, create_date, update_by, update_date, remarks",
        "from sys_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="enname", property="enname", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    SysRole selectByPrimaryKey(String id);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set enname = #{enname,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysRole record);
}