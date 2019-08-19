package system.entity;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    /**
     * 编号
     */
    private String id;

    /**
     * 角色代码
     */
    private String enname;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_role
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.id
     *
     * @return the value of sys_role.id
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.id
     *
     * @param id the value for sys_role.id
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.enname
     *
     * @return the value of sys_role.enname
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getEnname() {
        return enname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.enname
     *
     * @param enname the value for sys_role.enname
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.name
     *
     * @return the value of sys_role.name
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.name
     *
     * @param name the value for sys_role.name
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_by
     *
     * @return the value of sys_role.create_by
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_by
     *
     * @param createBy the value for sys_role.create_by
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_date
     *
     * @return the value of sys_role.create_date
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_date
     *
     * @param createDate the value for sys_role.create_date
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.update_by
     *
     * @return the value of sys_role.update_by
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.update_by
     *
     * @param updateBy the value for sys_role.update_by
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.update_date
     *
     * @return the value of sys_role.update_date
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.update_date
     *
     * @param updateDate the value for sys_role.update_date
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.remarks
     *
     * @return the value of sys_role.remarks
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.remarks
     *
     * @param remarks the value for sys_role.remarks
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}