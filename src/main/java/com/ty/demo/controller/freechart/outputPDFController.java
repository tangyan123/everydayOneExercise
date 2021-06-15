package com.ty.demo.controller.freechart;

import cn.afterturn.easypoi.view.EasypoiPDFTemplateView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jodconverter.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.jodconverter.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@Api(tags = "word转PDF")
@RequestMapping("/word")
public class outputPDFController {

    @Autowired
    private DocumentConverter converter;


    @GetMapping("/pdf")
    @ApiOperation(value = "PDF")
    public void toPdfFile(HttpServletResponse response){
        File file = new File("C:\\Users\\2020\\Desktop\\工业源.xlsx");//需要转换的文件
        try {
            File newFile = new File("C:\\Users\\2020\\Desktop\\");//转换之后文件生成的地址
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            String savePath="C:\\Users\\2020\\Desktop\\"; //pdf文件生成保存的路径
            String fileName="JCccc"+ UUID.randomUUID().toString().replaceAll("-","").substring(0,6);
            String fileType=".pdf"; //pdf文件后缀
            String newFileMix=savePath+fileName+fileType;  //将这三个拼接起来,就是我们最后生成文件保存的完整访问路径了

            //文件转化
            converter.convert(file).to(new File(newFileMix)).execute();

            //使用response,将pdf文件以流的方式发送的前端浏览器上
            ServletOutputStream outputStream = response.getOutputStream();
            InputStream in = new FileInputStream(new File(newFileMix));// 读取文件
            int i = IOUtils.copy(in, outputStream);   // copy流数据,i为字节数
            in.close();
            outputStream.close();
            System.out.println("流已关闭,可预览,该文件字节大小："+i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
