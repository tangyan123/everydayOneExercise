package com.ty.demo.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.context.AnalysisContextImpl;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ty.demo.entity.ExcelTest1;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.apache.poi.ss.formula.functions.T;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
public class ExcelListener extends AnalysisEventListener<ExcelTest1> {
    //可以通过实例获取该值
    private List<ExcelTest1>  datas ;

    @Override
    public void invoke(ExcelTest1 o, AnalysisContext analysisContext) {
        datas.add(o);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(o);//根据自己业务做处理
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    public ExcelListener(List<ExcelTest1> datas){
        this.datas=datas;
    }

    public ExcelListener(){
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        headMap.forEach((k,v)-> System.out.println(k+v));
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // datas.clear();//解析结束销毁不用的资源
    }
}
