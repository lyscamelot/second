package system.service;



import system.entity.SysDept;

import java.util.List;

/**
 * SysRoleDept接口
 *
 * @author MBG
 */
public interface SysRoleDeptService {

    List<String> queryDeptIdList(String[] ids);

    List<SysDept> selectDeptByRoleId(String id);

    /**
     * 删除对应关系，role与dept
     * @param id
     * @return
     */
    Boolean deleteDeptRoleByRoleId(String id);

    /**
     * 插入role与dept的对应关系
     * @param roleId
     * @param userId
     * @return
     */
    Boolean insertDeptRoleRel(String roleId, String userId);

    /**
     * 保存role与dept的对应关系
     * @param roleId
     * @param id
     */
    void saveDeptRole(String roleId, String[] id);

    List<String> selectDeptIdByRoleId(String id);
}
