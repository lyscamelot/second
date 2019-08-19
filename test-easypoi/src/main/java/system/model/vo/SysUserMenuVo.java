package system.model.vo;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SysUserMenuVo extends UserMenuVo {
    private int _level;
    private List<SysUserMenuVo> children;

    private static Set<String> getId(List<UserMenuVo> menus) {
        Set<String> hasMenu = new HashSet<>();
        for (UserMenuVo menu : menus) {
            hasMenu.add(menu.getId());
        }
        return hasMenu;
    }

    public static void convertTreeNode(List<SysUserMenuVo> treeNodeList, List<UserMenuVo> menuList) {

        Set<String> hashMap = getId(menuList);
        for (UserMenuVo menu : menuList) {
            if (!hashMap.contains(menu.getParentId())) {
                SysUserMenuVo sysUserMenuVo = new SysUserMenuVo();
                try {
                    BeanUtils.copyProperties(sysUserMenuVo, menu);
                    sysUserMenuVo.set_level(1);
                    sysUserMenuVo.setChildren(getNode(menu.getId(), menuList, sysUserMenuVo.get_level()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                treeNodeList.add(sysUserMenuVo);
            }
        }
    }

    private static List<SysUserMenuVo> getNode(String parentId, List<UserMenuVo> menuList, int parentLevel) throws InvocationTargetException, IllegalAccessException {
        List<SysUserMenuVo> nodeList = new ArrayList<>();
        for (UserMenuVo menu : menuList) {
            if (parentId.equals(menu.getParentId())) {
                SysUserMenuVo sysMenuVo = new SysUserMenuVo();
                BeanUtils.copyProperties(sysMenuVo, menu);
                sysMenuVo.set_level(parentLevel + 1);
                sysMenuVo.setChildren(getNode(menu.getId(), menuList, sysMenuVo.get_level()));
                nodeList.add(sysMenuVo);
            }
        }
        if (nodeList.isEmpty()) {
            return null;
        }
        return nodeList;
    }

    public int get_level() {
        return _level;
    }

    public void set_level(int _level) {
        this._level = _level;
    }


    public List<SysUserMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<SysUserMenuVo> children) {
        this.children = children;
    }
}
