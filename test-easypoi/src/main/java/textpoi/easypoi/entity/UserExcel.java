package textpoi.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author: Lixiaofei
 * @date: 2019/3/28 15:31
 */
public class UserExcel {
//    @Excel(name="编号",width = 30)
//    private String id;
//

    @Excel(name="姓名",isImportField = "name",width = 30)
    private String name;

    @Excel(name = "邮箱",isImportField = "email",width = 30)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
