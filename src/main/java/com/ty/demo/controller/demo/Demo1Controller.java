package com.ty.demo.controller.demo;

import com.ty.demo.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/demo1")
@Api( tags="测试")
public class Demo1Controller {

    @ApiOperation("测试1")
    @GetMapping("/test")
    public String test1(){
        return "test";
    }

    @ApiOperation("测试2")
    @PostMapping("/test2")
    public Student  test2(@RequestBody Student stu){
        Student student=new Student();
        BeanUtils.copyProperties(stu,student);
        return  student;
    }
}
