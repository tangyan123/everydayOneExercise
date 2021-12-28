package com.ty.demo.test.thread;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.enums.CellExtraTypeEnum;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        String     fileName =  "C:\\Users\\2020\\Desktop\\分析报告\\数据导入模板\\省厅数据\\全省区县环境空气质量对比表（月）.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        Map<Object,Object> map=new HashMap<>(2);
        Map<Integer,Map<Integer, String>> index2FieldMap =new LinkedHashMap<>();
        EasyExcel.read(fileName,new NoModelDataListener(index2FieldMap))
                .extraRead(CellExtraTypeEnum.MERGE)  // 需要读取合并单元格信息 默认不读取
                //.registerConverter(new EmptyConverter()) //默认：DefaultConverterLoader#loadDefaultReadConverter()
                .ignoreEmptyRow(true)
                .autoTrim(true)
                .headRowNumber(2)
                .autoCloseStream(true)
                //.sheet("")
                .sheet(1)
                .doRead();
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        index2FieldMap.forEach((k,v)-> System.out.println(k+"-----"+v));




    }

}
