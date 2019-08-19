package system.mapper;


import system.dao.SysDeptMapper;

import java.util.List;

public interface SysDeptDao extends SysDeptMapper {

    List<String> getChildchildren(String id);

}
