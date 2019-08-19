package system.mapper;


import org.apache.ibatis.annotations.Param;
import system.dao.SysMenuMapper;
import system.entity.SysMenu;

import java.util.List;

public interface SysMenuDao extends SysMenuMapper {
    List<SysMenu> getAllMenu(@Param("name") String name);

}
