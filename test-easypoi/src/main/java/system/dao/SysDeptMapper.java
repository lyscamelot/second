package system.dao;


import system.entity.SysDept;
import system.entity.SysDeptExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysDeptMapper {
    @SelectProvider(type=SysDeptSqlProvider.class, method="countByExample")
    long countByExample(SysDeptExample example);

    @DeleteProvider(type=SysDeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDeptExample example);

    @Delete({
        "delete from sys_dept",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_dept (id, parent_id, ",
        "parent_ids, name, ",
        "sort, create_by, ",
        "create_date, update_by, ",
        "update_date, remarks, ",
        "registered_capital, phone_number, ",
        "credit_code, address, ",
        "idcard_number, bank, ",
        "bank_branch, account_name, ",
        "account_number, type, ",
        "is_auth)",
        "values (#{id,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{parentIds,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=DECIMAL}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR}, ",
        "#{registeredCapital,jdbcType=VARCHAR}, #{phoneNumber,jdbcType=VARCHAR}, ",
        "#{creditCode,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{idcardNumber,jdbcType=VARCHAR}, #{bank,jdbcType=VARCHAR}, ",
        "#{bankBranch,jdbcType=VARCHAR}, #{accountName,jdbcType=VARCHAR}, ",
        "#{accountNumber,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{isAuth,jdbcType=VARCHAR})"
    })
    int insert(SysDept record);

    @InsertProvider(type=SysDeptSqlProvider.class, method="insertSelective")
    int insertSelective(SysDept record);

    @SelectProvider(type=SysDeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_ids", property="parentIds", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR),
        @Result(column="registered_capital", property="registeredCapital", jdbcType= JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType= JdbcType.VARCHAR),
        @Result(column="credit_code", property="creditCode", jdbcType= JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType= JdbcType.VARCHAR),
        @Result(column="idcard_number", property="idcardNumber", jdbcType= JdbcType.VARCHAR),
        @Result(column="bank", property="bank", jdbcType= JdbcType.VARCHAR),
        @Result(column="bank_branch", property="bankBranch", jdbcType= JdbcType.VARCHAR),
        @Result(column="account_name", property="accountName", jdbcType= JdbcType.VARCHAR),
        @Result(column="account_number", property="accountNumber", jdbcType= JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType= JdbcType.VARCHAR),
        @Result(column="is_auth", property="isAuth", jdbcType= JdbcType.VARCHAR)
    })
    List<SysDept> selectByExample(SysDeptExample example);

    @Select({
        "select",
        "id, parent_id, parent_ids, name, sort, create_by, create_date, update_by, update_date, ",
        "remarks, registered_capital, phone_number, credit_code, address, idcard_number, ",
        "bank, bank_branch, account_name, account_number, type, is_auth",
        "from sys_dept",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_ids", property="parentIds", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType= JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType= JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType= JdbcType.VARCHAR),
        @Result(column="registered_capital", property="registeredCapital", jdbcType= JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType= JdbcType.VARCHAR),
        @Result(column="credit_code", property="creditCode", jdbcType= JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType= JdbcType.VARCHAR),
        @Result(column="idcard_number", property="idcardNumber", jdbcType= JdbcType.VARCHAR),
        @Result(column="bank", property="bank", jdbcType= JdbcType.VARCHAR),
        @Result(column="bank_branch", property="bankBranch", jdbcType= JdbcType.VARCHAR),
        @Result(column="account_name", property="accountName", jdbcType= JdbcType.VARCHAR),
        @Result(column="account_number", property="accountNumber", jdbcType= JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType= JdbcType.VARCHAR),
        @Result(column="is_auth", property="isAuth", jdbcType= JdbcType.VARCHAR)
    })
    SysDept selectByPrimaryKey(String id);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDept record);

    @Update({
        "update sys_dept",
        "set parent_id = #{parentId,jdbcType=VARCHAR},",
          "parent_ids = #{parentIds,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=DECIMAL},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "registered_capital = #{registeredCapital,jdbcType=VARCHAR},",
          "phone_number = #{phoneNumber,jdbcType=VARCHAR},",
          "credit_code = #{creditCode,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "idcard_number = #{idcardNumber,jdbcType=VARCHAR},",
          "bank = #{bank,jdbcType=VARCHAR},",
          "bank_branch = #{bankBranch,jdbcType=VARCHAR},",
          "account_name = #{accountName,jdbcType=VARCHAR},",
          "account_number = #{accountNumber,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "is_auth = #{isAuth,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysDept record);
}