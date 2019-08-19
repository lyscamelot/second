package textpoi.easypoi.controller;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import textpoi.easypoi.entity.Student;
import textpoi.easypoi.entity.User;
import textpoi.easypoi.util.DownUtil;
import textpoi.easypoi.util.ExcelUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


/**
 * @Author: Lixiaofei
 * @Date: 2018/11/28 19:37
 * @Version 1.0
 */
@Controller
public class TestController {


    @RequestMapping("getWord")
    public void getWord(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("okk", "IBM offer");
        dataMap.put("name", "Mr.Li");
        dataMap.put("number","963842069");
        dataMap.put("time","2018-12-11");
        File file = null;
        InputStream inputStream = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/msword");
        response.addHeader("Content-Disposition","attachment;filename=Offer.doc");
        /**
         * 缓冲区
         */
        byte[] buffer = new byte[521];
        int flag = -1;
        try {
            file = DownUtil.createDoc(dataMap, "resume");
            inputStream = new FileInputStream(file);
            while ((flag = inputStream.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, flag);
            }
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/testFreeMarker")
    public void testFreeMarker(){
        WordTest wt = new WordTest();
        wt.createWord();
    }


    @RequestMapping("hello")
    public String index(){
        return "easypoi/index";
    }


    @RequestMapping("/export")
    @ResponseBody
    public String export(HttpServletRequest request, HttpServletResponse response) {
        //模拟从数据库获取需要导出的数据
        List<User> list = new ArrayList<>();
        User user1 = new User("1","2","3","4","5");
        list.add(user1);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息表", "用户"), User.class, list);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
            byte[] content = bos.toByteArray();
            String fileName = "用户信息表";
            String userAgent = request.getHeader("User1-Agent");
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                fileName = java.net.URLEncoder.encode(fileName, "utf8");
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.reset();
            response.setContentType("application/msexcel;charset=utf-8");

            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.getOutputStream().write(content);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/getExcel")
    public void getExcel(HttpServletRequest request,HttpServletResponse response){
        List<Student> list = new ArrayList();
        Student entity1 = new Student("张三", 1, new Date(), new Date());
        Student entity2 = new Student("小花",2,new Date(),new Date());
        Student entity3 = new Student("李四",1,new Date(),new Date());
        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        //导出操作
        ExcelUtils.exportExcel(list, "计算机一班学生", "学生", Student.class, "xxx.xls", response);
    }
}
