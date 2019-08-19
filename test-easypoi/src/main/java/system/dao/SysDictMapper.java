package system.dao;

import system.entity.SysDict;
import system.entity.SysDictExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysDictMapper {
    @SelectProvider(type=SysDictSqlProvider.class, method="countByExample")
    long countByExample(SysDictExample example);

    @DeleteProvider(type=SysDictSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDictExample example);

    @Delete({
        "delete from sys_dict",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_dict (id, item_code, ",
        "item_name, type_code, ",
        "type_name, sort, ",
        "create_by, create_date, ",
        "update_by, update_date, ",
        "remarks)",
        "values (#{id,jdbcType=VARCHAR}, #{itemCode,jdbcType=VARCHAR}, ",
        "#{itemName,jdbcType=VARCHAR}, #{typeCode,jdbcType=VARCHAR}, ",
        "#{typeName,jdbcType=VARCHAR}, #{sort,jdbcType=DECIMAL}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR})"
    })
    int insert(SysDict record);

    @InsertProvider(type=SysDictSqlProvider.class, method="insertSelective")
    int insertSelective(SysDict record);

    @SelectProvider(type=SysDictSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="item_code", property="itemCode", jdbcType= JdbcType.VARCHAR),
        @Result(column="item_name", property="itemName", jdbcType= JdbcType.VARCHAR),
        @Result(column="type_code", property="typeCode", jdbcType= JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    List<SysDict> selectByExample(SysDictExample example);

    @Select({
        "select",
        "id, item_code, item_name, type_code, type_name, sort, create_by, create_date, ",
        "update_by, update_date, remarks",
        "from sys_dict",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="item_code", property="itemCode", jdbcType= JdbcType.VARCHAR),
        @Result(column="item_name", property="itemName", jdbcType= JdbcType.VARCHAR),
        @Result(column="type_code", property="typeCode", jdbcType= JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    SysDict selectByPrimaryKey(String id);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDict record);

    @Update({
        "update sys_dict",
        "set item_code = #{itemCode,jdbcType=VARCHAR},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "type_code = #{typeCode,jdbcType=VARCHAR},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=DECIMAL},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysDict record);
}