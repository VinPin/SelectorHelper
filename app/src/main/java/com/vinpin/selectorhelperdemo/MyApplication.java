package com.vinpin.selectorhelperdemo;

import android.app.Application;

import com.vinpin.selectorhelper.SelectorHelper;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/02 14:13
 *     desc  : 全局Application
 * </pre>
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //SelectorHelper 初始化
        SelectorHelper.init(this);
    }
}
