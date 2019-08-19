package system.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import system.entity.SysUser;

/**
 * @author: Lixiaofei
 * @date: 2019/1/12 10:42
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }
}
