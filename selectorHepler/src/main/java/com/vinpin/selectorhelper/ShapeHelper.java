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
@SuppressWarnings("unused")
public class ShapeHelper {

    private int mShapeType;

    private boolean isSolidColor = false;
    private int mSolidColor;

    private boolean isStroke = false;
    private int mStrokeWidth;
    private int mStrokeColor;

    private boolean isDashStroke = false;
    private int strokeLineWidth;
    private int strokeLineColor;
    private int dashWidth;
    private int dashGap;

    private boolean isCornerRadius = false;
    private float topLeftRadius = 0;
    private float topRightRadius = 0;
    private float bottomLeftRadius = 0;
    private float bottomRightRadius = 0;

    private boolean isGradient = false;
    private int mGradientType;
    private int mGradientOrientation;
    private int[] gradientColors;
    private float gradientCenterX;
    private float gradientCenterY;
    private float gradientRadius;

    public static final int TOP_BOTTOM = 0;
    public static final int BOTTOM_TOP = 1;
    public static final int LEFT_RIGHT = 2;
    public static final int RIGHT_LEFT = 3;

    private ShapeHelper() {
        mShapeType = GradientDrawable.RECTANGLE;
        mGradientType = GradientDrawable.LINEAR_GRADIENT;
        mGradientOrientation = TOP_BOTTOM;
    }

    public static ShapeHelper getInstance() {
        return new ShapeHelper();
    }

    @IntDef({GradientDrawable.RECTANGLE, GradientDrawable.OVAL,
            GradientDrawable.LINE, GradientDrawable.RING})
    public @interface Shape {
    }

    @IntDef({TOP_BOTTOM, BOTTOM_TOP, LEFT_RIGHT, RIGHT_LEFT})
    public @interface GradientOrientation {
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
     * 设置虚线边框
     */
    public ShapeHelper stroke(int width, @ColorRes int color, int dashWidth, int dashGap) {
        isDashStroke = true;
        strokeLineWidth = width;
        strokeLineColor = ContextCompat.getColor(SelectorHelper.getContext(), color);
        this.dashWidth = dashWidth;
        this.dashGap = dashGap;
        return this;
    }

    /**
     * 设置虚线边框
     */
    public ShapeHelper stroke(int width, String colorString, int dashWidth, int dashGap) {
        isDashStroke = true;
        strokeLineWidth = width;
        strokeLineColor = Color.parseColor(colorString);
        this.dashWidth = dashWidth;
        this.dashGap = dashGap;
        return this;
    }

    /**
     * 设置圆角
     */
    public ShapeHelper cornerRadius(float radius) {
        isCornerRadius = true;
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
        isCornerRadius = true;
        topLeftRadius = radius;
        return this;
    }

    /**
     * 设置右上圆角
     */
    public ShapeHelper trRadius(float radius) {
        isCornerRadius = true;
        topRightRadius = radius;
        return this;
    }

    /**
     * 设置左下圆角
     */
    public ShapeHelper blRadius(float radius) {
        isCornerRadius = true;
        bottomLeftRadius = radius;
        return this;
    }

    /**
     * 设置右下圆角
     */
    public ShapeHelper brRadius(float radius) {
        isCornerRadius = true;
        bottomRightRadius = radius;
        return this;
    }


    /**
     * 默认线性渐变，默认方向上到下
     *
     * @param gradientColorsResId 渐变颜色组，至少2个
     */
    public ShapeHelper gradient(@ColorRes int... gradientColorsResId) {
        return gradient(GradientDrawable.LINEAR_GRADIENT, TOP_BOTTOM, gradientColorsResId);
    }

    /**
     * 默认线性渐变，默认方向上到下
     *
     * @param gradientColorsString 渐变颜色组，至少2个
     */
    public ShapeHelper gradient(@NonNull String... gradientColorsString) {
        return gradient(GradientDrawable.LINEAR_GRADIENT, TOP_BOTTOM, gradientColorsString);
    }

