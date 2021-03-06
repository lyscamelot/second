package system.entity;

import java.io.Serializable;
import java.util.Date;

public class   SysArea implements Serializable {
    /**
     * 编号
     */
    private String id;

    /**
     * 父级编号
     */
    private String parentId;

    /**
     * 所有父级编号
     */
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 行政区划代码
     */
    private String code;

    /**
     * 区域类型
     */
    private String type;

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
     * This field corresponds to the database table sys_area
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.id
     *
     * @return the value of sys_area.id
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.id
     *
     * @param id the value for sys_area.id
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.parent_id
     *
     * @return the value of sys_area.parent_id
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.parent_id
     *
     * @param parentId the value for sys_area.parent_id
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.parent_ids
     *
     * @return the value of sys_area.parent_ids
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.parent_ids
     *
     * @param parentIds the value for sys_area.parent_ids
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.name
     *
     * @return the value of sys_area.name
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.name
     *
     * @param name the value for sys_area.name
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.sort
     *
     * @return the value of sys_area.sort
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public Long getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.sort
     *
     * @param sort the value for sys_area.sort
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.code
     *
     * @return the value of sys_area.code
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.code
     *
     * @param code the value for sys_area.code
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.type
     *
     * @return the value of sys_area.type
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.type
     *
     * @param type the value for sys_area.type
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.create_by
     *
     * @return the value of sys_area.create_by
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.create_by
     *
     * @param createBy the value for sys_area.create_by
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.create_date
     *
     * @return the value of sys_area.create_date
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.create_date
     *
     * @param createDate the value for sys_area.create_date
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.update_by
     *
     * @return the value of sys_area.update_by
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.update_by
     *
     * @param updateBy the value for sys_area.update_by
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.update_date
     *
     * @return the value of sys_area.update_date
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.update_date
     *
     * @param updateDate the value for sys_area.update_date
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.remarks
     *
     * @return the value of sys_area.remarks
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.remarks
     *
     * @param remarks the value for sys_area.remarks
     *
     * @mbggenerated Thu Oct 25 14:52:48 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}