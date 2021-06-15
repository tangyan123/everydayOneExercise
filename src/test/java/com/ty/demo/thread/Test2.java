package com.ty.demo.thread;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.demo.entity.ExcelTest1;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.functions.T;
import org.jodconverter.DocumentConverter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
public class Test2 {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws NoSuchFieldException {
        String minBasis="2.21";
        DecimalFormat df   = new DecimalFormat("######0.0");
        System.out.println(df.format(((float) 8/65)*100));

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
