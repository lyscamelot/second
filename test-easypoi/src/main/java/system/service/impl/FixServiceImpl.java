package system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Form1;
import system.mapper.FixMapper;
import system.service.FixService;

@Service
public class FixServiceImpl extends ServiceImpl<FixMapper, Form1> implements FixService {
    @Autowired
    FixMapper fixMapper;
    @Override
    public Page<Form1> selectAll(Page<Form1> page) {
        return page.setRecords(fixMapper.selectAll(page));
    }

    @Override
    public Page<Form1> selectBycontent(String value, Page<Form1> page) {
        return page.setRecords(fixMapper.selectBycontent(value,page));
    }

    @Override
    public Page<Form1> selectBysbmc(String value, Page<Form1> page) {
        return page.setRecords(fixMapper.selectBysbmc(value,page));
    }

    @Override
    public Page<Form1> selectByvalue(String value, Page<Form1> page) {
        return page.setRecords(fixMapper.selectByvalue(value,page));
    }

    @Override
    public Page<Form1> selectByname(String value, Page<Form1> page) {
        return page.setRecords(fixMapper.selectByname(value,page));
    }
}
