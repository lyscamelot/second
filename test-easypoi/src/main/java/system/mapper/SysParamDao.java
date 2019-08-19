package system.mapper;

import system.dao.SysParamMapper;
import system.entity.SysParam;

public interface SysParamDao extends SysParamMapper {

    public SysParam getByCode(String code);

    void deleteBatch(String[] ids);
}
