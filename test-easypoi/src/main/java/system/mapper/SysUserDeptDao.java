package system.mapper;

import system.dao.SysUserDeptMapper;

import java.util.List;

public interface SysUserDeptDao extends SysUserDeptMapper {

    List<String> queryDeptIdList(String userId);

    List<String> queryUserIdList(String[] ids);
}
