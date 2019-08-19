package system.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 
 * @author lxf
 * @date 2019-03-19 10:42:51
 * @version V1.0
 */
@TableName("sys_captcha")
public class CaptchaDO implements Serializable {
    private static final long serialVersionUID = 1L;

	@TableId(value = "id",type = IdType.ID_WORKER_STR)
	@ApiModelProperty(value="id",name="id")
    private String id;

	@TableField(value = "code")
	@ApiModelProperty(value="验证码",name="code")
    private String code;

	@TableField(value = "expire_time")
	@ApiModelProperty(value="过期时间",name="expireTime")
    private Date expireTime;


    /** 设置：id */
	public void setId(String id) {
		this.id = id;
	}

    /** 获取：id */
    public String getId() {
        return id;
    }

    /** 设置：验证码 */
	public void setCode(String code) {
		this.code = code;
	}

    /** 获取：验证码 */
    public String getCode() {
        return code;
    }

    /** 设置：过期时间 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

    /** 获取：过期时间 */
    public Date getExpireTime() {
        return expireTime;
    }
    @Override
    public String toString() {
        return "captchaDO{" +
                ", id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", expireTime='" + expireTime + '\'' +
                '}';
    }
}
