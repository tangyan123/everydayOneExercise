package com.ty.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list2.add(1);
        list2.add(2);
        list3=  list.stream().filter(l ->
                 list2.contains(l)
        ).collect(Collectors.toList());
        list3.stream().forEach( l-> {
            System.out.println(l);
        });
    }

}
