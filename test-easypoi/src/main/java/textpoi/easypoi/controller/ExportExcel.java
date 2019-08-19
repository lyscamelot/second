package textpoi.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import common.util.Result;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import system.entity.SysUser;
import system.mapper.SysUserDao;
import textpoi.easypoi.entity.UserExcel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Lixiaofei
 * @date: 2019/3/27 10:01
 */
@RestController
public class ExportExcel {

    @Autowired
    SysUserDao sysUserDao;

    @RequiresPermissions("sys:export")
    @GetMapping("sysUser/export")
    public void export(HttpServletRequest request, HttpServletResponse response){
        OutputStream outStream = null;
        try{
            response.reset();
            String excelName = "account";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName = excelName + "-" + sdf.format(new Date());
            // 指定下载的文件名--设置响应头
            String agent = request.getHeader("USER-AGENT");
            try {
                if (agent.contains("MSIE") || agent.contains("Trident")) {
                    fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
                } else {
                    fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.setHeader("content-disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName + ".xls", "UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("pragma", "no-cache");
            response.setHeader("cache-control", "no-cache");
            response.setDateHeader("expires", 0);
            response.setCharacterEncoding("UTF-8");
            outStream = response.getOutputStream();
        }catch (IOException e){
            e.printStackTrace();
        }
        List<SysUser> list = sysUserDao.getAll();
        List<UserExcel> userExcels = new ArrayList<>();
        for(SysUser user:list){
            UserExcel userExcel = new UserExcel();
            BeanUtils.copyProperties(user,userExcel);
            userExcels.add(userExcel);
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息", "用户"),
                UserExcel.class, userExcels);

        try {
            workbook.write(outStream);
            workbook.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
