package com.ty.demo.utils;

import org.jfree.chart.renderer.category.BarRenderer3D;

import java.awt.*;

public class CustomRenderer extends BarRenderer3D {
    /**
     *柱子颜色
     */
    private static final long serialVersionUID = 784630226449158436L;
    private Paint[] colors;

    //初始化柱子颜色
    private String[] colorValues = { "#006633","#006633","#006633","#006633" };

    public CustomRenderer() {
        colors = new Paint[colorValues.length];
        for (int i = 0; i < colorValues.length; i++) {
            colors[i] = Color.decode(colorValues[i]);
        }
    }

    //每根柱子以初始化的颜色不断轮循
    public Paint getItemPaint(int i, int j) {
        return colors[j % colors.length];
    }
}
