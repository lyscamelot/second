package system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import system.entity.Form1;

import java.util.List;

@Service
public interface FixService extends IService<Form1> {
    Page<Form1> selectAll(Page<Form1> page);
    Page<Form1> selectBycontent(String value,Page<Form1> objectPage);
    Page<Form1> selectBysbmc(String value,Page<Form1> objectPage);
    Page<Form1> selectByvalue(String value,Page<Form1> objectPage);
    Page<Form1> selectByname(String value,Page<Form1> objectPage);

}
