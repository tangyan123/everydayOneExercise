package com.ty.demo.utils;

import cn.afterturn.easypoi.word.WordExportUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.util.Assert;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

public class WordUtil {
    private static Configuration configuration = null;
    //classLoader.getResource()只能获取相对路径的资源
//     private static final String templateFolder = WordUtils.class.getClassLoader().getResource("template").getPath();
    //class.getResource()可以获取绝对路径和相对路径
    private static final String templateFolder = WordUtil.class.getResource("/templates").getPath();


    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File(templateFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportWord(String templatePath, String temDir, String fileName, Map<String, Object> params) {
        Assert.notNull(templatePath, "模板路径不能为空");
        Assert.notNull(temDir, "临时文件路径不能为空");
        Assert.notNull(fileName, "导出文件名不能为空");
        Assert.isTrue(fileName.endsWith(".docx"), "word导出请使用docx格式");
        if (!temDir.endsWith("/")) {
            temDir = temDir + File.separator;
        }
        File dir = new File(temDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(templatePath, params);
            String tmpPath = temDir + fileName;
            FileOutputStream fos = new FileOutputStream(tmpPath);
            doc.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private WordUtil() {
        throw new AssertionError();
    }

    public static void exportMillCertificateWord(HttpServletRequest request, HttpServletResponse response, Map map, String title, String ftlFile) throws IOException {
        Template freemarkerTemplate = configuration.getTemplate(ftlFile);
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类的createDoc方法生成Word文档
            file = createDoc(map, freemarkerTemplate);
            fin = new FileInputStream(file);
            FileOutputStream fot = new FileOutputStream("C:\\Users\\2020\\Desktop\\"+file);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件名
            String fileName = title  + ".doc";
            response.setHeader("Content-Disposition", "attachment;filename="
                    .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));

            out = response.getOutputStream();


            byte[] buffer = new byte[512];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
                fot.write(buffer, 0, bytesToRead);
            }
            fot.close();
        } finally {
            if (fin != null) fin.close();
            if (out != null) out.close();
            if (file != null) file.delete(); // 删除临时文件
        }
    }

    private static File createDoc(Map<?, ?> dataMap, Template template) {
        String name = "sellPlan.doc";
        File f = new File(name);
        Template t = template;
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);

            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }


}
