package system.controller;

import common.util.Page;
import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.util.Res;
import common.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import system.entity.*;
import system.service.SysUserDeptService;
import system.service.SysUserRoleService;
import system.service.SysUserService;
import system.model.vo.SysDeptTreeVo;
import system.model.vo.SysMenuVo;
import system.model.vo.SysUserVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Lixiaofei
 * @Date: 2019/1/12 10:05
 * @Version 1.0
 */
@RestController
public class SysUserController extends BaseController {


    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserDeptService sysUserDeptService;

    @Autowired
    SysUserRoleService sysUserRoleService;
    /**
     * 保存
     *
     * @param sysUser
     * @param deptId
     * @return
     */
    @PostMapping("sysUser/save")
    public Result save(SysUser sysUser, String deptId) {
        try {
            sysUser.setUpdateDate(new Date());
//            sysUser.setUpdateBy(getUser().getId());
            sysUser.setCreateDate(new Date());
//            sysUser.setCreateBy(getUser().getId());
            String id = sysUserService.saveUser(sysUser);
            SysUserDept userDept = new SysUserDept();
            userDept.setUserId(id);
            userDept.setDeptId(deptId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Res.makeErrRsp("保存失败");
        }
        return Res.makeOKRsp("保存成功");
    }

    /**
     * 修改密码
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/admin/resetpwd")
    public Result changePwd(String userId) {
        this.sysUserService.resetPassword(userId);
        return Res.makeOKRsp();
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @GetMapping("/sysUser/delete")
    public Result delete(String id) {
        try {
            this.sysUserService.delete(id);
            return Res.makeOKRsp("删除成功");
        } catch (AppException e) {
            logger.error(e.getMessage());
            return Res.makeErrRsp("删除失败");
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @GetMapping("sysUser/deleteBatch")
    public Result deleteBatch(String[] ids) {
        try {
            sysUserService.deleteBatch(ids);
            return Res.makeOKRsp("删除成功");
        } catch (AppException e) {
            logger.error(e.getMessage());
            return Res.makeErrRsp("删除失败");
        }
    }

    /**
     * 根据用户id查询该用户角色信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/query/listRoleByUserId")
    public Result listRoleByUserId(@RequestParam("id") String userId) {
        List<SysRole> list = this.sysUserService.getRoleInfo(userId);
        return Res.makeOKRsp(list);
    }

    /**
     * 根据用户id查询用户的功能权限信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/query/listMenuByUserId")
    public Result listMenuByUserId(@RequestParam("id") String userId) {
        List<SysRole> roleList = this.sysUserService.getRoleInfo(userId);
        List<String> roleidList = new ArrayList<>();
        for (SysRole sysRole : roleList) {
            if (sysRole.getId() != null) {
                roleidList.add(sysRole.getId());
            }
        }
        List<SysMenu> menuList = this.sysUserService.getMenuinfo(roleidList);
        List<SysMenuVo> resultList = new ArrayList<>();
        SysMenuVo.convertTreeNode(resultList, menuList);
        return Res.makeOKRsp(resultList);
    }

    /**
     * 根据用户id查询该用户的部门信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/sysUser/query/listDeptByUserId")
    public Result getdeptinfo(@RequestParam(value = "id") String userId) {
        List<SysDept> deptList = this.sysUserService.getdeptinfo(userId);
        List<SysDeptTreeVo> resultlist = new ArrayList<>();
        SysDeptTreeVo.convertTreeNode(resultlist, deptList);
        return Res.makeOKRsp(resultlist);
    }

    /**
     * 基础详情
     *
     * @param id
     * @return
     */
    @RequiresPermissions("1")
    @GetMapping("/sysUser/query/detail")
    public Result detail(String id) {
        SysUser entity = this.sysUserService.getById(id);
        SysUserDept userDept = sysUserDeptService.getByUserId(entity.getId());
        SysUserVo userVo = new SysUserVo();
        try {
            BeanUtils.copyProperties(entity,userVo);
            userVo.setDeptId(userDept.getDeptId());
        } catch (Exception e) {
            e.printStackTrace();
            return Res.makeErrRsp("获取用户信息失败");
        }
        return Res.makeOKRsp(userVo);
    }

    /**
     * 分页查询
     * @param entity
     * @param page
     * @return
     */
    @GetMapping("/sysUser/query/page")
    public Result queryPage(SysUser entity,Page page){
        PageInfo<SysUser> pageInfos = this.sysUserService.queryPage(new HashMap<>(),entity, page);
        return Res.makeOKRsp(pageInfos);
    }

    /**
     * 返回所有人
     * @return
     */
    @GetMapping("/sysUser/getAllUser")
    public Result getAllUser(){
        List<SysUser> list = this.sysUserService.getAll();
        return Res.makeOKRsp(list);
    }

    /**
     * 获取当前角色下的用户
     * @return
     */
    @GetMapping("/sysUser/getUserIdByRoleId")
    public Result getUserIdByRoleId(String roleId){
        List<String> list = this.sysUserRoleService.selectUserIdByRoleId(roleId);
        return Res.makeOKRsp(list);
    }

    /**
     * 保存选定角色下的用户
     * @return
     */
    @PostMapping("/sysUser/saveUserRole")
    public Result saveUserRole(String roleId,String[] userId){
        try{
            this.sysUserRoleService.saveUserRole(roleId,userId);
        }catch (Exception e){
            return Res.makeErrRsp("保存失败");
        }
        return Res.makeOKRsp();
    }

}
