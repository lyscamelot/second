package system.dao;

import system.entity.SysParam;
import system.entity.SysParamExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysParamMapper {
    @SelectProvider(type=SysParamSqlProvider.class, method="countByExample")
    long countByExample(SysParamExample example);

    @DeleteProvider(type=SysParamSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysParamExample example);

    @Delete({
        "delete from sys_param",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_param (id, name, ",
        "code, value, create_by, ",
        "create_date, update_by, ",
        "update_date, remarks)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{value,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR})"
    })
    int insert(SysParam record);

    @InsertProvider(type=SysParamSqlProvider.class, method="insertSelective")
    int insertSelective(SysParam record);

    @SelectProvider(type=SysParamSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType= JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    List<SysParam> selectByExample(SysParamExample example);

    @Select({
        "select",
        "id, name, code, value, create_by, create_date, update_by, update_date, remarks",
        "from sys_param",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType= JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    SysParam selectByPrimaryKey(String id);

    @UpdateProvider(type=SysParamSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysParam record, @Param("example") SysParamExample example);

    @UpdateProvider(type=SysParamSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysParam record, @Param("example") SysParamExample example);

    @UpdateProvider(type=SysParamSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysParam record);

    @Update({
        "update sys_param",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "value = #{value,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysParam record);
}