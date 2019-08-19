package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.SysUserDept;
import system.mapper.SysUserDeptDao;
import system.service.SysUserDeptService;

/**
 * @author: Lixiaofei
 * @date: 2019/2/6 17:19
 */
@Service
public class SysUserDeptServiceImpl implements SysUserDeptService{

    @Autowired
    SysUserDeptDao sysUserDeptDao;


    @Override
    public SysUserDept getByUserId(String loginName) {
        return sysUserDeptDao.selectByPrimaryKey(loginName);
    }
}
