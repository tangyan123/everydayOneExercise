package com.ty.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class ExcelTest1  extends BaseRowModel implements Serializable{
        @ExcelProperty(index=0)
        private  String city;

        @ExcelProperty(index=1)
        private  String  fineDay;

        @ExcelProperty(index=2)
        private  String  fineRate;

        @ExcelProperty(index=3)
        private  String  fineCompareAddRate;

        @ExcelProperty(index=4)
        private  String  heavyPollutionDay;

        @ExcelProperty(index=5)
        private  String  heavyPollutionCompareAddDay;

}
