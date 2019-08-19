package system.mapper;

import system.dao.SysRoleDeptMapper;
import system.entity.SysDept;
import system.entity.SysRoleDept;

import java.util.List;

public interface SysRoleDeptDao extends SysRoleDeptMapper {

    List<String> queryDeptIdList(String[] ids);

    List<SysDept> selectDeptByRoleId(String id);

    Boolean deleteDeptRoleByRoleId(String id);

    Boolean insertDeptRoleRel(String roleId, String deptId);

    List<String> selectDeptIdByRoleId(String id);

    void insertBatch(List<SysRoleDept> list);
}
