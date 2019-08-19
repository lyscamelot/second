package system.mapper;


import system.dao.SysUserRoleMapper;
import system.entity.SysUser;
import system.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleDao extends SysUserRoleMapper {

    List<String> queryRoleIdList(String userId);

    List<SysUser> listUserByRoleId(String id);

    Boolean deleteUserRoleByRoleId(String id);

    Boolean insertUserRoleRel(String roleId, String userId);

    List<String> listUserIdByRoleId(String id);

    void insertBatch(List<SysUserRole> list);
}
