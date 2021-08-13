package com.ty.demo.utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FormatPic {
    /**
     * 格式化纵向柱状图使用
     *
     * @param
     * @returnType: void
     * @author:
     */
    public static   JFreeChart createChart(CategoryDataset categoryDataset,String titleName,Double columnIntervalUnit,Boolean isInteger,CustomRenderer renderer) {
        JFreeChart jfreechart =createBarChart(categoryDataset,titleName);
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        //是否抗锯齿
        jfreechart.setTextAntiAlias(false);
        //图片背景
        jfreechart.setBackgroundPaint(Color.white);

        CategoryPlot plot = jfreechart.getCategoryPlot();// 获得图表区域对象
        setPlot(plot,labelFont);
        //设置X轴属性
        CategoryAxis domainAxis=setXAxis(plot,labelFont);
        //设置纵轴属性
        NumberAxis vn=  setLongitudinalAxis(plot,columnIntervalUnit,isInteger);
        //解决乱码
        fontMessyCode(jfreechart,domainAxis,vn);
        jfreechart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        //使用自定义的渲染器
        CustomaApply(plot,renderer);


        return jfreechart;
    }

    /**
     * 解决中文乱码问题(关键)
     *
     * @param
     * @returnType: void
     * @author:
     */
    private static void fontMessyCode( JFreeChart jfreechart,CategoryAxis domainAxis,NumberAxis vn  ){
        //
        TextTitle textTitle = jfreechart.getTitle();
        textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
        domainAxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
        vn.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
        vn.setLabelFont(new Font("黑体", Font.PLAIN, 12));
        // jfreechart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
    }
    /**
     * 使用自定义的渲染器
     *
     * @param
     * @returnType: void
     * @author:
     */
    private static  void    CustomaApply( CategoryPlot plot,CustomRenderer renderer){

        // 设置柱子宽度
        renderer.setMaximumBarWidth(0.2);
        // 设置柱子高度
        renderer.setMinimumBarLength(0.2);
        // 设置柱子边框颜色
        renderer.setBaseOutlinePaint(Color.BLACK);
        // 设置柱子边框可见
        renderer.setDrawBarOutline(true);
        // 设置每个地区所包含的平行柱的之间距离
        renderer.setItemMargin(0.5);
        //数据标签的字体
        //   renderer.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 8));
        // 显示每个柱的数值，并修改该数值的字体属性
        renderer.setIncludeBaseInRange(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setItemLabelAnchorOffset(0);

//        //设置柱子上显示的数据旋转90度,最后一个参数为旋转的角度值/3.14
//        ItemLabelPosition itemLabelPosition= new ItemLabelPosition(
//                ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_CENTER,
//                TextAnchor.HALF_ASCENT_CENTER,0D);
//        //设置正常显示的柱子label的position
//        renderer.setPositiveItemLabelPosition(itemLabelPosition);
//        renderer.setNegativeItemLabelPosition(itemLabelPosition);


        //设置不能在柱子上正常显示的那些数值的显示方式，将这些数值显示在柱子外面
        ItemLabelPosition itemLabelPositionFallback=new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE5, TextAnchor.BASELINE_CENTER,
                TextAnchor.HALF_ASCENT_CENTER,0D);
        //设置不能正常显示的柱子label的position
        renderer.setPositiveItemLabelPositionFallback(itemLabelPositionFallback);
        renderer.setNegativeItemLabelPositionFallback(itemLabelPositionFallback);
        plot.setRenderer(renderer);
        // 设置柱的透明度
        plot.setForegroundAlpha(1.0f);
        // 背景色 透明度
        plot.setBackgroundAlpha(0.5f);
    }

    /**
     * 设置创建柱状图属性
     * @param categoryDataset
     * @param titleName
     */
    private static JFreeChart createBarChart(CategoryDataset categoryDataset,String titleName){
        JFreeChart jfreechart = ChartFactory.createBarChart(titleName, // 标题
                "", // categoryAxisLabel （category轴，横轴，X轴的标签）
                "", // valueAxisLabel（value轴，纵轴，Y轴的标签）
                categoryDataset, // dataset
                PlotOrientation.VERTICAL,// // 图表方向：水平、垂直
                false, // 是否显示图例(对于简单的柱状图必须是 false)
                false, // 是否生成工具
                false ); // 是否生成 URL 链接
        return jfreechart;
    }

    /**
     * 设置纵轴显示数值单位
     * @param plot
     * @param columnIntervalUnit
     * @param isInteger
     * @return
     */
    private static NumberAxis setLongitudinalAxis(CategoryPlot plot,Double columnIntervalUnit,Boolean isInteger){
        // 数据轴精度
        NumberAxis vn = (NumberAxis) plot.getRangeAxis();
        //设置最高的一个柱与图片顶端的距离(最高柱的10%)
        vn.setUpperMargin(0.3);
        // vn.setAutoRangeIncludesZero(true);
        //判断纵轴数据是小数还是整数
        if (isInteger){
            DecimalFormat df = new DecimalFormat("#0");
            vn.setNumberFormatOverride(df); // 数据轴数据标签的显示格式
        }else {
            DecimalFormat df = new DecimalFormat("#0.0");
            vn.setNumberFormatOverride(df); // 数据轴数据标签的显示格式
        }

        //纵轴显示数值 为一个间隔单位
        vn.setTickUnit(new NumberTickUnit(columnIntervalUnit));
        return  vn;
    }
    private static CategoryAxis setXAxis(CategoryPlot plot,Font labelFont) {
        // x轴设置
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(labelFont);// 轴标题
        domainAxis.setTickLabelFont(labelFont);// 轴数值
        // Lable（Math.PI/3.0）度倾斜
        // domainAxis.setCategoryLabelPositions(CategoryLabelPositions
        // .createUpRotationLabelPositions(Math.PI / 3.0));
        domainAxis.setMaximumCategoryLabelWidthRatio(6.00f);// 横轴上的 Lable

        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.1);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.1);
        // 设置 columnKey 是否间隔显示
        // domainAxis.setSkipCategoryLabelsToFit(true);
        plot.setDomainAxis(domainAxis);
        return  domainAxis;
    }

    /**
     * 设置图表
     * @param plot
     * @param labelFont
     */
    private static void setPlot(CategoryPlot plot,Font labelFont ) {
        // 设置横虚线可见
        plot.setRangeGridlinesVisible(true);
        // 虚线色彩
        plot.setRangeGridlinePaint(Color.black);
        //设置横实线
        plot.setDomainGridlineStroke(new BasicStroke());
        plot.setRangeGridlineStroke(new BasicStroke());
        // 设置柱图背景色（注意，系统取色的时候要使用16位的模式来查看颜色编码，这样比较准确）
        plot.setBackgroundPaint(Color.white);

        // y轴设置
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(labelFont);
        rangeAxis.setTickLabelFont(labelFont);
        // 自动设置数据轴数据范围
        //  rangeAxis.setRange(-100,100) ;
        // 设置最高的一个 Item 与图片顶端的距离
        rangeAxis.setUpperMargin(0.15);
        // 设置最低的一个 Item 与图片底端的距离
        rangeAxis.setLowerMargin(0.15);
        //  rangeAxis.setVerticalTickLabels(true);
        plot.setRangeAxis(rangeAxis);
    }

    /**
     * 警戒线柱状图
     *
     */
        public  static JFreeChart warningLineChart(CategoryDataset categoryDataset,String titleName,Double columnIntervalUnit,Boolean isInteger,CustomRenderer renderer,Double warningLineUnit){
        JFreeChart jfreechart =createBarChart(categoryDataset,titleName);
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        //是否抗锯齿
        jfreechart.setTextAntiAlias(false);
        //图片背景
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot plot = jfreechart.getCategoryPlot();// 获得图表区域对象
        //设置图表区域信息
        setPlot(plot,labelFont);
        //设置X轴属性
        CategoryAxis domainAxis=setXAxis(plot,labelFont);
        //设置纵轴属性
        NumberAxis vn=  setLongitudinalAxis(plot,columnIntervalUnit,isInteger);
        //解决乱码
        fontMessyCode(jfreechart,domainAxis,vn);
        jfreechart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        //使用自定义的渲染器
        CustomaApply(plot,renderer);
        ValueMarker valuemarker = new ValueMarker(warningLineUnit);  // 水平线的值
        valuemarker.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        valuemarker.setPaint(Color.red);  //线条颜色
        valuemarker.setStroke(new BasicStroke(1.5F));  //粗细
//        valuemarker.setLabel("Temperature Threshold");   //线条上显示的文本
//        valuemarker.setLabelFont(new Font("SansSerif", 0, 11)); //文本格式
//        valuemarker.setLabelPaint(Color.red);
//        valuemarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
//        valuemarker.setLabelTextAnchor(TextAnchor.BOTTOM_LEFT);
        plot.addRangeMarker(valuemarker);
        return  jfreechart;
    }

}
