package system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Fix implements Serializable {
    public Fix() {
    }

    public Fix(String username) {
        this.username = username;
    }

    public Fix(Integer fixid) {
        this.fixid = fixid;
    }

    public Fix(Integer fixid, String sbmc, String value, String sushe, String time, String content, String imgurl, String username, Date timenow, String type1) {
        this.fixid = fixid;
        this.sbmc = sbmc;
        this.value = value;
        this.sushe = sushe;
        this.time = time;
        this.content = content;
        this.imgurl = imgurl;
        this.username = username;
        this.timenow = timenow;
        this.type1 = type1;
    }

    public Fix(Integer fixid, String content2, Integer pingfen) {
        this.fixid = fixid;
        this.content2 = content2;
        this.pingfen = pingfen;
    }

    public Fix(String sbmc, String value, String sushe, String time, String content, String imgurl, String username) {
        this.sbmc = sbmc;
        this.value = value;
        this.sushe = sushe;
        this.time = time;
        this.content = content;
        this.imgurl = imgurl;
        this.username = username;
    }

    //    fixid---int—主键，表内自增。
//    sbmc(设备名称String),
//    xiaoqu(校区String),
//    value(公寓号String),
//    sushe(宿舍号String),
//    time(预期时间String),
//    content(情况描述String),
//    imgurl(图片File),
//    username(用户名String)
//    timenow（请求时间Date）
    private Integer fixid;
    private String sbmc;
    private String value;
    private String sushe;
    private String time;
    private String content;
    private String imgurl;
    private String username;
    private Date timenow;
    private String type1;
    private String content2;
    private Integer pingfen;

}
