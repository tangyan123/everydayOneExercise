package com.ty.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now().plusDays(1));
    }

}
