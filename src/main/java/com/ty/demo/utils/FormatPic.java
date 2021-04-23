package com.ty.demo.utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.text.DecimalFormat;

public class FormatPic {
    /**
     * 格式化纵向柱状图使用
     *
     * @param
     * @returnType: void
     * @author:
     * @data: Nov 26, 2009
     * @time: 11:51:26 AM
     */
    public static JFreeChart createChart(CategoryDataset categoryDataset,Double columnIntervalUnit) {
        JFreeChart jfreechart = ChartFactory.createBarChart("O3 同比改善率 (%) ", // 标题
                "", // categoryAxisLabel （category轴，横轴，X轴的标签）
                "", // valueAxisLabel（value轴，纵轴，Y轴的标签）
                categoryDataset, // dataset
                PlotOrientation.VERTICAL,// // 图表方向：水平、垂直
                false, // 是否显示图例(对于简单的柱状图必须是 false)
                false, // 是否生成工具
                false ); // 是否生成 URL 链接

        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        //是否抗锯齿
        jfreechart.setTextAntiAlias(false);
        //图片背景
        jfreechart.setBackgroundPaint(Color.white);

        CategoryPlot plot = jfreechart.getCategoryPlot();// 获得图表区域对象

        // 设置横虚线可见
        plot.setRangeGridlinesVisible(true);
        // 虚线色彩
        plot.setRangeGridlinePaint(Color.black);
        //设置横实线
        plot.setDomainGridlineStroke(new BasicStroke());
        plot.setRangeGridlineStroke(new BasicStroke());
        // 数据轴精度
        NumberAxis vn = (NumberAxis) plot.getRangeAxis();
        // vn.setAutoRangeIncludesZero(true);
        DecimalFormat df = new DecimalFormat("#0.0");
        vn.setNumberFormatOverride(df); // 数据轴数据标签的显示格式
        //纵轴显示数值 为一个间隔单位
        vn.setTickUnit(new NumberTickUnit(columnIntervalUnit));
        // x轴设置
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(labelFont);// 轴标题
        domainAxis.setTickLabelFont(labelFont);// 轴数值
        // Lable（Math.PI/3.0）度倾斜
        // domainAxis.setCategoryLabelPositions(CategoryLabelPositions
        // .createUpRotationLabelPositions(Math.PI / 3.0));
        domainAxis.setMaximumCategoryLabelWidthRatio(6.00f);// 横轴上的 Lable
        // 是否完整显示

        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.1);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.1);
        // 设置 columnKey 是否间隔显示
        // domainAxis.setSkipCategoryLabelsToFit(true);
        plot.setDomainAxis(domainAxis);
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

        // 解决中文乱码问题(关键)
        TextTitle textTitle = jfreechart.getTitle();
        textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
        vn.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
        vn.setLabelFont(new Font("黑体", Font.PLAIN, 12));
        // jfreechart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

        // 使用自定义的渲染器
        CustomRenderer renderer = new CustomRenderer();
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
        jfreechart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        //数据标签的字体
     //   renderer.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 8));
        // 显示每个柱的数值，并修改该数值的字体属性
        renderer.setIncludeBaseInRange(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);

//        //设置柱子上显示的数据旋转90度,最后一个参数为旋转的角度值/3.14
//        ItemLabelPosition itemLabelPosition= new ItemLabelPosition(
//                ItemLabelAnchor.INSIDE12,TextAnchor.CENTER_RIGHT,
//                TextAnchor.CENTER_RIGHT,-1.57D);
//        //设置正常显示的柱子label的position
//        renderer.setPositiveItemLabelPosition(itemLabelPosition);
//        renderer.setNegativeItemLabelPosition(itemLabelPosition);


         //设置不能在柱子上正常显示的那些数值的显示方式，将这些数值显示在柱子外面
        ItemLabelPosition itemLabelPositionFallback=new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT,
                TextAnchor.HALF_ASCENT_LEFT,0D);
        //设置不能正常显示的柱子label的position
        renderer.setPositiveItemLabelPositionFallback(itemLabelPositionFallback);
        renderer.setNegativeItemLabelPositionFallback(itemLabelPositionFallback);
        plot.setRenderer(renderer);
        // 设置柱的透明度
        plot.setForegroundAlpha(1.0f);
        // 背景色 透明度
        plot.setBackgroundAlpha(0.5f);

        return jfreechart;
    }
}
