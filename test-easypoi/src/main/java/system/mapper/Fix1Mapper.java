package system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import system.entity.Fix;

import java.util.List;

@Mapper
public interface Fix1Mapper extends BaseMapper<Fix> {
List<Fix> selectNo(String username);
Integer updateByfixid(Integer fixid,Integer pingfen,String content2);
List<Fix> selectYes(String username);
}
