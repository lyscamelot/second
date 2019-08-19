package system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User1 implements Serializable {
//    @TableId

    private String username;
    private String password;
    private String sex;
    private String tel;
    private String touxiang;
    private Date retime;
    private Integer role;

}
