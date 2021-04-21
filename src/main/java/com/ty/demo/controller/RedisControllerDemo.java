package com.ty.demo.controller;

import com.ty.demo.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisDemo")
@Api( tags="redis测试")
public class RedisControllerDemo {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @ApiOperation("reids测试")
    @PostMapping("/test")
    public void test2(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        System.out.println(redisTemplate.opsForValue().get(key));
    }

    @ApiOperation("reids测试")
    @PostMapping("/test2")
    public void hash(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        System.out.println(redisTemplate.opsForValue().get(key));
    }
}
