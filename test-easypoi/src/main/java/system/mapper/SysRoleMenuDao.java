package system.mapper;


import system.dao.SysRoleMenuMapper;
import system.entity.SysMenu;
import system.entity.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuDao extends SysRoleMenuMapper {

    Boolean deleteMenuRoleByRoleId(String roleId);

    Boolean insertMenuRoleRel(String roleId, String menuId);

    List<String> selectMenuIdByRoleId(String id);

    List<SysMenu> selectMenuByRoleId(String id);

    void insertBatch(List<SysRoleMenu> list);
}
