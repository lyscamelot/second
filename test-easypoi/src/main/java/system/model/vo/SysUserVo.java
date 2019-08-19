package system.model.vo;


import system.entity.SysUser;

public class SysUserVo extends SysUser {
    private String deptId;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
