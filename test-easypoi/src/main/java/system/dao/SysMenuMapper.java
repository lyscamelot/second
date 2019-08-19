package system.dao;

import system.entity.SysMenu;
import system.entity.SysMenuExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysMenuMapper {
    @SelectProvider(type=SysMenuSqlProvider.class, method="countByExample")
    long countByExample(SysMenuExample example);

    @DeleteProvider(type=SysMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMenuExample example);

    @Delete({
        "delete from sys_menu",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_menu (id, parent_id, ",
        "parent_ids, name, ",
        "sort, href, target, ",
        "icon, is_show, permission, ",
        "create_by, create_date, ",
        "update_by, update_date, ",
        "remarks)",
        "values (#{id,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{parentIds,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=DECIMAL}, #{href,jdbcType=VARCHAR}, #{target,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{isShow,jdbcType=CHAR}, #{permission,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR})"
    })
    int insert(SysMenu record);

    @InsertProvider(type=SysMenuSqlProvider.class, method="insertSelective")
    int insertSelective(SysMenu record);

    @SelectProvider(type=SysMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_ids", property="parentIds", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="href", property="href", jdbcType= JdbcType.VARCHAR),
        @Result(column="target", property="target", jdbcType= JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType= JdbcType.VARCHAR),
        @Result(column="is_show", property="isShow", jdbcType= JdbcType.CHAR),
        @Result(column="permission", property="permission", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    List<SysMenu> selectByExample(SysMenuExample example);

    @Select({
        "select",
        "id, parent_id, parent_ids, name, sort, href, target, icon, is_show, permission, ",
        "create_by, create_date, update_by, update_date, remarks",
        "from sys_menu",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_ids", property="parentIds", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="href", property="href", jdbcType= JdbcType.VARCHAR),
        @Result(column="target", property="target", jdbcType= JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType= JdbcType.VARCHAR),
        @Result(column="is_show", property="isShow", jdbcType= JdbcType.CHAR),
        @Result(column="permission", property="permission", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    SysMenu selectByPrimaryKey(String id);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMenu record);

    @Update({
        "update sys_menu",
        "set parent_id = #{parentId,jdbcType=VARCHAR},",
          "parent_ids = #{parentIds,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=DECIMAL},",
          "href = #{href,jdbcType=VARCHAR},",
          "target = #{target,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "is_show = #{isShow,jdbcType=CHAR},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysMenu record);
}