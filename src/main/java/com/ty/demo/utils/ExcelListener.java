package com.ty.demo.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ty.demo.entity.ExcelTest1;
import com.ty.demo.entity.ExcelTest2;
import lombok.Data;


import java.util.List;
import java.util.Map;

@Data
public class ExcelListener extends AnalysisEventListener {
    //可以通过实例获取该值
    private List<Object>  datas ;

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        if (o instanceof ExcelTest1){
            System.out.println(o);
        }else if (o instanceof ExcelTest2){
            System.out.println(o);
        }
       //数据存储到list，供批量处理，或后续自己业务逻辑处理。
         doSomething(o);//根据自己业务做处理
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    public ExcelListener(List<Object> datas){
        this.datas=datas;
    }

    public ExcelListener(){

    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // datas.clear();//解析结束销毁不用的资源
    }
}
