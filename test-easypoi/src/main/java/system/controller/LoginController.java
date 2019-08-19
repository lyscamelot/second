package system.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import common.exception.AppException;
import common.exception.SystemException;
import common.util.Res;
import common.util.Result;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import system.entity.SysMenu;
import system.entity.SysUser;
import system.mapper.AuthorizationMapper;
import system.mapper.SysUserDao;
import system.model.dto.UserForm;
import system.service.CaptchaService;
import system.service.SysUserService;
import system.shiro.bean.LoginUser;
import system.model.vo.SysUserMenuVo;
import system.model.vo.UserMenuVo;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Lixiaofei
 * @date: 2019/1/12 10:49
 */
@RestController
public class LoginController extends BaseController{

    /**
     * 用户服务
     */
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private AuthorizationMapper authorizationMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SysUserDao sysUserDao;
    /**
     * 验证码服务
     */
    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/captcha.jpg")
    public void getCaptcha(HttpServletResponse response,@RequestParam String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //获取图片验证码
        try{
            BufferedImage image = captchaService.getCaptcha(uuid);
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
            IOUtils.closeQuietly(out);
        }catch (AppException e){
            logger.error(e.getMessage());
        }
    }


    /**
     * 系统登陆
     * @param loginFrom
     * @param httpSession
     * @return
     */
    @PostMapping("/logins")
    public Result login(@RequestParam HashMap<String,String> loginFrom, HttpSession httpSession){
        //判断验证码是否正确
        String captcha = loginFrom.get("captcha");
        String uuid = loginFrom.get("uuid");
        boolean flag = captchaService.verification(uuid,captcha);
        if(!flag){
            return Res.makeErrRsp("验证码不正确");
        }
        String username = loginFrom.get("username");
        String password = loginFrom.get("password");
        SysUser loginUser = sysUserService.getUserByLoginUserName(username);
        if(loginUser==null){
            return Res.makeErrRsp("用户不存在");
        }
//        String red_token = (String) redisTemplate.opsForValue().get(Constant.DEFAULT_TOKEN_KEY + username);
//        if (red_token != null) {
//            Map<String, String> accessTocken = new HashMap<>();
//            accessTocken.put("token", red_token);
//            return Res.makeOKRsp(accessTocken).info("登录成功");
//        }
        //获取一个subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
            Map<String,String>accessToken = new HashMap<>();
            httpSession.setAttribute("user",subject.getPrincipal());
//            redisTemplate.opsForValue().set(Constant.DEFAULT_TOKEN_KEY + username, token, Constant.CODE_TIME, TimeUnit.MINUTES);
            accessToken.put("token", (String) subject.getSession().getId());
            return Res.makeOKRsp(accessToken).info("登陆成功");
        }catch (AuthenticationException e){
            logger.error("登陆失败");
            return Res.makeErrRsp("用户名或密码错误");
        }
    }

    /**
     * 注销登陆
     * @return
     */
    @GetMapping("/loginout")
    public Result loginOut(){
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.logout();
            return Res.makeOKRsp("注销成功");
        }catch (Exception e){
            return Res.makeErrRsp("注册失败");
        }
    }



    /**
     *个人信息展示
     * @return
     */
    @GetMapping("/myinfo")
    public Result getMyInfo(){
        Subject subject = SecurityUtils.getSubject();
        return Res.makeOKRsp(subject.getPrincipal()).info("查询成功");
    }


    /**
     * 当前用户菜单
     * @return
     */
    @GetMapping("/mymenu")
    public Result mymenu(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() instanceof LoginUser) {
            LoginUser loginUser = (LoginUser) subject.getPrincipal();
            List<SysMenu> sysMenuList = authorizationMapper.queryMenusByUserId(loginUser.getId());
            List<UserMenuVo> userMenuVos = new ArrayList<>();
            for(SysMenu sysMenu : sysMenuList){
                if("1".equals(sysMenu.getIsShow())){
                    UserMenuVo vo = new UserMenuVo();
                    BeanUtils.copyProperties(sysMenu,vo);
                    userMenuVos.add(vo);
                }
            }
            List<SysUserMenuVo> treeChildren = new ArrayList<>();
            SysUserMenuVo.convertTreeNode(treeChildren,userMenuVos);

            //获取所有权限
            List<String> param = sysMenuList.stream().map(SysMenu::getPermission).collect(Collectors.toList());
            Map<String,Object> myMenu = new HashMap<>();
            myMenu.put("menuList",treeChildren);
            myMenu.put("permissions",param);
            return Res.makeOKRsp(myMenu);
        }
        return Res.makeErrRsp("查询失败");
    }

    /**
     * 修改个人资料
     * @param userForm
     * @return
     */
    @PostMapping("/change/myInfo")
    public Result changeInfo(@RequestBody UserForm userForm){
        Subject subject = SecurityUtils.getSubject();
        try{
            if(subject.getPrincipal() instanceof LoginUser){
                LoginUser loginUser = (LoginUser) subject.getPrincipal();
                this.sysUserService.changePwd(loginUser.getId(),userForm.getPassword(),userForm.getNewpassword1());
                SysUser updateUser = new SysUser();
                updateUser.setId(loginUser.getId());
                updateUser.setPhone(userForm.getPhone());
                updateUser.setPhoto(userForm.getPhoto());
                this.sysUserService.update(updateUser,new LambdaUpdateWrapper<SysUser>().eq(SysUser::getId,updateUser.getId()));
//                this.sysUserDao.updateByPrimaryKeySelective(updateUser);
                //修改成功后退出登陆
                subject.logout();
                return Res.makeOKRsp("个人信息修改成功,请重新登录");
            }else {
                logger.error("个人信息修改失败");
            }
        }catch (SystemException e){
            logger.error(e.getMessage());
            return Res.makeErrRsp("个人信息修改失败");
        }
        return Res.makeErrRsp("个人信息修改失败");
    }



}
