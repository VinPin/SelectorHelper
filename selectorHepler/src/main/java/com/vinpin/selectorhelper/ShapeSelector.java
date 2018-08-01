package com.vinpin.selectorhelper;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.IntDef;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/01 16:05
 *     desc  : Shape类型选择器
 * </pre>
 */
public class ShapeSelector {

    private static ShapeSelector mShapeSelector;
    private int mShapeType;

    private ShapeSelector() {
        mShapeType = GradientDrawable.RECTANGLE;
    }

    public static ShapeSelector getInstance() {
        mShapeSelector = new ShapeSelector();
        return mShapeSelector;
    }

    @IntDef({GradientDrawable.RECTANGLE, GradientDrawable.OVAL,
            GradientDrawable.LINE, GradientDrawable.RING})
    private @interface Shape {
    }

    /**
     * 设置Shape类型,默认矩形 GradientDrawable.RECTANGLE
     */
    public ShapeSelector setShape(@Shape int shape) {
        mShapeType = shape;
        return this;
    }

    public ShapeSelector setSolidColor() {

        return this;
    }
}
