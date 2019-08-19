package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.annotation.DataFilter;
import common.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.exception.AppException;
import common.exception.SystemException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.dao.SysUserMapper;
import system.entity.*;
import system.mapper.SysParamDao;
import system.mapper.SysUserDao;
import system.service.SysUserService;
import system.shiro.utils.PswdUtils;

import java.util.*;

/**
 * @author: Lixiaofei
 * @date: 2019/1/12 10:55
 */
@RequiredArgsConstructor
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysParamDao sysParamDao;


    /**
     * 保存/更新
     * @param entity
     * @return
     * @throws AppException
     */
    @Override
    @Transactional
    public String saveUser(SysUser entity) throws AppException {
        if(StringUtils.isNotEmpty(entity.getId())){
            //修改
            SysUser sysUser = this.getById(entity.getId());
            entity.setUpdateDate(new Date());
            entity.setPassword(sysUser.getPassword());
            if(sysUser == null){
                sysUserDao.insertSelective(entity);
            }
            sysUserDao.updateByPrimaryKey(entity);
            return entity.getId();
        }else {
            //保存
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateDate(new Date());
            SysParam sysParam = this.sysUserDao.getByCode("SYS_DEF_PWD");
            String defaultPwd = sysParam.getValue();
            String endPwd = PswdUtils.encrypt(entity.getId(),defaultPwd);
            if(StringUtils.isEmpty(entity.getPassword())){
                entity.setPassword(endPwd);
            }else{
                entity.setPassword(PswdUtils.encrypt(entity.getId(),entity.getPassword()));
            }
            sysUserDao.insertSelective(entity);
            return entity.getId();
        }
    }

    /**
     * 重置密码
     *
     * @param userid
     * @throws AppException
     */
    @Override
    @Transactional
    public void resetPassword(String userid) throws AppException {
        if (StringUtils.isNotEmpty(userid)) {
            SysParam defaultPwd = sysParamDao.getByCode("SYS_DEF_PWD");
            if (defaultPwd != null && StringUtils.isNotEmpty(defaultPwd.getValue())) {
                SysUser record = new SysUser();
                String enPwd = PswdUtils.encrypt(userid, defaultPwd.getValue());
                record.setId(userid);
                record.setPassword(enPwd);
                this.sysUserDao.updateByPrimaryKeySelective(record);
            } else {
                throw new AppException("系统尚未设置默认密码");
            }
        } else {
            throw new AppException("参数错误");
        }
    }

    @Override
    public void delete(String id) throws AppException {
        sysUserDao.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatch(String[] ids) throws AppException {
        sysUserDao.deleteBatch(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysRole> getRoleInfo(String userId) {
        return sysUserDao.getRoleInfo(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysMenu> getMenuinfo(List<String> roleIds) {
        return sysUserDao.getMenuinfo(roleIds);
    }

    @Override
    public List<SysDept> getdeptinfo(String userId) {
        return sysUserDao.getdeptinfo(userId);
    }


    @Override
    @Transactional(readOnly = true)
    public SysUser getById(String id) {
        return sysUserDao.selectByPrimaryKey(id);
    }


    @Override
    @DataFilter(subDept = true, user = false)
    @Transactional(readOnly = true)
    public PageInfo<SysUser> queryPage(HashMap hashMap, SysUser entity, Page page) {
        if (StringUtils.isNotEmpty(entity.getLoginName())) {
            hashMap.put("loginName", "%" + entity.getLoginName() + "%");
        }
        if (StringUtils.isNotEmpty(entity.getName())) {
            hashMap.put("name", "%" + entity.getName() + "%");
        }
        if (StringUtils.isNotEmpty(entity.getNo())) {
            hashMap.put("no", "%" + entity.getNo() + "%");
        }
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<SysUser> list = sysUserDao.selectByparam(hashMap);
        return new PageInfo<SysUser>(list);
    }

    @Override
    public SysUser getUserByLoginUserName(String userName) {
        if(StringUtils.isNotEmpty(userName)){
            SysUserExample sysUserExample = new SysUserExample();
            SysUserExample.Criteria criteria = sysUserExample.createCriteria();
            criteria.andLoginNameEqualTo(userName);
            List<SysUser> list = sysUserDao.selectByExample(sysUserExample);
            if(CollectionUtils.isNotEmpty(list)){
                return list.get(0);
            }
        }else{
            throw new SystemException("用户名不可为空");
        }
        return null;
    }

    /**
     * 修改当前密码
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @throws SystemException
     */
    @Override
    public int changePwd(String userId, String oldPwd, String newPwd) throws SystemException {
        if(StringUtils.isNotEmpty(userId)&&StringUtils.isNotEmpty(oldPwd)&&StringUtils.isNotEmpty(newPwd)){
            SysUser user =this.sysUserDao.selectByPrimaryKey(userId);
            if(user!=null&&PswdUtils.eqPwd(userId,oldPwd,user.getPassword())){
                //加密密码
                String newpwd = PswdUtils.encrypt(userId,newPwd);
                SysUser updateUser = new SysUser();
                updateUser.setId(user.getId());
                updateUser.setPassword(newpwd);
                return this.sysUserDao.updateByPrimaryKeySelective(updateUser);
            }else {
                throw new SystemException("初始密码不对");
            }
        }else{
            throw new SystemException("参数错误");
        }
    }

    /**
     * 获取所有人
     * @return
     */
    @Override
    public List<SysUser> getAll() {
        return this.sysUserDao.getAll();
    }

    /**
     * 返回该角色id下所有用户
     * @param roleId
     * @return
     */
    @Override
    public List<String> getUserIdByRoleId(String roleId) {
        return this.sysUserDao.getUserIdByRoleId(roleId);
    }

    /**
     * 保存该角色下所有用户
     * @param roleId
     * @param userId
     */
    @Override
    public void saveUserRole(String roleId, String[] userId) {
        List<SysUserRole> list = new ArrayList<>();
        for(String id : userId){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(id);
            list.add(sysUserRole);
        }
        this.sysUserDao.saveUserRole(list);
    }


}