    /**
     * 默认线性渐变
     *
     * @param gradientOrientation 渐变方向
     * @param startColorResId     开始渐变颜色组
     * @param endColorResId       结束渐变颜色组
     */
    public ShapeHelper gradient(@GradientOrientation int gradientOrientation,
                                @ColorRes int startColorResId, @ColorRes int endColorResId) {
        return gradient(gradientOrientation, new int[]{startColorResId, endColorResId});
    }

    /**
     * 默认线性渐变
     *
     * @param gradientOrientation 渐变方向
     * @param gradientColorsResId 渐变颜色组，至少2个
     */
    public ShapeHelper gradient(@GradientOrientation int gradientOrientation,
                                @ColorRes int... gradientColorsResId) {
        return gradient(GradientDrawable.LINEAR_GRADIENT, gradientOrientation, gradientColorsResId);
    }

    /**
     * 默认线性渐变
     *
     * @param gradientOrientation  渐变方向
     * @param gradientColorsString 渐变颜色组，至少2个
     */
    public ShapeHelper gradient(@GradientOrientation int gradientOrientation, @NonNull String... gradientColorsString) {
        return gradient(GradientDrawable.LINEAR_GRADIENT, gradientOrientation, gradientColorsString);
    }

    /**
     * 扫描渐变样式
     *
     * @param gradientColorsResId 渐变颜色组，至少2个
     */
    public ShapeHelper gradientSweep(@ColorRes int... gradientColorsResId) {
        return gradient(GradientDrawable.SWEEP_GRADIENT, TOP_BOTTOM, gradientColorsResId);
    }

    /**
     * 扫描渐变样式
     *
     * @param gradientColorsString 渐变颜色组，至少2个
     */
    public ShapeHelper gradientSweep(@NonNull String... gradientColorsString) {
        return gradient(GradientDrawable.SWEEP_GRADIENT, TOP_BOTTOM, gradientColorsString);
    }

    /**
     * 设置渐变样式
     *
     * @param gradientType        渐变类型
     * @param gradientOrientation 渐变方向
     * @param gradientColorsResId 渐变颜色组，至少2个
     */
    private ShapeHelper gradient(int gradientType, @GradientOrientation int gradientOrientation,
                                 @ColorRes int... gradientColorsResId) {
        isGradient = true;
        mGradientType = gradientType;
        mGradientOrientation = gradientOrientation;
        if (gradientColorsResId.length > 1) {
            gradientColors = new int[gradientColorsResId.length];
            for (int i = 0; i < gradientColorsResId.length; i++) {
                gradientColors[i] = ContextCompat.getColor(SelectorHelper.getContext(), gradientColorsResId[i]);
            }
        } else {
            throw new IllegalArgumentException("参数错误，至少需要2个渐变颜色！");
        }
        return this;
    }

    /**
     * 设置渐变样式
     *
     * @param gradientType         渐变类型
     * @param gradientOrientation  渐变方向
     * @param gradientColorsString 渐变颜色组，至少2个
     */
    private ShapeHelper gradient(int gradientType, @GradientOrientation int gradientOrientation,
                                 @NonNull String... gradientColorsString) {
        isGradient = true;
        mGradientType = gradientType;
        mGradientOrientation = gradientOrientation;
        if (gradientColorsString.length > 1) {
            gradientColors = new int[gradientColorsString.length];
            for (int i = 0; i < gradientColorsString.length; i++) {
                gradientColors[i] = Color.parseColor(gradientColorsString[i]);
            }
        } else {
            throw new IllegalArgumentException("参数错误，至少需要2个渐变颜色！");
        }
        return this;
    }

    /**
     * 辐射渐变样式，默认中心点位置
     *
     * @param gradientRadius      辐射半径
     * @param gradientColorsResId 渐变颜色组，至少2个
     */
    public ShapeHelper gradientRadial(float gradientRadius, @ColorRes int... gradientColorsResId) {
        return gradientRadial(0.5f, 0.5f, gradientRadius, gradientColorsResId);
    }

    /**
     * 辐射渐变样式，默认中心点位置
     *
     * @param gradientRadius       辐射半径
     * @param gradientColorsString 渐变颜色组，至少2个
     */
    public ShapeHelper gradientRadial(float gradientRadius, @NonNull String... gradientColorsString) {
        return gradientRadial(0.5f, 0.5f, gradientRadius, gradientColorsString);
    }

