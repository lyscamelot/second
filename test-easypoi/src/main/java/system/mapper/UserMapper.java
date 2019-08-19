package system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import system.entity.User1;

public interface UserMapper extends BaseMapper<User1>{
     User1 selectByup(String username, String password);
     User1 selectByname(String username);
}
