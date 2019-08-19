package system.shiro.bean;

import system.entity.SysMenu;
import system.entity.SysRole;
import system.entity.SysUser;

import java.util.List;

/**
 * @author: Lixiaofei
 * @date: 2019/1/13 10:51
 */
public class LoginUser extends SysUser{

    /**
     * 当前登陆用户的角色
     */
    List<SysRole> roleList;

    /**
     * 当前登陆用户的菜单
     */
    List<SysMenu> menuList;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }
}
