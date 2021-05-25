package com.ty.demo.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ty.demo.entity.ExcelTest1;
import com.ty.demo.entity.ExcelTest2;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ExcelListener2 extends AnalysisEventListener {
    //可以通过实例获取该值
    private  List<Object> list=new ArrayList<>();
    private  Map<Object,Object>map=new HashMap<>(2);
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        if (o instanceof ExcelTest1){
            System.out.println(o);
            list.add(o);
            map.put("ExcelTest1",list);
        }else if (o instanceof ExcelTest2){
            if (list.size()==7){
                map.put("ExcelTest2",list);
            }
            list.add(o);
        }

    }




    public ExcelListener2(){

    }


    public ExcelListener2(Map<Object,Object>map) {
        this.map = map;
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // datas.clear();//解析结束销毁不用的资源
    }
}
