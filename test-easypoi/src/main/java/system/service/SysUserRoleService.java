package system.service;


import system.entity.SysUser;

import java.util.List;

/**
 * SysUserRole接口
 *
 * @author MBG
 */
public interface SysUserRoleService {

    /**
     * 根据用户id查询角色ID
     * @param userId
     * @return
     */
    List<String> queryRoleIdList(String userId);

    /**
     * 根据角色查询成员
     * @param id
     * @return
     */
    List<SysUser> selectUserByRoleId(String id);


    /**
     * 用过角色查找用户
     * @param id
     * @return
     */
    List<SysUser> listUserByRoleId(String id);

    /**
     * 删除对应关系，role与user
     * @param id
     * @return
     */
    boolean deleteUserRoleByRoleId(String id);

    /**
     * 插入role与user的对应关系
     * @param roleId
     * @param userId
     * @return
     */
    boolean insertUserRoleRel(String roleId, String userId);

    /**
     * 保存role与user的对应关系
     * @param roleId
     * @param id
     */
    void saveUserRole(String roleId, String[] id);

    /**
     * 查询当前角色id下所有用户
     * @param id
     * @return
     */
    List<String> selectUserIdByRoleId(String id);
}
