package system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import common.util.Page;
import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import system.entity.SysDept;
import system.entity.SysMenu;
import system.entity.SysRole;
import system.entity.SysUser;

import java.util.HashMap;
import java.util.List;

/**
 * @author: Lixiaofei
 * @date: 2019/1/12 10:55
 */
public interface SysUserService extends IService<SysUser>{

    /**
     * 保存
     * */
    String saveUser(SysUser entity) throws AppException;

    /**
     * 修改密码
     * @param userId
     */
    void resetPassword(String userId);

    /**
     *删除
     */
    void delete(String id) throws AppException;

    /**
     *批量删除
     */
    void deleteBatch(String[] ids) throws AppException;

    /**
     * 根据id查询用户角色
     * @param userId
     * @return
     */
    List<SysRole> getRoleInfo(String userId);

    /**
     * 根据角色ids查询功能权限
     * @param roleIds
     * @return
     */
    List<SysMenu> getMenuinfo(List<String> roleIds);

    /**
     * 根据用户id查询部门信息
     * @param userId
     * @return
     */
    List<SysDept> getdeptinfo(String userId);
    /**
     * 基础详情
     * */
    SysUser getById(String id);

    /**
     * 分页查询
     * @param map
     * @param entity
     * @param page
     * @return
     */
    PageInfo<SysUser> queryPage(HashMap map,SysUser entity,Page page);

    /**
     * 根据username查询
     * @param username
     * @return
     */
    SysUser getUserByLoginUserName(String username);

    /**
     * 更改密码
     * @param userId
     * @param oldPwd
     * @param newPwd
     */
    int changePwd(String userId,String oldPwd,String newPwd);

    /**
     * 返回所有人
     * @return
     */
    List<SysUser> getAll();

    /**
     * 查询角色下的所有用户
     * @param roleId
     * @return
     */
    List<String> getUserIdByRoleId(String roleId);

    /**
     * 保存选定角色下的用户
     * @param roleId
     * @param userId
     */
    void saveUserRole(String roleId,String[] userId);

}
