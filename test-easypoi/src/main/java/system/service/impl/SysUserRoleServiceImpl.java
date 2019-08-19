package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysUser;
import system.entity.SysUserRole;
import system.mapper.SysUserRoleDao;
import system.service.SysUserRoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao sysUserRoleDao;


    @Override
    public List<String> queryRoleIdList(String userId) {
        return sysUserRoleDao.queryRoleIdList(userId);
    }

    @Override
    public List<SysUser> selectUserByRoleId(String id) {
        return sysUserRoleDao.listUserByRoleId(id);
    }

    @Override
    public List<SysUser> listUserByRoleId(String id) {
        return sysUserRoleDao.listUserByRoleId(id);
    }

    @Override
    public boolean deleteUserRoleByRoleId(String id) {
        return sysUserRoleDao.deleteUserRoleByRoleId(id);
    }

    @Override
    public boolean insertUserRoleRel(String roleId, String userId) {
        return sysUserRoleDao.insertUserRoleRel(roleId, userId);
    }

    @Override
    @Transactional
    public void saveUserRole(String roleId, String[] id) {
        sysUserRoleDao.deleteUserRoleByRoleId(roleId);



        List<SysUserRole> list = new ArrayList<>();
        for (String i : id) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(i);
            list.add(sysUserRole);
        }
        sysUserRoleDao.insertBatch(list);
    }

    @Override
    public List<String> selectUserIdByRoleId(String id) {
        return sysUserRoleDao.listUserIdByRoleId(id);
    }
}
