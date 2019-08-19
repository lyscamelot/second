package system.controller;

import common.util.Res;
import common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;
import system.entity.Fix;
import system.mapper.Fix1Mapper;
import java.sql.Timestamp;
import java.util.Date;

@RestController
public class FixController {
    @Autowired
    Fix1Mapper fix1Mapper;
    @PostMapping("/baoxiu")
    @ResponseBody
    public Result changeInfo(@RequestBody Fix fix1) {
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        fix1.setTimenow(timeStamp);
        System.out.println(fix1.getSbmc()+" "+fix1.getContent());
        if(fix1Mapper.insert(fix1)>0){
        return Res.makeOKRsp("报修表单提交成功");}
        else{
            return Res.makeErrRsp("报表单提交失败");
        }
    }
    @PostMapping("delete")
    public Result delete(@RequestParam("imagePath") String imgurl) {

        return Res.makeOKRsp("删除成功");
    }
}