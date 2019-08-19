package system.controller;

import common.exception.AppException;
import common.util.Res;
import common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import system.entity.SysMenu;
import system.service.SysMenuService;
import system.service.SysRoleMenuService;
import system.model.vo.SysMenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * SysMenuController
 *
 * @author MBG
 */
@RestController
public class SysMenuController extends BaseController {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysRoleMenuService sysRoleMenuService;

    /**
     * 保存
     *
     * @param entity 实体类
     */
    @PostMapping("/sysMenu/save")
    public Result save(SysMenu entity) {
        try {
            this.sysMenuService.save(entity);
        } catch (AppException e) {
            return Res.makeErrRsp("保存失败");
        }
        return Res.makeOKRsp("保存成功");
    }

    /**
     * 删除
     *
     * @param id 主键
     */
    @GetMapping("/sysMenu/delete")
    public Result update(String id) {
        try {
            this.sysMenuService.delete(id);
        } catch (AppException e) {
            return Res.makeErrRsp("删除失败");
        }
        return Res.makeOKRsp("删除成功");
    }

    /**
     * 基础详情
     *
     * @param id 主键
     */
    @GetMapping("/sysMenu/query/detail")
    public Result<SysMenu> detail(String id) {
        SysMenu entity = this.sysMenuService.getById(id);
        return Res.makeOKRsp(entity);

    }

    /**
     * 获取菜单
     *
     * @return
     */
    @GetMapping("/sysMenu/findAllMenu")
    public Result<List<SysMenuVo>> getAllMenu(String name) {
        List<SysMenu> menuList = sysMenuService.getAllMenu(name);
        List<SysMenuVo> treechildren = new ArrayList<>();
        SysMenuVo.convertTreeNode(treechildren, menuList);
        return Res.makeOKRsp(treechildren);
    }

    @PostMapping("/sysMenu/saveMenuRole")
    public Result saveMenuRole(String roleId, String[] id) {
        try {
            sysRoleMenuService.saveMenuRole(roleId, id);
        } catch (Exception e) {
            return Res.makeErrRsp("保存失败!");
        }
        return Res.makeOKRsp("保存成功");
    }


}

