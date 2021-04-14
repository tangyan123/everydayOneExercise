package com.ty.demo.controller;

import com.ty.demo.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/demo1")
@Api( tags="测试")
public class Demo1Controller {

    @GetMapping("test")
    @ApiOperation("测试1")
    public String test1(){
        return "test";
    }


    @GetMapping("test2")
    @ApiOperation("测试2")
    public Student test2(Student stu){
        Student student=new Student();
        BeanUtils.copyProperties(stu,student);
        return student;
    }
}
