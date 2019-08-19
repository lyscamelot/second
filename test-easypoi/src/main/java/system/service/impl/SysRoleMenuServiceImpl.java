package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysMenu;
import system.entity.SysRoleMenu;
import system.mapper.SysRoleMenuDao;
import system.service.SysRoleMenuService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    SysRoleMenuDao sysRoleMenuDao;

    @Override
    public List<String> selectMenuIdByRoleId(String id) {
        return sysRoleMenuDao.selectMenuIdByRoleId(id);
    }

    @Override
    public boolean deleteMenuRoleByRoleId(String id) {
        return sysRoleMenuDao.deleteMenuRoleByRoleId(id);
    }

    @Override
    public boolean insertMenuRoleRel(String roleId, String userId) {
        return sysRoleMenuDao.insertMenuRoleRel(roleId,userId);
    }

    @Transactional
    @Override
    public void saveMenuRole(String roleId, String[] menuId) {
        sysRoleMenuDao.deleteMenuRoleByRoleId(roleId);

        List<SysRoleMenu> list = new ArrayList<>();


        for(String id : menuId) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(id);
            list.add(sysRoleMenu);
        }
        sysRoleMenuDao.insertBatch(list);
    }

    @Override
    public List<SysMenu> selectMenuByRoleId(String id) {
        return sysRoleMenuDao.selectMenuByRoleId(id);
    }
}
