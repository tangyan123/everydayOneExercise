package com.ty.demo.thread;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.ty.demo.entity.DustYyyx;
import com.ty.demo.entity.DustfallMonitoring;
import org.springframework.test.annotation.IfProfileValue;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        //读取的表格名
        String fileName = "C:\\Users\\2020\\Desktop\\分析报告\\数据导入模板\\降尘监测\\宇星科技-降尘.xlsx";
        String fileName2 = "C:\\Users\\2020\\Desktop\\分析报告\\数据导入模板\\降尘监测\\降尘监测数据月报表.xlsx";
        String fileName3 =  "C:\\Users\\2020\\Desktop\\test.xlsx";
        Map<Integer,Map<Integer, String>> index2FieldMap =new LinkedHashMap<>();
        EasyExcel.read(fileName,new NoModelDataListener(index2FieldMap))
                .extraRead(CellExtraTypeEnum.MERGE)  // 需要读取合并单元格信息 默认不读取
                //.registerConverter(new EmptyConverter()) //默认：DefaultConverterLoader#loadDefaultReadConverter()
                .ignoreEmptyRow(true)
                .autoTrim(true)
                .headRowNumber(1)
                .autoCloseStream(true)
                //.sheet("2、功能点拆分表")
                //.sheet("4、结果计算")
                .sheet()
                .doRead();
        //index2FieldMap.forEach((k,v)-> System.out.println(k+"-----"+v));
        List<DustYyyx>list=new ArrayList<>();
        for (int i=2;i<=index2FieldMap.size();i++) {
            //取行的数据
            Map<Integer, String> rowMap = index2FieldMap.get(i);
            DustYyyx dustYyyx = new DustYyyx();
            dustYyyx.setReportId(1);
            for (int j = 0; j <= rowMap.size(); j++) {
                //列数据
                switch (j) {

                    case 0:
                        dustYyyx.setSpecimenDate(rowMap.get(j));
                        break;
                    case 1:
                        dustYyyx.setCountCityName(rowMap.get(j));
                        break;
                    case 2:
                        dustYyyx.setTownName(rowMap.get(j));
                        break;
                    case 3:
                        dustYyyx.setDetectionProject(rowMap.get(j));
                        break;
                    case 4:
                        dustYyyx.setDetectionDate(rowMap.get(j));
                        break;
                    case 5:
                        dustYyyx.setDustData(rowMap.get(j));
                        break;

                    default:
                        break;
                }
            }
            list.add(dustYyyx);
        }
        list.forEach(l -> System.out.println(l));
    }
}
