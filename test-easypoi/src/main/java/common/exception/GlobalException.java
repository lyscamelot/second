package common.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Lixiaofei
 * @date: 2019/5/4 21:08
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request, Exception e){
        return "无权访问！";
    }

}
