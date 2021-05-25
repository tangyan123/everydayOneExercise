package com.ty.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExcelTest2 extends BaseRowModel implements Serializable{

        private Integer id;

        private Integer reportId;

        @ExcelProperty(index=1)
        private String name;

        @ExcelProperty(index=2)
        private String so2Now;

        @ExcelProperty(index=3)
        private String so2Last;

        @ExcelProperty(index=4)
        private String so2Basis;

        @ExcelProperty(index=5)
        private String so2Ranking;

        @ExcelProperty(index=6)
        private String no2Now;

        @ExcelProperty(index=7)
        private String no2Last;

        @ExcelProperty(index=8)
        private String no2Basis;

        @ExcelProperty(index=9)
        private String no2Ranking;

        @ExcelProperty(index=10)
        private String pm10Now;

        @ExcelProperty(index=11)
        private String pm10Last;

        @ExcelProperty(index=12)
        private String pm10Basis;

        @ExcelProperty(index=13)
        private String pm10Ranking;

        @ExcelProperty(index=14)
        private String pm25Now;

        @ExcelProperty(index=15)
        private String pm25Last;

        @ExcelProperty(index=16)
        private String pm25Basis;

        @ExcelProperty(index=17)
        private String pm25Ranking;

        @ExcelProperty(index=18)
        private String o3Now;

        @ExcelProperty(index=19)
        private String o3Last;

        @ExcelProperty(index=20)
        private String o3Basis;

        @ExcelProperty(index=21)
        private String o3Ranking;

        @ExcelProperty(index=22)
        private String coNow;

        @ExcelProperty(index=23)
        private String coLast;

        @ExcelProperty(index=24)
        private String coBasis;

        @ExcelProperty(index=25)
        private String coRanking;

        @ExcelProperty(index=26)
        private String synthesizeNow;

        @ExcelProperty(index=27)
        private String synthesizeLast;

        @ExcelProperty(index=28)
        private String synthesizeBasis;

        @ExcelProperty(index=29)
        private String synthesizeRanking;

        @ExcelProperty(index=30)
        private String rateNow;

        @ExcelProperty(index=31)
        private String rateLast;

        @ExcelProperty(index=32)
        private String rateBasis;

        @ExcelProperty(index=33)
        private String rateRanking;

        @ExcelProperty(index=34)
        private String pollutionNow;

        @ExcelProperty(index=35)
        private String pollutionLast;

        @ExcelProperty(index=36)
        private String pollutionBasis;

        @ExcelProperty(index=37)
        private String pollutionRanking;
}
