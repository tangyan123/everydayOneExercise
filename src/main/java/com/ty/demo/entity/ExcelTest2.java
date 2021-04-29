package com.ty.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExcelTest2 extends BaseRowModel implements Serializable{

        @ExcelProperty(index = 0)
        private  String no;
        private  String name;
        @ExcelProperty(value = {"SO2均值(μg/m3)_本期"},index = 2)
        private  String so2_1;

        @ExcelProperty(value = {"SO2均值(μg/m3)_去年同期"},index=3)
        private  String  so2_2;

        @ExcelProperty( value= {"SO2均值(μg/m3)_同比（%）"},index=4)
        private  String  so2_3;

        @ExcelProperty(value= {"NO2均值(μg/m3)_本期"},index=5)
        private  String  no2_1;

        @ExcelProperty(value= {"NO2均值(μg/m3)_去年同期"},index=6)
        private  String  no2_2;

        @ExcelProperty(value= {"NO2均值(μg/m3)_同比（%）"},index=7)
        private  String  no2_3;

        @ExcelProperty(value= {"PM10均值(μg/m3)_本期"},index=8)
        private  String  pm10_1;

        @ExcelProperty(value= {"PM10均值(μg/m3)_去年同期"},index=9)
        private  String  pm10_2;

        @ExcelProperty(value= {"PM10均值(μg/m3)_同比（%）"},index=10)
        private  String  pm10_3;

        @ExcelProperty(value= {"PM2.5均值(μg/m3)_本期"},index=11)
        private  String  pm25_1;

        @ExcelProperty(value= {"PM2.5均值(μg/m3)_去年同期"},index=12)
        private  String  pm25_2;

        @ExcelProperty(value= {"PM2.5均值(μg/m3)_同比（%）"},index=13)
        private  String  pm25_3;

        @ExcelProperty(value= {"O3-95per(mg/m3)_本期"},index=14)
        private  String  o3_1;

        @ExcelProperty(value= {"O3-95per(mg/m3)_去年同期"},index=15)
        private  String  o3_2;

        @ExcelProperty(value= {"O3-95per(mg/m3)_同比（%）"},index=16)
        private  String  o3_3;

        @ExcelProperty(value= {"CO-95per(mg/m3)_本期"},index=17)
        private  String  co_1;

        @ExcelProperty(value= {"CO-95per(mg/m3)_去年同期"},index=18)
        private  String  co_2;

        @ExcelProperty(value= {"CO-95per(mg/m3)_同比（%）"},index=19)
        private  String  co_3;

        @ExcelProperty(value= {"综合指数_本期"},index=20)
        private  String  zhzs_1;

        @ExcelProperty(value= {"综合指数_去年同期"},index=21)
        private  String  zhzs_2;

        @ExcelProperty(value= {"综合指数_同比（%）"},index=22)
        private  String  zhzs_3;

}
