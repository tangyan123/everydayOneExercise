package com.ty.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExcelEntity  implements Serializable {
    @Excel(name = "序号",width = 14)
    private  String id;
    @Excel(name ="名称")
    private  String name;
    @Excel(name ="合计")
    private  String sum;
    @Excel(name = "备注",needMerge = true,mergeVertical = true)
    private  String  description;
    @Excel(name ="时间",importFormat =  "yyyy-MM-dd")
    private  String date;
}
