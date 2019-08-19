package system.model.vo;

import common.util.BeanUtilsEx;
import system.entity.SysMenu;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SysMenuVo extends SysMenu {
    private int _level;
    private List<SysMenuVo> children;

    private static Set<String> getId(List<SysMenu> menus) {
        Set<String> hasMenu = new HashSet<>();
        for (SysMenu menu : menus) {
            hasMenu.add(menu.getId());
        }
        return hasMenu;
    }

    public static void convertTreeNode(List<SysMenuVo> treeNodeList, List<SysMenu> menuList) {

        Set<String> hashMap = getId(menuList);
        for (SysMenu menu : menuList) {
            if (!hashMap.contains(menu.getParentId())) {
                SysMenuVo sysMenuVo = new SysMenuVo();
                try {
                    BeanUtilsEx.copyProperties(sysMenuVo, menu);
                    sysMenuVo.set_level(1);
                    sysMenuVo.setChildren(getNode(menu.getId(), menuList, sysMenuVo.get_level()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                treeNodeList.add(sysMenuVo);
            }
        }
    }

    private static List<SysMenuVo> getNode(String parentId, List<SysMenu> menuList, int parentLevel) throws InvocationTargetException, IllegalAccessException {
        List<SysMenuVo> nodeList = new ArrayList<>();
        for (SysMenu menu : menuList) {
            if (parentId.equals(menu.getParentId())) {
                SysMenuVo sysMenuVo = new SysMenuVo();
                BeanUtilsEx.copyProperties(sysMenuVo, menu);
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

    public List<SysMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuVo> children) {
        this.children = children;
    }


}
