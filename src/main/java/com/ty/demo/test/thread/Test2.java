package com.ty.demo.test.thread;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Test2 extends  Thread {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private  final  ReentrantLock lock=new ReentrantLock(true);
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
         final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.parse(LocalDateTime.now().toString(),formatter));
    }






    public static <T> T convertObjectByJackson(Object origin, Class<T> targetClazz, T defaultVal) {
        try {
            return objectMapper.convertValue(origin, targetClazz);
        } catch (Exception ex) {
            log.error("[对象转换异常]origin={},targetClazz={},defaultVal={}", origin, targetClazz, defaultVal, ex);
        }
        return defaultVal;
    }
    public static <T> List<T> convertObjectsByJackson(List<?> originObjects, Class<T> targetObjClazz, List<T> defaultVal) {
        if (originObjects != null) {
            List<T> list = new ArrayList<T>();
            originObjects.forEach(object -> {
                T converted = convertObjectByJackson(object, targetObjClazz, null);
                if (converted != null) {
                    list.add(converted);
                }
            });
            return list;
        }
        return defaultVal;
    }

    private void m(){
        lock.lock();
        try {
            for (int i=0;i<10;i++){
                System.out.println(i);
            }
        }finally {
            lock.unlock();
        }

    }

    @Override
    public void run() {
        m();
    }
}
