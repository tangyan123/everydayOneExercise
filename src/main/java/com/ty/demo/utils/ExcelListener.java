package com.ty.demo.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ty.demo.entity.DemoExtraData;
import com.ty.demo.entity.ExcelCountContrast;
import com.ty.demo.entity.ExcelTest1;
import com.ty.demo.entity.ExcelTest2;
import lombok.Data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ExcelListener extends AnalysisEventListener {
    //可以通过实例获取该值
    private  List<ExcelTest2> cityList=new ArrayList<>();
    private  List<ExcelCountContrast> countList=new ArrayList<>();
    private  Map<Object,Object> map=new HashMap<>(2);
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        if (o instanceof ExcelTest2){
            cityList.add((ExcelTest2)o);
            map.put("cityList", cityList);
        }
        else if (o instanceof ExcelCountContrast){
            countList.add((ExcelCountContrast)o);
            map.put("countList", countList);
        }

    }

    public ExcelListener(){

    }

    public ExcelListener(Map<Object,Object> map){
        this.map=map;
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //	list.clear();//解析结束销毁不用的资源
    }
}
