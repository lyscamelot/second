package system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysMenu;
import system.entity.SysMenuExample;
import system.mapper.SysMenuDao;
import system.service.SysMenuService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * SysMenu接口默认实现类
 *
 * @author MBG
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;


    /**
     * 保存
     *
     * @param entity 实体类
     */
    @Override
    @Transactional
    public String save(SysMenu entity) throws AppException {
        SysMenu sysMenu = this.getById(entity.getId());
        if (StringUtils.isNotEmpty(entity.getId())) {
            //修改
            entity.setUpdateDate(new Date());
            if (sysMenu == null) {
                this.sysMenuDao.insertSelective(entity);
            }
            this.sysMenuDao.updateByPrimaryKey(entity);
        } else {
            //添加
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateDate(new Date());
            this.sysMenuDao.insertSelective(entity);
        }
        return entity.getId();
    }

    /**
     * 删除
     *
     * @param id 主键
     */
    @Override
    @Transactional
    public void delete(String id) throws AppException {
        this.sysMenuDao.deleteByPrimaryKey(id);
    }

    /**
     * 基础详情
     *
     * @param id 主键
     */
    @Override
    @Transactional(readOnly = true)
    public SysMenu getById(String id) {
        return this.sysMenuDao.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     *
     * @param entity 查询参数
     * @param page   分页参数
     */
    @Override
    @Transactional(readOnly = true)
    public PageInfo<SysMenu> queryPage(SysMenu entity, Page page) {
        SysMenuExample example = new SysMenuExample();
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<SysMenu> list = this.sysMenuDao.selectByExample(example);
        return new PageInfo<SysMenu>(list);
    }

    @Override
    public List<SysMenu> getAllMenu(String name) {
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        example.setOrderByClause("sort");
        return sysMenuDao.selectByExample(example);
    }
}
