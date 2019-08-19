package system.shiro.realm;

import com.alibaba.fastjson.JSON;
import common.exception.SystemException;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import system.entity.SysMenu;
import system.entity.SysRole;
import system.entity.SysUser;
import system.mapper.AuthorizationMapper;
import system.service.SysUserService;
import system.shiro.bean.LoginUser;
import org.slf4j.Logger;

import java.util.List;

/**
 * @author: Lixiaofei
 * @date: 2019/1/13 14:07
 */
public class UsernameRealm extends AuthorizingRealm{

    private final Logger logger = LoggerFactory.getLogger(UsernameRealm.class);

    @Autowired
    SysUserService sysUserService;

    @Autowired
    private CredentialsMatcher jesPasswordService;

    @Autowired
    private AuthorizationMapper authorizationMapper;

    public UsernameRealm(){
        //设置默认密码算法
        this.setCredentialsMatcher(this.jesPasswordService);
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        return this.jesPasswordService;
    }


    @Override //注入父类的属性，注入加密算法匹配密码时使用
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher){
        super.setCredentialsMatcher(credentialsMatcher);
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if(principalCollection.getPrimaryPrincipal() instanceof SysUser){
            SysUser user= (SysUser) principalCollection.getPrimaryPrincipal();
            if(user!=null&& StringUtils.isNotEmpty(user.getId())){
                SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
                List<SysRole> roleList = authorizationMapper.queryRolesByUserId(user.getId());
                for(SysRole sysRole:roleList){
                    simpleAuthorizationInfo.addRole(sysRole.getEnname());
                }
                List<SysMenu> menuList = authorizationMapper.queryMenusByUserId(user.getId());
                for(SysMenu sysMenu :menuList){
                    simpleAuthorizationInfo.addStringPermission(sysMenu.getPermission());
                }
                return simpleAuthorizationInfo;
            }
        }
        return null;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        try{
            SysUser user = sysUserService.getUserByLoginUserName(token.getUsername());
            LoginUser loginUser = JSON.parseObject(JSON.toJSONString(user),LoginUser.class);
            if(user!=null){
                String password = user.getPassword();
                loginUser.setPassword(null);
                return new SimpleAuthenticationInfo(loginUser,password,getName());
            }else{
                throw new AuthenticationException("用户不存在");
            }
        }catch (SystemException | AuthenticationException e){
            logger.error("认证出错",e);
            throw new AuthenticationException("认证出错");
        }
    }

    /**
     * 得到realm名字
     * @return
     */
    @Override
    public String getName(){
        return "UsernameRealm";
    }

}
