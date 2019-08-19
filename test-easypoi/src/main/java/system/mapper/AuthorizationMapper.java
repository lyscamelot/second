package system.mapper;

import org.apache.ibatis.annotations.Mapper;
import system.entity.SysMenu;
import system.entity.SysRole;

import java.util.List;

/**
 * 授权相关DAO层逻辑
 * Created by lizhi on 2018/9/12.
 *
 * @author lizhi
 */
public interface AuthorizationMapper {
    /**
     * 获取用户角色列表
     *
     * @param userId 用户ID
     * @return 用户的角色列表
     */
    List<SysRole> queryRolesByUserId(String userId);

    /**
     * 获取用户权限（菜单）列表
     *
     * @param userId 用户ID
     * @return 用户的权限列表
     */
    List<SysMenu> queryMenusByUserId(String userId);


}
