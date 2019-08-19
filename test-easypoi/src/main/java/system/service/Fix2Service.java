package system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import system.entity.Form2;

import java.util.List;

public interface Fix2Service extends IService<Form2> {
 List<Form2> findAll();

    List<Form2> findBytype1(String type1);
}
