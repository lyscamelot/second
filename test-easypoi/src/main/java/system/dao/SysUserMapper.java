package system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import system.entity.SysUser;
import system.entity.SysUserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser>{
    @SelectProvider(type=SysUserSqlProvider.class, method="countByExample")
    long countByExample(SysUserExample example);

    @DeleteProvider(type=SysUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserExample example);

    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_user (id, wx_id, ",
        "login_name, password, ",
        "no, name, email, ",
        "phone, mobile, user_type, ",
        "photo, login_flag, ",
        "create_by, create_date, ",
        "update_by, update_date, ",
        "remarks)",
        "values (#{id,jdbcType=VARCHAR}, #{wxId,jdbcType=VARCHAR}, ",
        "#{loginName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{no,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{userType,jdbcType=CHAR}, ",
        "#{photo,jdbcType=VARCHAR}, #{loginFlag,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR})"
    })
    int insert(SysUser record);

    @InsertProvider(type=SysUserSqlProvider.class, method="insertSelective")
    int insertSelective(SysUser record);

    @SelectProvider(type=SysUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="wx_id", property="wxId", jdbcType= JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType= JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType= JdbcType.VARCHAR),
        @Result(column="no", property="no", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType= JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType= JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType= JdbcType.VARCHAR),
        @Result(column="user_type", property="userType", jdbcType= JdbcType.CHAR),
        @Result(column="photo", property="photo", jdbcType= JdbcType.VARCHAR),
        @Result(column="login_flag", property="loginFlag", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    List<SysUser> selectByExample(SysUserExample example);

    @Select({
        "select",
        "id, wx_id, login_name, password, no, name, email, phone, mobile, user_type, ",
        "photo, login_flag, create_by, create_date, update_by, update_date, remarks",
        "from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="wx_id", property="wxId", jdbcType= JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType= JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType= JdbcType.VARCHAR),
        @Result(column="no", property="no", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType= JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType= JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType= JdbcType.VARCHAR),
        @Result(column="user_type", property="userType", jdbcType= JdbcType.CHAR),
        @Result(column="photo", property="photo", jdbcType= JdbcType.VARCHAR),
        @Result(column="login_flag", property="loginFlag", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR)
    })
    SysUser selectByPrimaryKey(String id);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUser record);

    @Update({
        "update sys_user",
        "set wx_id = #{wxId,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "no = #{no,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "user_type = #{userType,jdbcType=CHAR},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "login_flag = #{loginFlag,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysUser record);
}