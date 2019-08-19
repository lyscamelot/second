package common.util;

/**
 * @author aeizzz
 */

public class Res {

    public static <T> Result<T> makeOKRsp() {
        return new Result<T>(0).success(true);
    }

    public static <T> Result<T> makeOKRsp(String info) {
        return new Result<T>(0).info(info);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>(0).success(true).data(data);
    }

    public static <T> Result<T> makeErrRsp(String info) {
        return new Result<T>(1).success(false).info(info);
    }

    public static <T> Result<T> makeRsp(boolean success, String msg) {
        return new Result<T>(0).success(success).info(msg);
    }

    public static <T> Result<T> makeRsp(int code, String msg, T data) {
        return new Result<T>(code).info(msg).data(data);
    }


}
