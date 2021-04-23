package com.ty.demo.controller.freechart;

import cn.afterturn.easypoi.entity.ImageEntity;
import com.ty.demo.utils.JfreeUtil;
import com.ty.demo.utils.WordUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.analysis.function.Add;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class WordTestColntroller {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(4);

        //模拟饼状图数据
        HashMap<String, Integer> datas = new HashMap<>(3);

        ImageEntity image=new ImageEntity();
        image.setHeight(280);
        image.setWidth(315);
        image.setUrl("E:\\formatPic\\PM2.5_1.png");
        image.setType(ImageEntity.URL);
        map.put("PM2_1", image);
        ImageEntity image2=new ImageEntity();
        image2.setHeight(280);
        image2.setWidth(315);
        image2.setUrl("E:\\formatPic\\PM2.5_2.png");
        image2.setType(ImageEntity.URL);
        map.put("PM2_2", image2);

      /*  //模拟其它普通数据
        map.put("username", "张三");
        map.put("date", "2019-10-10");
        map.put("desc", "测试");
        map.put("boo", true);

        //模拟表格数据
        ArrayList<HashMap<String, String>> list = new ArrayList<>(2);
        HashMap<String, String> temp = new HashMap<>(3);
        temp.put("sn","1");
        temp.put("name","第一个人");
        temp.put("age","23");
        list.add(temp);
        temp = new HashMap<>(3);
        temp.put("sn","2");
        temp.put("name","第二个人");
        temp.put("age","24");
        list.add(temp);
        map.put("personlist",list);*/
        //word模板相对路径、word生成路径、word生成的文件名称、数据源
        WordUtil.exportWord("E:\\formatPic\\wordTest.docx", "E:\\formatPic\\", "test.docx", map);
    }

}
