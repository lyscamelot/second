package textpoi.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Author: Lixiaofei
 * @Date: 2018/11/29 19:34
 * @Version 1.0
 */
public class Person {
        @Excel(name = "姓名", orderNum = "0")
        private String name;

        @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
        private String sex;

        public Person(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

}
