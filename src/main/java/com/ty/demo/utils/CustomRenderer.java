package com.ty.demo.utils;

import com.ty.demo.dto.TypeEum;
import lombok.Data;
import org.jfree.chart.renderer.category.BarRenderer3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomRenderer extends BarRenderer3D {

    private static final long serialVersionUID = 784630226449158436L;
    /**
     *柱子颜色
     */
    private Paint[] colors;

    /**
     * 比较值
     */
    private static final Double COMPARISON_VALUE = 0D;


    /**
     * 类型
     */
    private   String Type ;

   /**
     * 柱子数据
     */
    private List<Double> data;



    public CustomRenderer() {
        /**
         * 初始化柱子颜色
         */
        String[] colorValues = {"#9BBE62", "#F59A23", "#E84614"};
        colors = new Paint[colorValues.length];
        for (int i = 0; i < colorValues.length; i++) {
            colors[i] = Color.decode(colorValues[i]);
        }
    }

    @Override
    public Paint getItemPaint(int i, int j) {
        Double data = this.data.get(j);
        String type = this.Type;
        if (type.equalsIgnoreCase(TypeEum.CONCENTRATION.name())) {
            return colors[0];
        } else
        {
            if (data >= COMPARISON_VALUE) {
                return colors[1];
            } else {
                return colors[2];
            }
        }

        }

}
