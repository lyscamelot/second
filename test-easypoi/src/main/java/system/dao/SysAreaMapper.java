package system.dao;

import system.entity.SysArea;
import system.entity.SysAreaExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysAreaMapper {
    @SelectProvider(type=SysAreaSqlProvider.class, method="countByExample")
    long countByExample(SysAreaExample example);

    @DeleteProvider(type=SysAreaSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysAreaExample example);

    @Delete({
        "delete from sys_area",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_area (id, parent_id, ",
        "parent_ids, name, ",
        "sort, code, type, ",
        "create_by, create_date, ",
        "update_by, update_date, ",
        "remarks)",
        "values (#{id,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{parentIds,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=DECIMAL}, #{code,jdbcType=VARCHAR}, #{type,jdbcType=CHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR})"
    })
    int insert(SysArea record);

    @InsertProvider(type=SysAreaSqlProvider.class, method="insertSelective")
    int insertSelective(SysArea record);

    @SelectProvider(type=SysAreaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_ids", property="parentIds", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="code", property="code", jdbcType= JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType= JdbcType.CHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    List<SysArea> selectByExample(SysAreaExample example);

    @Select({
        "select",
        "id, parent_id, parent_ids, name, sort, code, type, create_by, create_date, update_by, ",
        "update_date, remarks",
        "from sys_area",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_ids", property="parentIds", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="code", property="code", jdbcType= JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType= JdbcType.CHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    SysArea selectByPrimaryKey(String id);

    @UpdateProvider(type=SysAreaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysArea record, @Param("example") SysAreaExample example);

    @UpdateProvider(type=SysAreaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysArea record, @Param("example") SysAreaExample example);

    @UpdateProvider(type=SysAreaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysArea record);

    @Update({
        "update sys_area",
        "set parent_id = #{parentId,jdbcType=VARCHAR},",
          "parent_ids = #{parentIds,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=DECIMAL},",
          "code = #{code,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=CHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysArea record);
}