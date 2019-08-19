package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysDept;
import system.entity.SysRoleDept;
import system.mapper.SysRoleDeptDao;
import system.service.SysRoleDeptService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 7326
 */
@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService {

    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;

    @Override
    public List<String> queryDeptIdList(String[] ids) {
        return sysRoleDeptDao.queryDeptIdList(ids);
    }

    @Override
    public List<SysDept> selectDeptByRoleId(String id) {
        return sysRoleDeptDao.selectDeptByRoleId(id);
    }

    @Override
    public Boolean deleteDeptRoleByRoleId(String id) {
        return sysRoleDeptDao.deleteDeptRoleByRoleId(id);
    }

    @Override
    public Boolean insertDeptRoleRel(String roleId, String deptId) {
        return sysRoleDeptDao.insertDeptRoleRel(roleId, deptId);
    }

    @Transactional
    @Override
    public void saveDeptRole(String roleId, String[] deptId) {
        sysRoleDeptDao.deleteDeptRoleByRoleId(roleId);


        List<SysRoleDept> list = new ArrayList<>();

        for (String id : deptId) {
            SysRoleDept sysRoleDept = new SysRoleDept();
            sysRoleDept.setRoleId(roleId);
            sysRoleDept.setDeptId(id);
            list.add(sysRoleDept);
        }
            sysRoleDeptDao.insertBatch(list);
    }

    @Override
    public List<String> selectDeptIdByRoleId(String id) {
        return sysRoleDeptDao.selectDeptIdByRoleId(id);
    }
}
