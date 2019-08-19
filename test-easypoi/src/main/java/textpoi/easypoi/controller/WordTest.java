package textpoi.easypoi.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * @Author: Lixiaofei
 * @Date: 2018/12/10 10:42
 * @Version 1.0
 */

public class WordTest {

    private Configuration configuration = null;

    public WordTest(){
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public static void main(String[] args) {
        WordTest test = new WordTest();
        test.createWord();
    }

    public void createWord(){
        Map<String,Object> dataMap=new HashMap<String,Object>();
        getData(dataMap);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/word");  //FTL文件所存在的位置
        Template t=null;
        try {
            t = configuration.getTemplate("test.ftl"); //文件名
        } catch (IOException e) {
            e.printStackTrace();
        }
        File outFile = new File("D:/"+Math.random()*10000+".doc");  //导出文档的存放位置
        Writer out = null;
        try {
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
                out = new OutputStreamWriter(new FileOutputStream(outFile),"utf-8");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            t.process(dataMap, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getData(Map<String, Object> dataMap) {
        dataMap.put("okk", "学生信息");
        dataMap.put("name", "despacito");
        dataMap.put("number","123");
        dataMap.put("time","2018-12-10");
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("number", i);
            map.put("content", "内容"+i);
            list.add(map);
        }
        dataMap.put("list", list);
    }
}
