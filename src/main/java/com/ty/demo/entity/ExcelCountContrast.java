package com.ty.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExcelCountContrast extends BaseRowModel implements Serializable{
       
        private Integer id;
        
        private Integer reportId;

        @ExcelProperty(value = "区（市）",index=1)
        private String name;

        @ExcelProperty(index=2)
        private String so2Now;

        @ExcelProperty(index=3)
        private String so2Last;

        @ExcelProperty(index=4)
        private String so2Basis;

        @ExcelProperty(index=5)
        private String no2Now;

        @ExcelProperty(index=6)
        private String no2Last;
        
        @ExcelProperty(index=7)
        private String no2Basis;

        @ExcelProperty(index=8)
        private String pm10Now;

        @ExcelProperty(index=9)
        private String pm10Last;

        
        @ExcelProperty(index=10)
        private String pm10Basis;

        
        @ExcelProperty(index=11)
        private String pm25Now;

        
        @ExcelProperty(index=12)
        private String pm25Last;

        
        @ExcelProperty(index=13)
        private String pm25Basis;

        @ExcelProperty(index=14)
        private String o3Now;

        @ExcelProperty(index=15)
        private String o3Last;

        @ExcelProperty(index=16)
        private String o3Basis;

        @ExcelProperty(index=17)
        private String coNow;

        @ExcelProperty(index=18)
        private String coLast;

        @ExcelProperty(index=19)
        private String coBasis;

        @ExcelProperty(index=20)
        private String synthesizeNow;

        @ExcelProperty(index=21)
        private String synthesizeLast;

        @ExcelProperty(index=22)
        private String synthesizeBasis;


}
