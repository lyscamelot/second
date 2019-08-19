package system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import system.dao.SysUserMapper;
import system.entity.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author: Lixiaofei
 * @date: 2019/1/12 11:01
 */
public interface SysUserDao extends SysUserMapper{

    /**
     * 获取默认密码
     * @param code
     * @return
     */
    SysParam getByCode(String code);

    /**
     * 批量删除
     * @param ids
     */
    void deleteBatch(String[] ids);

    /**
     * 根据用户id查询该用户角色
     * @param id
     * @return
     */
    List<SysRole> getRoleInfo(String id);

    /**
     * 根据角色查询功能权限
     * @param roleIds
     * @return
     */
    List<SysMenu> getMenuinfo(@Param("roleIds") List<String> roleIds);

    /**
     * 根据用户id查询部门信息
     * @param userId
     * @return
     */
    List<SysDept> getdeptinfo(@Param("userId") String userId);

    /**
     * 分页查询
     * @param hashMap
     * @return
     */
    List<SysUser> selectByparam(HashMap hashMap);


    /**
     * 查询所有人
     * @return
     */
    List<SysUser> getAll();

    /**
     * 查询当前角色下所有用户
     * @return
     */
    List<String> getUserIdByRoleId(String roleId);


    void saveUserRole(List<SysUserRole> list);
}
