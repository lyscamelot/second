package system.service;



import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.model.DropdownVO;
import common.util.Page;
import system.entity.SysDept;

import java.util.List;

/**
 * SysDept接口
 *
 * @author MBG
 */
public interface SysDeptService {
    /**
     * 保存
     */
    String save(SysDept entity) throws AppException;

    /**
     * 删除
     */
    void delete(String id) throws AppException;

    /**
     * 基础详情
     */
    SysDept getById(String id);




    /**
     * 分页查询
     */
    PageInfo<SysDept> queryPage(SysDept entity, Page page);

    /**
     * 树形选择
     *
     * @param
     * @return
     */
    List<SysDept> getAll(String name);

    /**
     * 查询子菜单
     *
     * @return
     */
    List<String> getChildchildren(String id);

    /**
     * 查询企业下拉框
     *
     * @param type  类型（driver|sencond|first|factory）
     * @param isAll 如果为"1"，取系统中所有的对应列表；否则取出和当前用户相关联的列表。
     */
    List<DropdownVO> dropdown(String type, String isAll);
}
