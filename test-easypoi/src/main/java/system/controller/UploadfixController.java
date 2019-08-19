package system.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.util.Res;
import common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.entity.Fix;
import system.entity.Form1;
import system.entity.Form2;
import system.entity.User1;
import system.mapper.Fix1Mapper;
import system.mapper.FixMapper;
import system.service.Fix2Service;
import system.service.FixService;

import java.util.List;
import java.util.Map;

@RestController
public class UploadfixController {
    @Autowired
    FixMapper fixMapper;
    @Autowired
    FixService fixService;
    @Autowired
    Fix2Service fix2Service;
    @Autowired
    Fix1Mapper fix1Mapper;
    @GetMapping  (value="/findNo")
    @ResponseBody
    public Result findNo (@RequestParam(value="username")String username) {
        List<Fix>list = fix1Mapper.selectNo(username);
        System.out.println(list);
        return Res.makeOKRsp(list);
    }
    @GetMapping  (value="/findYes")
    @ResponseBody
    public Result findYes (@RequestParam(value="username")String username) {
        List<Fix>list = fix1Mapper.selectYes(username);
        System.out.println(list);
        return Res.makeOKRsp(list);
    }
//    @RequestMapping(value="/updatetype")
//    @ResponseBody
//    public Result No (@RequestParam(value="fixid")Integer fixid) {
//        if(fix1Mapper.updateByfixid(fixid)==1){
//        System.out.println(fixid+"修改成功");
//        return Res.makeErrRsp("修改成功");}
//        else{
//            return Res.makeErrRsp("修改失败，请刷新后重试");
//        }
//    }
@PostMapping(value="/content1")
@ResponseBody
public Result find ( ) {
        System.out.println("评价成功");
        return Res.makeErrRsp("修改成功"); }
    @PostMapping(value="/content")
    @ResponseBody
    public Result findYes (@RequestBody Fix fix ) {
        System.out.println(fix.getContent2());
        if(fix1Mapper.updateByfixid(fix.getFixid(),fix.getPingfen(),fix.getContent2())==1){
            System.out.println("评价成功");

            return Res.makeErrRsp("修改成功");}
        else{
            return Res.makeErrRsp("修改失败，请刷新后重试");
        }
    }
    @GetMapping("/sousuo")
    @ResponseBody
    public Result sousuo(@RequestParam(value="input") String input,@RequestParam(value="page") Integer page,@RequestParam(value="size") Integer size) {
        if(input==null){
            Page<Form1> findpage = fixService.selectAll(new Page<>(page,size));
        if(findpage!=null){
            System.out.println(findpage);
            return Res.makeOKRsp(findpage);
        }
        else{
            return Res.makeErrRsp("错误");
        }
        }
    else {
            if (!fixMapper.selectByname(input,new Page<>(page,size)).isEmpty()) {
                Page<Form1> findpage1 = fixService.selectByname(input,new Page<>(page,size));
                System.out.println(fixMapper.selectByname(input,new Page<>(page,size)));
                return Res.makeOKRsp(findpage1);

            } else if (!fixMapper.selectBycontent(input,new Page<>(page,size)).isEmpty()) {
                Page<Form1> findpage2 = fixService.selectBycontent(input,new Page<>(page,size));
                System.out.println(fixMapper.selectBycontent(input,new Page<>(page,size)));
                return Res.makeOKRsp(findpage2);
            } else if (!fixMapper.selectBysbmc(input,new Page<>(page,size)).isEmpty()) {
                Page<Form1> findpage3 = fixService.selectBysbmc(input,new Page<>(page,size));
                System.out.println(fixMapper.selectBysbmc(input,new Page<>(page,size)));
                return Res.makeOKRsp(findpage3);
            } else if (!fixMapper.selectByvalue(input,new Page<>(page,size)).isEmpty()) {
                Page<Form1> findpage4 = fixService.selectByvalue(input,new Page<>(page,size));
                System.out.println(fixMapper.selectByvalue(input,new Page<>(page,size)));
                return Res.makeOKRsp(findpage4);
        }
        else{return Res.makeErrRsp("没有查到结果");}}
    }
    @RequestMapping(value="/findAll")
    @ResponseBody
    public Result findAll2 (@RequestParam (value="type1")String type1) {
        if(type1==null||type1==""){
        List<Form2> list = fix2Service.findAll();
        if(list!=null){
            System.out.println(list);
            return Res.makeOKRsp(list);
        }
        else{
            return Res.makeErrRsp("暂时没有您要查询的信息");
        }}
        else if(type1!=null&&type1!=""){
            List<Form2> list = fix2Service.findBytype1(type1);
            return Res.makeOKRsp(list);
        }
        else{return Res.makeErrRsp("查找失败");}
    }

}
