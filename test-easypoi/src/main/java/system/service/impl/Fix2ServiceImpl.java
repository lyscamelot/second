package system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Form2;
import system.mapper.Fix2Mapper;
import system.service.Fix2Service;

import java.util.List;

@Service
public class Fix2ServiceImpl extends ServiceImpl<Fix2Mapper, Form2> implements Fix2Service {
    @Autowired
    Fix2Mapper fix2Mapper;
    public List<Form2>findAll(){
       return fix2Mapper.findAll();
    }
    public List<Form2> findBytype1(String type1){
        return fix2Mapper.findBytype1(type1);
    }

}
