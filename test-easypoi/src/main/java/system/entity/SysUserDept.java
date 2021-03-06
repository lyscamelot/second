package system.entity;

import java.io.Serializable;

public class SysUserDept implements Serializable {
    /**
     * 角色编号
     */
    private String userId;

    /**
     * 部门编号
     */
    private String deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_user_dept
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_dept.user_id
     *
     * @return the value of sys_user_dept.user_id
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_dept.user_id
     *
     * @param userId the value for sys_user_dept.user_id
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_dept.dept_id
     *
     * @return the value of sys_user_dept.dept_id
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_dept.dept_id
     *
     * @param deptId the value for sys_user_dept.dept_id
     *
     * @mbggenerated Thu Oct 25 14:52:49 CST 2018
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }
}