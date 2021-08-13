package com.ty.demo.thread;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.demo.entity.ExcelTest1;
import com.ty.demo.entity.InvoiceReqLinesInterfaceEntity;
import com.ty.demo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.functions.T;
import org.jodconverter.DocumentConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import sun.plugin.javascript.navig.Array;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Slf4j
public class Test2 extends  Thread {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private  final  ReentrantLock lock=new ReentrantLock(true);
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class c=executors.class;
        Method method=c.getDeclaredMethod("helloWord", String.class);
        String name= (String)  method.invoke(c.newInstance(),"你好");
        System.out.println(name);
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
