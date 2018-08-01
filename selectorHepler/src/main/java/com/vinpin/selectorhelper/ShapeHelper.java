package com.vinpin.selectorhelper;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/01 16:19
 *     desc  : Shape帮助类
 * </pre>
 */
public class ShapeHelper {

    private int mShapeType;

    private boolean isSolidColor = false;
    private int mSolidColor;

    private boolean isStroke = false;
    private int mStrokeWidth;
    private int mStrokeColor;

    private boolean isRadius = false;
    private float topLeftRadius = 0;
    private float topRightRadius = 0;
    private float bottomLeftRadius = 0;
    private float bottomRightRadius = 0;

    private ShapeHelper() {
        mShapeType = GradientDrawable.RECTANGLE;
    }

    public static ShapeHelper getInstance() {
        return new ShapeHelper();
    }

    @IntDef({GradientDrawable.RECTANGLE, GradientDrawable.OVAL,
            GradientDrawable.LINE, GradientDrawable.RING})
    private @interface Shape {
    }

    /**
     * 设置Shape类型,默认矩形 GradientDrawable.RECTANGLE
     */
    public ShapeHelper shape(@Shape int shape) {
        mShapeType = shape;
        return this;
    }

    /**
     * 设置实心背景颜色
     */
    public ShapeHelper solidColor(@ColorRes int color) {
        isSolidColor = true;
        mSolidColor = ContextCompat.getColor(SelectorHelper.getContext(), color);
        return this;
    }

    /**
     * 设置实心背景颜色
     */
    public ShapeHelper solidColor(@NonNull String colorString) {
        isSolidColor = true;
        mSolidColor = Color.parseColor(colorString);
        return this;
    }

    /**
     * 设置边框
     */
    public ShapeHelper stroke(int strokeWidth, @ColorRes int strokeColor) {
        isStroke = true;
        mStrokeWidth = strokeWidth;
        mStrokeColor = ContextCompat.getColor(SelectorHelper.getContext(), strokeColor);
        return this;
    }

    /**
     * 设置边框
     */
    public ShapeHelper stroke(int strokeWidth, @NonNull String strokeColorString) {
        isStroke = true;
        mStrokeWidth = strokeWidth;
        mStrokeColor = Color.parseColor(strokeColorString);
        return this;
    }

    /**
     * 设置圆角
     */
    public ShapeHelper cornerRadius(float radius) {
        isRadius = true;
        topLeftRadius = radius;
        topRightRadius = radius;
        bottomLeftRadius = radius;
        bottomRightRadius = radius;
        return this;
    }

    /**
     * 设置左上圆角
     */
    public ShapeHelper tlRadius(float radius) {
        isRadius = true;
        topLeftRadius = radius;
        return this;
    }

    /**
     * 设置右上圆角
     */
    public ShapeHelper trRadius(float radius) {
        isRadius = true;
        topRightRadius = radius;
        return this;
    }

    /**
     * 设置左下圆角
     */
    public ShapeHelper blRadius(float radius) {
        isRadius = true;
        bottomLeftRadius = radius;
        return this;
    }

    /**
     * 设置右下圆角
     */
    public ShapeHelper brRadius(float radius) {
        isRadius = true;
        bottomRightRadius = radius;
        return this;
    }

    public GradientDrawable create() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(mShapeType);
        if (isSolidColor) {
            drawable.setColor(mSolidColor);
        }
        if (isStroke) {
            drawable.setStroke(mStrokeWidth, mStrokeColor);
        }
        if (isRadius) {
            float[] radii = {topLeftRadius, topLeftRadius,
                    topRightRadius, topRightRadius,
                    bottomRightRadius, bottomRightRadius,
                    bottomLeftRadius, bottomLeftRadius};
            drawable.setCornerRadii(radii);
        }
        return drawable;
    }
}
