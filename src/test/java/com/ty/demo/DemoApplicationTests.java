package com.ty.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    public static void main(String[] args) {
        String number = "E:\\formatPic\\PM2_1.png";

        System.out.println("测试2："+number.substring(0,number.indexOf(".")));
        number= number.substring(0,number.indexOf("."));
        System.out.println("测试2："+number.substring(13));
    }

}
