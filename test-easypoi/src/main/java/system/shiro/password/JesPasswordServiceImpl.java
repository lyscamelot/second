package system.shiro.password;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.SysParam;
import system.mapper.SysUserDao;
import system.shiro.bean.LoginUser;
import system.shiro.utils.PswdUtils;

/**
 * 密码处理（加密，解密）
 * Created by lizhi on 2018/9/12.
 *
 * @author lizhi
 */
@Service
public class JesPasswordServiceImpl implements PasswordService, CredentialsMatcher {

    @Autowired
    SysUserDao sysUserDao;
    /**
     * 登录密码比对校验
     *
     * @param authenticationToken 携带用户输入的待验证的tocken
     * @param authenticationInfo  系统中存在的用户信息
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        if (authenticationToken instanceof UsernamePasswordToken
                && authenticationInfo instanceof SimpleAuthenticationInfo) {
            UsernamePasswordToken tocken = (UsernamePasswordToken) authenticationToken;
            SimpleAuthenticationInfo simpleAuthenticationInfo = (SimpleAuthenticationInfo) authenticationInfo;
            if (simpleAuthenticationInfo.getPrincipals().getPrimaryPrincipal() instanceof LoginUser) {
                //sysUser 代表系统用户数据
                LoginUser sysUser = (LoginUser) simpleAuthenticationInfo.getPrincipals().getPrimaryPrincipal();
                //loginUser 代表用户输入
                LoginUser loginUser = new LoginUser();
                loginUser.setId(sysUser.getId());
                loginUser.setPassword(new String(tocken.getPassword()));
                //用户输入的密码需要经过加密
                String userPwd = this.encryptPassword(loginUser);
                String sysPwd = simpleAuthenticationInfo.getCredentials().toString();
                if (StringUtils.isNotEmpty(userPwd) && StringUtils.isNotEmpty(sysPwd)) {
                    return this.passwordsMatch(userPwd, sysPwd);
                }
            }
        }
        return false;
    }

    /**
     * 密码加密
     * 算法：用户密码和盐值前后拼接后，计算MD5值，然后转为16进制字符串存储
     *
     * @param user LoginUser用户ID和密码不可为空，用户ID用来生成盐值
     * @return 十六进制字符串的密码
     * @throws IllegalArgumentException 异常
     */
    @Override
    public String encryptPassword(Object user) throws IllegalArgumentException {
        if (user instanceof LoginUser) {
            return PswdUtils.encrypt(((LoginUser) user).getId(),((LoginUser) user).getPassword());
//            SysParam sysParam = this.sysUserDao.getByCode("SYS_DEF_PWD");
//            String defaultPwd = sysParam.getValue();
//            return PswdUtils.encrypt(((LoginUser) user).getId(),defaultPwd);
        }
        return null;
    }

    /**
     * 密码匹配
     *
     * @param userPwd 用户提供的密码
     * @param sysPwd  系统存在的密码
     * @return 匹配成功否
     */
    @Override
    public boolean passwordsMatch(Object userPwd, String sysPwd) {
        if (userPwd != null && StringUtils.isNotEmpty(sysPwd) && StringUtils.isNotEmpty(userPwd.toString())) {
            return sysPwd.equals(userPwd.toString());
        }
        return false;
    }
}
