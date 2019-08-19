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
import system.service.SysDeptService;
import system.service.SysRoleDeptService;
import system.model.vo.SysDeptTreeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * SysDeptController
 *
 * @author MBG
 */
@RestController
public class SysDeptController extends BaseController {
    @Autowired
    SysDeptService sysDeptService;
    @Autowired
    SysRoleDeptService sysRoleDeptService;


    /**
     * 保存
     *
     * @param entity 实体类
     */
    @PostMapping("/sysDept/save")
    public Result save(SysDept entity) {
        try {
            this.sysDeptService.save(entity);
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
    @GetMapping("/sysDept/delete")
    public Result update(String id) {
        try {
            List<String> list = this.sysDeptService.getChildchildren(id);
            if (list.size() > 0) {
                return Res.makeErrRsp("请删除子菜单");
            }
            this.sysDeptService.delete(id);
            return Res.makeOKRsp("删除成功");
        } catch (AppException e) {
            return Res.makeErrRsp("删除失败");
        }
    }

    /**
     * 查询当前部门下子部门
     * @param id
     * @return
     */
    @GetMapping("/sysDept/query/select")
    public Result selectchildren(String id){
        List<String> list = this.sysDeptService.getChildchildren(id);
        return Res.makeOKRsp(list);
    }

    /**
     * 基础详情
     *
     * @param id 主键
     */
    @GetMapping("/sysDept/query/detail")
    public Result<SysDept> detail(String id) {
        SysDept entity = this.sysDeptService.getById(id);
        return Res.makeOKRsp(entity);
    }

    /**
     * 查询所有部门并转化为树形
     * @return
     */
    @GetMapping("/sysDept/findAllDept")
    public Result findalldept(String name){
        List<SysDept> list = this.sysDeptService.getAll(name);
        List<SysDeptTreeVo> TreeList = new ArrayList<>();
        SysDeptTreeVo.convertTreeNode(TreeList,list);
        return Res.makeOKRsp(TreeList);
    }


    /**
     * 树形选择
     *
     * @param
     * @return
     */
    @GetMapping("/sysDept/query/page")
    public Result<PageInfo<SysDept>> select(SysDept entity, Page page) {
        PageInfo<SysDept> pages = this.sysDeptService.queryPage(entity, page);
        return Res.makeOKRsp(pages);
    }


    /**
     * 保存
     * @param roleId
     * @param id
     * @return
     */
    @PostMapping("/sysDept/saveDeptRole")
    public Result saveDeptRole(String roleId, String[] id) {
        try {
            sysRoleDeptService.saveDeptRole(roleId, id);
        } catch (Exception e) {
            return Res.makeErrRsp("保存失败!");
        }
        return Res.makeOKRsp();
    }


}

