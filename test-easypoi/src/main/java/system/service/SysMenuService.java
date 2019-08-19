package system.service;


import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.util.Page;
import system.entity.SysMenu;

import java.util.List;

/**
 * SysMenu接口
 *
 * @author MBG
 */
public interface SysMenuService {
    /**
     * 保存
     */
    String save(SysMenu entity) throws AppException;

    /**
     * 删除
     */
    void delete(String id) throws AppException;

    /**
     * 基础详情
     */
    SysMenu getById(String id);

    /**
     * 分页查询
     */
    PageInfo<SysMenu> queryPage(SysMenu entity, Page page);

    /**
     * 所有菜单
     */
    List<SysMenu> getAllMenu(String name);

}
