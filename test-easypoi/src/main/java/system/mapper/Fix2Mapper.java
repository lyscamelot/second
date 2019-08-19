package system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import system.entity.Form1;
import system.entity.Form2;

import java.util.List;

@Mapper
public interface Fix2Mapper extends BaseMapper<Form2> {
    List findAll();

    List<Form2> findBytype1(String type1);
}
