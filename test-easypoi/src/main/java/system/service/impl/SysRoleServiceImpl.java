package system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysRole;
import system.entity.SysRoleExample;
import system.mapper.SysRoleDao;
import system.service.SysRoleService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * SysRole接口默认实现类
 *
 * @author MBG
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleDao sysRoleDao;

    /**
     * 保存
     *
     * @param entity 实体类
     */

    @Override
    @Transactional
    public String save(SysRole entity) throws AppException {
        SysRole sysRole = this.getById(entity.getId());
        if (StringUtils.isNotEmpty(entity.getId())) {
            //修改
            entity.setUpdateDate(new Date());
            if (sysRole == null) {
                this.sysRoleDao.insertSelective(entity);
            }
            this.sysRoleDao.updateByPrimaryKey(entity);
        } else {
            //添加
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateDate(new Date());
            this.sysRoleDao.insertSelective(entity);
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
        this.sysRoleDao.deleteByPrimaryKey(id);
    }

    /**
     * 基础详情
     *
     * @param id 主键
     */
    @Override
    @Transactional(readOnly = true)
    public SysRole getById(String id) {
        return this.sysRoleDao.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     *
     * @param entity 查询参数
     * @param page   分页参数
     */
    @Override
    @Transactional(readOnly = true)
    public PageInfo<SysRole> queryPage(SysRole entity, Page page) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(entity.getName())) {
            criteria.andNameLike("%"+entity.getName()+"%");
        }
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<SysRole> list = this.sysRoleDao.selectByExample(example);
        return new PageInfo<SysRole>(list);
    }

}
