package system.controller;

import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.util.Page;
import common.util.Res;
import common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import system.entity.SysDept;
import system.entity.SysMenu;
import system.entity.SysRole;
import system.entity.SysUser;
import system.service.SysRoleDeptService;
import system.service.SysRoleMenuService;
import system.service.SysRoleService;
import system.service.SysUserRoleService;
import system.model.vo.SysDeptTreeVo;
import system.model.vo.SysMenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * SysRoleController
 *
 * @author MBG
 */
@RestController
public class SysRoleController extends BaseController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysRoleMenuService sysRoleMenuService;
    @Autowired
    SysRoleDeptService sysRoleDeptService;
    @Autowired
    SysUserRoleService sysUserRoleService;

    /**
     * 保存
     *
     * @param entity 实体类
     */
    @PostMapping("/sysRole/save")
    public Result save(SysRole entity) {
        try {
            this.sysRoleService.save(entity);
            return Res.makeOKRsp("保存成功");
        } catch (AppException e) {
            return Res.makeErrRsp("保存失败");
        }
    }

    /**
     * 删除
     *
     * @param id 主键
     */
    @GetMapping("/sysRole/delete")
    public Result update(String id) {
        try {
            this.sysRoleService.delete(id);
            return Res.makeOKRsp("删除成功");
        } catch (AppException e) {
            return Res.makeErrRsp("删除失败");
        }
    }

    /**
     * 基础详情
     *
     * @param id 主键
     */
    @GetMapping("/sysRole/query/detail")
    public Result<SysRole> detail(String id) {
        SysRole entity = this.sysRoleService.getById(id);
        return Res.makeOKRsp(entity);

    }

    /**
     * 分页查询
     *
     * @param entity 查询参数
     * @param page   分页参数
     */
    @GetMapping("/sysRole/query/page")
    public Result<PageInfo<SysRole>> update(SysRole entity, Page page) {
        PageInfo<SysRole> pages = this.sysRoleService.queryPage(entity, page);
        return Res.makeOKRsp(pages);

    }

    /**
     * 角色详情菜单
     *
     * @param id
     * @return
     */
    @GetMapping("/sysRole/selectMenuByRoleIdTree")
    public Result<List<SysMenuVo>> selectMenuByRoleId(String id) {
        List<SysMenu> list = sysRoleMenuService.selectMenuByRoleId(id);
        List<SysMenuVo> treechildren = new ArrayList<>();
        SysMenuVo.convertTreeNode(treechildren, list);
        return Res.makeOKRsp(treechildren);
    }

    /**
     * 角色详情部门
     *
     * @param id
     * @return
     */
    @GetMapping("/sysRole/selectDeptByRoleIdTree")
    public Result<List<SysDeptTreeVo>> selectDeptByRoleId(String id) {
        List<SysDept> list = sysRoleDeptService.selectDeptByRoleId(id);
        List<SysDeptTreeVo> resultlist = new ArrayList<>();
        SysDeptTreeVo.convertTreeNode(resultlist, list);
        return Res.makeOKRsp(resultlist);
    }

    /**
     * 角色详情用户
     *
     * @param id
     * @return
     */
    @GetMapping("/sysRole/listUserByRoleId")
    public Result<List<SysUser>> listUserByRoleId(String id) {
        List<SysUser> list = sysUserRoleService.listUserByRoleId(id);
        return Res.makeOKRsp(list);
    }

    /**
     * 标记当前角色能看到的菜单 非树形
     * 功能权限
     *
     * @param id
     * @return
     */
    @GetMapping("/sysRole/listMenuIdByRoleId")
    public Result<List<String>> listMenuByRoleId(String id) {
        List<String> list = sysRoleMenuService.selectMenuIdByRoleId(id);
        return Res.makeOKRsp(list);
    }


    /**
     * 标记当前角色能看到的部门 非树形
     * 数据权限
     *
     * @param id
     * @return
     */
    @GetMapping("/sysDept/selectDeptIdByRoleId")
    public Result<List<String>> listDeptByRoleId(String id) {
        List<String> list = sysRoleDeptService.selectDeptIdByRoleId(id);
        return Res.makeOKRsp(list);
    }
}

