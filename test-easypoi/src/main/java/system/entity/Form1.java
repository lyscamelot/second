package system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Form1 implements Serializable {
    public String value;
    public  String username;
    public String imgurl;
    public String content;
    public String touxiang;
    public String type1;
    public Date timenow;
    public Integer fixid;

    @Override
    public String toString() {
        return "Form1{" +
                "username='" + username + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", content='" + content + '\'' +
                ", touxiang='" + touxiang + '\'' +
                ", type='" + type1 + '\'' +
                ", retime=" + timenow +
                ", fixid=" + fixid +
                '}';
    }
}
