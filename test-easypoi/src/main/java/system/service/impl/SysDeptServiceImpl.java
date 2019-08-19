package system.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.model.DropdownVO;
import common.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.entity.SysDept;
import system.entity.SysDeptExample;
import system.mapper.SysDeptDao;
import system.service.SysDeptService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * SysDept接口默认实现类
 *
 * @author MBG
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptDao sysDeptDao;

    /**
     * 保存
     *
     * @param entity 实体类
     */
    @Override
    @Transactional
    public String save(SysDept entity) throws AppException {
        SysDept sysDept = this.getById(entity.getId());
        if (StringUtils.isNotEmpty(entity.getId())) {
            //修改
            entity.setUpdateDate(new Date());
            if (sysDept == null) {
                this.sysDeptDao.insertSelective(entity);
            } else {
                this.sysDeptDao.updateByPrimaryKey(entity);
            }
        } else {
            //添加
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateDate(new Date());
            this.sysDeptDao.insertSelective(entity);
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
        this.sysDeptDao.deleteByPrimaryKey(id);
    }

    /**
     * 基础详情
     *
     * @param id 主键
     */
    @Override
    @Transactional(readOnly = true)
    public SysDept getById(String id) {
        return this.sysDeptDao.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     *
     * @param entity 查询参数
     * @param page   分页参数
     */
    @Override
    @Transactional(readOnly = true)
    public PageInfo<SysDept> queryPage(SysDept entity, Page page) {
        SysDeptExample example = new SysDeptExample();
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<SysDept> list = this.sysDeptDao.selectByExample(example);
        return new PageInfo<SysDept>(list);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysDept> getAll(String name) {
        SysDeptExample example = new SysDeptExample();
        example.setOrderByClause("sort");
        SysDeptExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        return this.sysDeptDao.selectByExample(example);
    }

    @Override
    public List<String> getChildchildren(String id) {
        return sysDeptDao.getChildchildren(id);
    }

    @Override
    @Transactional
    public List<DropdownVO> dropdown(String type, String isAll) {
        if("second".equals(type)){
            type = "2";
        } else if("first".equals(type)){
            type = "1";
        } else if("factory".equals(type)){
            type = "0";
        }
        List<DropdownVO> list = new ArrayList<>();
        if("1".equals(isAll)){
            SysDeptExample example = new SysDeptExample();
            SysDeptExample.Criteria criteria = example.createCriteria();
            criteria.andTypeEqualTo(type);
            List<SysDept> sysDepts = sysDeptDao.selectByExample(example);
            DropdownVO dropdownVO = new DropdownVO();
            for(SysDept sysDept:sysDepts){
                dropdownVO.setLabel(sysDept.getId());
                dropdownVO.setValue(sysDept.getName());
                list.add(dropdownVO);
            }
        }else if("0".equals(type)){
            //TODO 处理和他关联的部门
        }
        return list;
    }
}
