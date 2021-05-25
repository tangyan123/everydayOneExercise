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


        @ExcelProperty(value = "区（市）",index=2)
        private String name;

        @ExcelProperty(index=3)
        private String fineDays;

        @ExcelProperty(index=4)
        private String goodRate;

        @ExcelProperty(index=5)
        private String fineBasis;

        @ExcelProperty(index=6)
        private String pollutionDays;

        @ExcelProperty(index=7)
        private String pollutionBasis;
        private Integer id;

        private Integer reportId;

        private String chieflyPollutant;

        private String pm10Days;

}
