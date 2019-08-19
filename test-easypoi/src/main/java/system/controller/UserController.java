package system.controller;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import common.util.Res;
import common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.entity.User1;
import system.service.UserService;
import textpoi.easypoi.entity.User;

import java.sql.Timestamp;
import java.util.Date;
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/regist2")
    @ResponseBody
    public Result changeInfo(@RequestBody User1 user) {
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        user.setRetime(timeStamp);
        user.setRole(0);

        System.out.println(user);
        int s = userService.regist(user);
//        userService.save(user);

        if(s==0){
            return Res.makeErrRsp("用户名重复请重新输入");
        }
        else if(s==1){
            return Res.makeErrRsp("注册失败");
        }
        return Res.makeOKRsp("" +
                "注册成功");
    }
    @GetMapping("/login")
    @ResponseBody
    public Result changeInfo(@RequestParam(value="username") String username,@RequestParam(value="password") String password) {
        User1 one = userService.getOne(Wrappers.<User1>lambdaQuery()
                .eq(User1::getUsername,username)
                .eq(User1::getPassword,password));
        System.out.println(one);
        if(one!=null){
        return Res.makeOKRsp(one); }
        else{return Res.makeErrRsp("登录失败");}
      }
    @GetMapping("/chazhao")
    @ResponseBody
    public Result changeInfo(@RequestParam(value="username") String username) {
       User1 user1 = userService.selectByname(username);
       System.out.println(user1);
       if(user1!=null){
       return Res.makeOKRsp(user1);}
       else{return Res.makeErrRsp("没有此用户");}
    }
    @GetMapping("/loginplus")
    @ResponseBody
    public Result change(@RequestParam(value="username") String username,@RequestParam(value="password") String password) {
        User1 one = userService.getOne(Wrappers.<User1>lambdaQuery()
                .eq(User1::getUsername, username)
                .eq(User1::getPassword, password));
        System.out.println(one);
        if (one != null && one.getRole() == 1) {
            return Res.makeOKRsp(one);
        } else if(one != null && one.getRole() == 1){
            return Res.makeErrRsp("您不具备权限");
        }
        else{return Res.makeErrRsp("用户名或密码错误");}
}
}
