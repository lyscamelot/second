package system.service;


import system.entity.SysMenu;

import java.util.List;

/**
*SysRoleMenu接口
*
* @author MBG
*/
public interface SysRoleMenuService {

    List<String> selectMenuIdByRoleId(String id);


    /**
     * 删除对应关系，role与menu
     * @param id
     * @return
     */
    boolean deleteMenuRoleByRoleId(String id);

    /**
     * 插入role与menu的对应关系
     * @param roleId
     * @param userId
     * @return
     */
    boolean insertMenuRoleRel(String roleId, String userId);

    /**
     * 保存role与menu的对应关系
     * @param roleId
     * @param id
     */
    void saveMenuRole(String roleId, String[] id);

    List<SysMenu> selectMenuByRoleId(String id);
}
