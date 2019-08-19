package system.shiro.utils;

import org.apache.shiro.SecurityUtils;
import system.entity.SysUser;

/**   
* shiro工具类
* @author xxm  
* @date 2019/1/5 16:47 
* @version V1.0   
*/
public abstract class ShiroUtils {
    public static SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }
}
