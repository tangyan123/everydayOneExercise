package com.ty.demo.controller.freechart;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import com.ty.demo.entity.ExcelEntity;

import com.ty.demo.entity.ExcelTest1;
import com.ty.demo.entity.ExcelTest2;
import com.ty.demo.utils.ExcelListener;
import com.ty.demo.utils.ExcelListener2;
import com.ty.demo.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
//        String fileName = "D:\\ar\\report\\2b737e564078410f9b0f51912f1a206e.xlsx";
//        // 读取全部sheet
//        // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
//        EasyExcel.read(fileName, ExcelTest2.class, new ExcelListener()).doReadAll();
        // 读取部分sheet
        String     fileName =  "D:\\ar\\report\\2b737e564078410f9b0f51912f1a206e.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
        ReadSheet readSheet1 =
                EasyExcel.readSheet(0).head(ExcelTest2.class).registerReadListener(new ExcelListener()).build();
        ReadSheet readSheet2 =
                EasyExcel.readSheet(1).head(ExcelTest1.class).registerReadListener(new ExcelListener()).build();
        // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
        excelReader.read(readSheet1, readSheet2);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
    @ApiOperation("excel导入3")
    @PostMapping("/excle3")
    public  void excelImport3(MultipartFile file)  {
        ExcelReader excelReader=null;
        try {
     //       InputStream fis = new FileInputStream("D:\\ar\\report\\2b737e564078410f9b0f51912f1a206e.xlsx");
            ExcelListener excelListener=new ExcelListener();
            excelReader = EasyExcelFactory.getReader(file.getInputStream(),excelListener);
            List<Sheet> sheets=excelReader.getSheets();
            for (Sheet sheet : sheets) {
                if (sheet.getSheetNo()==1){
                    sheet.setClazz(ExcelTest2.class);
                }else if (sheet.getSheetNo()==2)
                {
                    sheet.setClazz(ExcelTest1.class);
                }
                sheet.setHeadLineMun(0);
                excelReader.read(sheet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (excelReader!=null){
                excelReader.finish();
            }
        }
    }

    @ApiOperation("excel导入4")
    @PostMapping("/excle4")
    public  void excelImport4(MultipartFile file)  {
        String     fileName =  "C:\\Users\\2020\\Desktop\\test.xlsx";
      //  EasyExcel.read(fileName, DemoExtraData.class, new ExcelListener2()).extraRead(CellExtraTypeEnum.MERGE).sheet().doRead();
    }

}
