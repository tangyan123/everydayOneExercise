package com.ty.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;


/**
 * @Description:  
 * @Author: tangyan
 * @Version: 1.0
 * @Date: 2021-05-14 16:18:47
 * @Modify
 */
@Data

public class DemoExtraData {


    @ExcelProperty(index=0)
    private String name;

    @ExcelProperty(index=1)
    private String sum;




}
