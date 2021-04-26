package com.ty.demo.controller.freechart;

import com.ty.demo.utils.CustomRenderer;
import com.ty.demo.utils.FormatPic;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FormatPicColntroller {
    /**
     * 创建JFreeChart Bar Chart（柱状图）
     */
    public static void main(String[] args) {
        // 步骤1：创建CategoryDataset对象（准备数据）-1.57D
        CategoryDataset dataset = qqq();
        // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
        //数据
        List<Double>data=new ArrayList<>();
        //类型
        String type="";
        CustomRenderer renderer =new CustomRenderer();
        renderer.setData(data);
        renderer.setType(type);
        JFreeChart freeChart =FormatPic.createChart(dataset,"水果",10D,false,renderer);
        // 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
        saveAsFile(freeChart, "E:\\formatPic\\qqq.png", 500, 400);
    }

    // 保存为文件
    public static void saveAsFile(JFreeChart chart, String outputPath, int weight, int height) {
        FileOutputStream out = null;
        try {
            File outFile = new File(outputPath);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(outputPath);
            // 保存为PNG文件
            ChartUtilities.writeChartAsPNG(out, chart, weight, height);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // do nothing
                }
            }
        }
    }


    // 创建CategoryDataset对象
    public static CategoryDataset PM2_1( double[][] data,String[] columnKeys) {
        String[] rowKeys ={""};
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    // 创建CategoryDataset对象
    public static CategoryDataset qqq() {
        double[][] data = new double[][] { { 74, 82, 83, 85} };
        String[] rowKeys ={""};
        String[] columnKeys = { "苹果", "橘子", "香蕉", "西瓜" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset PM2_2() {
        double[][] data = new double[][] { { 23.9, 20.6, 20.4, 17.2, 15.1, 14.1, 12.3} };
        String[] rowKeys ={""};
        String[] columnKeys = { "薛城区", "峄城区", "山亭区", "高新区", "滕州市", "市中区","台儿庄区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    // 创建CategoryDataset对象
    public static CategoryDataset PM10_1() {
        double[][] data = new double[][] { { 130, 154, 154, 161, 163, 164, 164} };
        String[] rowKeys ={""};
        String[] columnKeys = { "山亭区", "滕州市", "薛城区", "高新区 ", "台儿庄区", "市中区","峄城区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset PM10_2() {
        double[][] data = new double[][] { { -4.8, -11.6, -14.7, -15.6, -15.8, -16.8, -20.1} };
        String[] rowKeys ={""};
        String[] columnKeys = { "山亭区", "薛城区", "市中区", "台儿庄区 ", "滕州市", "峄城区","高新区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset SO2_1() {
        double[][] data = new double[][] { { 13, 15, 17, 18, 19, 22, 23} };
        String[] rowKeys ={""};
        String[] columnKeys = { "台儿庄区", "山亭区", "市中区", "峄城区 ", "薛城区", "高新区","滕州市" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset SO2_2() {
        double[][] data = new double[][] { { 31.8, 18.8, 15.0, 4.2, -5.9, -11.8, -83.3} };
        String[] rowKeys ={""};
        String[] columnKeys = { "山亭区", "台儿庄区", "市中区", "滕州市 ", "峄城区", "薛城区","高新区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset NO2_1() {
        double[][] data = new double[][] { { 38, 44, 46, 48, 49, 52, 52} };
        String[] rowKeys ={""};
        String[] columnKeys = { "山亭区", "薛城区", "台儿庄区", "峄城区 ", "滕州市", "市中区","高新区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset NO2_2() {
        double[][] data = new double[][] { { -7.3, -15.6, -16.7, -20.9, -24.3, -31.0, -41.2} };
        String[] rowKeys ={""};
        String[] columnKeys = { "薛城区", "高新区", "滕州市", "市中区 ", "台儿庄区", "山亭区","峄城区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset O3_1() {
        double[][] data = new double[][] { { 80, 81, 86, 86, 87, 88, 91} };
        String[] rowKeys ={""};
        String[] columnKeys = { "市中区", "高新区", "滕州市", "峄城区 ", "台儿庄区", "薛城区","山亭区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
    public static CategoryDataset O3_2() {
        double[][] data = new double[][] { { 16.7, 9.5, 9.0, 8.5, 4.2, 1.1, 0.0} };
        String[] rowKeys ={""};
        String[] columnKeys = { "市中区", "峄城区", "高新区", "滕州市 ", "山亭区", "台儿庄区","薛城区" };
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
}
