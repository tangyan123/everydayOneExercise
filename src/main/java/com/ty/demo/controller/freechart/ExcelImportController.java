package com.ty.demo.controller.freechart;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.ty.demo.entity.ExcelEntity;

import com.ty.demo.entity.ExcelTest1;
import com.ty.demo.utils.ExcelListener;
import com.ty.demo.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "excel导入测试")
public class ExcelImportController {

    @ApiOperation("excel导入")
    @PostMapping("/excle")
    public  void excelImport(MultipartFile file) {
        try {
            List<ExcelEntity>excelEntities= ExcelUtil.importExcel(file,ExcelEntity.class);
            excelEntities.forEach(e -> System.out.println(e));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ApiOperation("excel导入2")
    @PostMapping("/excle2")
    public  void excelImport2(MultipartFile file)  {
        try {
            List<ExcelTest1>test1s=new ArrayList<ExcelTest1>();
            //EasyExcel.read(file.getInputStream(), ExcelTest1.class, new ExcelListener(test1s)).sheet().doRead();

            ExcelListener excelListener=new ExcelListener(test1s);
            ExcelReader reader = new ExcelReader(file.getInputStream(),null,excelListener);
            //读取信息
            reader.read(new Sheet(1,0,ExcelTest1.class));

            test1s.forEach(t -> System.out.println(t));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @ApiOperation("excel导入3")
    @PostMapping("/excle3")
    public  void excelImport3(MultipartFile file)  {

        try {
            List<ExcelTest1>test1s=new ArrayList<ExcelTest1>();
            ExcelListener excelListener=new ExcelListener(test1s);
            ExcelReader excelReader = EasyExcelFactory.getReader(file.getInputStream(),excelListener);
            List<Sheet> sheets=excelReader.getSheets();
            for (Sheet sheet : sheets) {
                if (sheet.getSheetNo()==1){
                    sheet.setClazz(ExcelTest1.class);
                }else if (sheet.getSheetNo()==2)
                {
                    sheet.setClazz(ExcelTest1.class);
                }
                sheet.setHeadLineMun(0);
                excelReader.read(sheet);
            }
            test1s.forEach(t -> System.out.println(t));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