    /**
     * 辐射渐变样式
     *
     * @param gradientCenterX     中心点x，宽度的倍数
     * @param gradientCenterY     中心点y，高度的倍数
     * @param gradientRadius      辐射半径
     * @param gradientColorsResId 渐变颜色组，至少2个
     */
    public ShapeHelper gradientRadial(float gradientCenterX, float gradientCenterY, float gradientRadius,
                                      @ColorRes int... gradientColorsResId) {
        isGradient = true;
        mGradientType = GradientDrawable.RADIAL_GRADIENT;
        this.gradientCenterX = gradientCenterX;
        this.gradientCenterY = gradientCenterY;
        this.gradientRadius = gradientRadius;
        if (gradientColorsResId.length > 1) {
            gradientColors = new int[gradientColorsResId.length];
            for (int i = 0; i < gradientColorsResId.length; i++) {
                gradientColors[i] = ContextCompat.getColor(SelectorHelper.getContext(), gradientColorsResId[i]);
            }
        } else {
            throw new IllegalArgumentException("参数错误，至少需要2个渐变颜色！");
        }
        return this;
    }

    /**
     * 辐射渐变样式
     *
     * @param gradientCenterX      中心点x，宽度的倍数
     * @param gradientCenterY      中心点y，高度的倍数
     * @param gradientRadius       辐射半径
     * @param gradientColorsString 渐变颜色组，至少2个
     */
    public ShapeHelper gradientRadial(float gradientCenterX, float gradientCenterY, float gradientRadius,
                                      @NonNull String... gradientColorsString) {
        isGradient = true;
        mGradientType = GradientDrawable.RADIAL_GRADIENT;
        this.gradientCenterX = gradientCenterX;
        this.gradientCenterY = gradientCenterY;
        this.gradientRadius = gradientRadius;
        if (gradientColorsString.length > 1) {
            gradientColors = new int[gradientColorsString.length];
            for (int i = 0; i < gradientColorsString.length; i++) {
                gradientColors[i] = Color.parseColor(gradientColorsString[i]);
            }
        } else {
            throw new IllegalArgumentException("参数错误，至少需要2个渐变颜色！");
        }
        return this;
    }

    /**
     * 获取线性渐变渐变方向
     */
    private GradientDrawable.Orientation getGradientOrientation() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        switch (mGradientOrientation) {
            case TOP_BOTTOM:
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            case BOTTOM_TOP:
                orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                break;
            case LEFT_RIGHT:
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            case RIGHT_LEFT:
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                break;
            default:
                break;
        }
        return orientation;
    }

    /**
     * 创建 GradientDrawable
     */
    public GradientDrawable create() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(mShapeType);
        if (isSolidColor) {
            drawable.setColor(mSolidColor);
        }
        if (isStroke) {
            drawable.setStroke(mStrokeWidth, mStrokeColor);
        }
        if (isDashStroke) {
            drawable.setStroke(strokeLineWidth, strokeLineColor, dashWidth, dashGap);
        }
        if (isCornerRadius) {
            float[] radii = {topLeftRadius, topLeftRadius,
                    topRightRadius, topRightRadius,
                    bottomRightRadius, bottomRightRadius,
                    bottomLeftRadius, bottomLeftRadius};
            drawable.setCornerRadii(radii);
        }
        if (isGradient) {
            drawable.setGradientType(mGradientType);
            drawable.setColors(gradientColors);
            switch (mGradientType) {
                case GradientDrawable.LINEAR_GRADIENT:
                    // 线性渐变设置渐变方向
                    drawable.setOrientation(getGradientOrientation());
                    break;
                case GradientDrawable.RADIAL_GRADIENT:
                    // 辐射渐变设置辐射中心点和半径
                    drawable.setGradientCenter(gradientCenterX, gradientCenterY);
                    drawable.setGradientRadius(gradientRadius);
                    break;
                case GradientDrawable.SWEEP_GRADIENT:
                    break;
                default:
                    break;
            }
        }
        return drawable;
    }
}
