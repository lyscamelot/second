package system.service;

import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.util.Page;
import system.entity.SysRole;

import java.util.List;

/**
 * SysRole接口
 *
 * @author MBG
 */
public interface SysRoleService {
    /**
     * 保存
     */
    String save(SysRole entity) throws AppException;

    /**
     * 删除
     */
    void delete(String id) throws AppException;

    /**
     * 基础详情
     */
    SysRole getById(String id);

    /**
     * 分页查询
     */
    PageInfo<SysRole> queryPage(SysRole entity, Page page);




}
