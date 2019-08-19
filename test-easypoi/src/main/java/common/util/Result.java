package common.util;

import java.io.Serializable;

/**
 * @author: Lixiaofei
 * @date: 2019/1/12 10:09
 * @version  1.0
 */
public class Result<T> implements Serializable {
    private int code = 0;
    private Boolean success = true;
    private String msg;
    private T data;

    public Result(int code) {
        super();
        this.code = code;
    }

    public Result<T> success(boolean success) {
        this.success = success;
        return this;

    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public Result<T> info(String msg) {
        this.msg = msg;
        return this;
    }

    public Result(int code, Boolean success, String msg, T data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
