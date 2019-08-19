package system.mapper;



import system.dao.SysRoleMapper;
import system.entity.SysRole;

import java.util.List;

public interface SysRoleDao extends SysRoleMapper {

    List<SysRole> getAllRole();
}
