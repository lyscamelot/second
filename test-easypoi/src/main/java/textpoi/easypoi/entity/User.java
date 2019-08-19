package textpoi.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Author: Lixiaofei
 * @Date: 2018/12/3 13:35
 * @Version 1.0
 */
public class User implements Serializable{

    @Excel(name="编号",width = 30)
    private String id;

    @Excel(name="姓名",isImportField = "username",width = 30)
    private String username;

    @Excel(name = "邮箱",isImportField = "email",width = 30)
    private String email;

    private String password;

    @Excel(name="所属部门",isImportField = "departmentName",width = 30)
    private String departmentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public User(String id, String username, String email, String password, String departmentName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.departmentName = departmentName;
    }
}
