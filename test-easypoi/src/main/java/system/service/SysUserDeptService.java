package system.service;

import system.entity.SysDept;
import system.entity.SysUserDept;

/**
 * @author: Lixiaofei
 * @date: 2019/2/6 17:19
 */
public interface SysUserDeptService {


    SysUserDept getByUserId(String loginName);

}
