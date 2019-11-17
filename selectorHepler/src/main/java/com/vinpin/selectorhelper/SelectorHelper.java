package com.vinpin.selectorhelper;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/01 16:30
 *     desc  : Selector帮助类
 * </pre>
 */
public class SelectorHelper {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private SelectorHelper() {
        throw new UnsupportedOperationException("u can not create.");
    }

    /**
     * 在全局Application中初始化
     *
     * @param application an Application instance.
     */
    public static void init(@NonNull Application application) {
        mContext = application;
    }

    public static Context getContext() {
        if (mContext == null) {
            throw new ExceptionInInitializerError("请先在全局Application中调用 SelectorHelper.init() 初始化！");
        }
        return mContext;
    }

    /**
     * 创建 ShapeSelector 对象
     */
    public static ShapeSelector shapeSelector() {
        return ShapeSelector.getInstance();
    }

    /**
     * 创建 ColorSelector 对象
     */
    public static ColorSelector colorSelector() {
        return ColorSelector.getInstance();
    }

    /**
     * 创建 DrawableSelector 对象
     */
    public static DrawableSelector drawableSelector() {
        return DrawableSelector.getInstance();
    }
}
