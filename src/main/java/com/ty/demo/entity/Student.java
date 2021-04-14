package com.ty.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {

    @ApiModelProperty(value = "姓名")
    private  String stuName;

    @ApiModelProperty(value = "学号")
    private  Integer stuNo;

    @ApiModelProperty(value = "年龄")
    private  Integer stuAge;

    @ApiModelProperty(value = "性别")
    private  Integer stuSex;

    @ApiModelProperty(value = "入学时间")
    private LocalDate createDate;
}
