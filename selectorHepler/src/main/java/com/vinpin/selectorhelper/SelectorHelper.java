package com.vinpin.selectorhelper;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/01 16:30
 *     desc  : Selector帮助类
 * </pre>
 */
public class SelectorHelper {

    private static Context mContext;

    private SelectorHelper() {

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
}
