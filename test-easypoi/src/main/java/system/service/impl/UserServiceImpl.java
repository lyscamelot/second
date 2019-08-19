package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.User1;
import system.mapper.UserMapper;
import system.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User1> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Integer regist(User1 user) {
        if(userMapper.selectByname(user.getUsername())!=null){
           return 0;
        }
        else if( userMapper.insert(user)<0) {
            return 1;
        }
        else{
            return 2;
        }
    }

    @Override
    public User1 Login(String username, String password) {
        return userMapper.selectByup(username,password);
    }

    @Override
    public User1 selectByname(String username) {
        return userMapper.selectByname(username);
    }
}

