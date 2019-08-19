package system.model.vo;

import common.util.BeanUtilsEx;
import system.entity.SysDept;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: Lixiaofei
 * @Date: 2018/10/25 15:52
 * @Version 1.0
 */
public class SysDeptTreeVo extends SysDept {

    private int _level;
    /**
     * 子菜单
     */
    private List<SysDeptTreeVo> children = new ArrayList<>();

    private static Set<String> getId(List<SysDept> depts) {
        return depts.stream().map(SysDept::getId).collect(Collectors.toSet());
    }


    public static void convertTreeNode(List<SysDeptTreeVo> treeNodeList, List<SysDept> deptList) {
//        Set<String> hasDept = getId(deptList);

//        treeNodeList = deptList.stream().filter(item -> !hasDept.contains(item.getParentId())).map(item -> {
//            SysDeptTreeVo sysDeptTreeVo = new SysDeptTreeVo();
//            try {
//                BeanUtilsEx.copyProperties(sysDeptTreeVo,item);
//                sysDeptTreeVo.set_level(1);
//                sysDeptTreeVo.setChildren(getNode(item.getId(), deptList, sysDeptTreeVo.get_level()));
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            return sysDeptTreeVo;
//        }).collect(Collectors.toList());
        Set<String> hashMap = getId(deptList);
        for (SysDept dept : deptList) {
            if (!hashMap.contains(dept.getParentId())) {
                SysDeptTreeVo sysDeptTreeVo = new SysDeptTreeVo();
                try {
                    BeanUtilsEx.copyProperties(sysDeptTreeVo, dept);
                    sysDeptTreeVo.set_level(1);
                    sysDeptTreeVo.setChildren(getNode(dept.getId(), deptList, sysDeptTreeVo.get_level()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                treeNodeList.add(sysDeptTreeVo);
            }
        }

    }

    private static List<SysDeptTreeVo> getNode(String parentId, List<SysDept> deptList, int parentLevel) throws InvocationTargetException, IllegalAccessException {
        List<SysDeptTreeVo> nodeList = new ArrayList<>();
        for (SysDept dept : deptList) {
            if (parentId.equals(dept.getParentId())) {
                SysDeptTreeVo sysDeptTreeVo = new SysDeptTreeVo();
                BeanUtilsEx.copyProperties(sysDeptTreeVo, dept);
                sysDeptTreeVo.set_level(parentLevel + 1);
                sysDeptTreeVo.setChildren(getNode(dept.getId(), deptList, sysDeptTreeVo.get_level()));
                nodeList.add(sysDeptTreeVo);
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

    public List<SysDeptTreeVo> getChildren() {
        return this.children;
    }

    public void setChildren(List<SysDeptTreeVo> children) {
        this.children = children;
    }

}
