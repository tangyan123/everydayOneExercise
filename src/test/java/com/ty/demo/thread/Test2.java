package com.ty.demo.thread;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.demo.entity.ExcelTest1;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.jodconverter.DocumentConverter;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
public class Test2 {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
        String imagePath="D:\\ar\\report";
        File fileTemp = new File(imagePath);
        // 判断文件是否存在
        boolean falg = false;
        falg = fileTemp.exists();
        if (falg) {
            //判断是不是目录
            if (true == fileTemp.isDirectory()) {
                //获取图片
                String[] png = fileTemp.list();
                for (int i = 0; i < png.length; i++) {
                    if (true == png[i].endsWith("png")||true == png[i].endsWith("pdf")) {
                        File file = new File(imagePath +File.separator+ png[i]);
                        if (true == file.isFile()) {
                            file.delete();
                        }
                    }
                }
            }
        }
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
}
