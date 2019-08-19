package system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import system.entity.Fix;
import system.entity.Form1;

import java.util.List;
@Mapper
public interface FixMapper extends BaseMapper<Form1> {
    List selectAll(Page<Form1> page);

    List selectBysbmc(String input,Page<Form1> page);

    List selectByname(String input,Page<Form1> page);

    List selectBycontent(String input,Page<Form1> page);
    List selectByvalue(String input,Page<Form1> page);
}
