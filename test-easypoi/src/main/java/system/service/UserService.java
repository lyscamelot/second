package system.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import system.entity.User1;

@Service
public interface UserService extends IService<User1> {
    public Integer regist(User1 user);
    public User1 Login(String username, String password);
    public User1 selectByname(String username);
}
