package com.vinpin.selectorhelper;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/02 10:11
 *     desc  : 颜色类型选择器
 * </pre>
 */
@SuppressWarnings("unused")
public class ColorSelector {

    private HashMap<Integer, Integer> hashMap;

    @SuppressLint("UseSparseArrays")
    private ColorSelector() {
        hashMap = new HashMap<>();
    }

    public static ColorSelector getInstance() {
        return new ColorSelector();
    }

    public ColorSelector enabled(boolean enabled, @ColorRes int color) {
        hashMap.put(enabled ? android.R.attr.state_enabled : -android.R.attr.state_enabled,
                ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector enabled(boolean enabled, @NonNull String color) {
        hashMap.put(enabled ? android.R.attr.state_enabled : -android.R.attr.state_enabled,
                Color.parseColor(color));
        return this;
    }

    public ColorSelector pressed(boolean pressed, @ColorRes int color) {
        hashMap.put(pressed ? android.R.attr.state_pressed : -android.R.attr.state_pressed,
                ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector pressed(boolean pressed, @NonNull String color) {
        hashMap.put(pressed ? android.R.attr.state_pressed : -android.R.attr.state_pressed,
                Color.parseColor(color));
        return this;
    }

    public ColorSelector selected(boolean selected, @ColorRes int color) {
        hashMap.put(selected ? android.R.attr.state_selected : -android.R.attr.state_selected,
                ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector selected(boolean selected, @NonNull String color) {
        hashMap.put(selected ? android.R.attr.state_selected : -android.R.attr.state_selected,
                Color.parseColor(color));
        return this;
    }

    public ColorSelector checked(boolean checked, @ColorRes int color) {
        hashMap.put(checked ? android.R.attr.state_checked : -android.R.attr.state_checked,
                ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector checked(boolean checked, @NonNull String color) {
        hashMap.put(checked ? android.R.attr.state_checked : -android.R.attr.state_checked,
                Color.parseColor(color));
        return this;
    }

    public ColorSelector checkable(boolean checkable, @ColorRes int color) {
        hashMap.put(checkable ? android.R.attr.state_checkable : -android.R.attr.state_checkable,
                ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector checkable(boolean checkable, @NonNull String color) {
        hashMap.put(checkable ? android.R.attr.state_checkable : -android.R.attr.state_checkable,
                Color.parseColor(color));
        return this;
    }

    public ColorSelector focused(boolean focused, @ColorRes int color) {
        hashMap.put(focused ? android.R.attr.state_focused : -android.R.attr.state_focused,
                ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector focused(boolean focused, @NonNull String color) {
        hashMap.put(focused ? android.R.attr.state_focused : -android.R.attr.state_focused,
                Color.parseColor(color));
        return this;
    }

    public ColorSelector windowFocused(boolean windowFocused, @ColorRes int color) {
        hashMap.put(windowFocused ? android.R.attr.state_window_focused : -android.R.attr.state_window_focused,
                ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector windowFocused(boolean windowFocused, @NonNull String color) {
        hashMap.put(windowFocused ? android.R.attr.state_window_focused : -android.R.attr.state_window_focused,
                Color.parseColor(color));
        return this;
    }

    public ColorSelector defaultColor(@ColorRes int color) {
        hashMap.put(0, ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector defaultColor(@NonNull String color) {
        hashMap.put(0, Color.parseColor(color));
        return this;
    }

    public ColorStateList create() {
        int[][] states = null;
        int[] colors = null;
        if (hashMap != null && hashMap.size() > 0) {
            int size = hashMap.size();
            states = new int[size][];
            ArrayList<Integer> keys = new ArrayList<>(size);
            keys.addAll(hashMap.keySet());
            for (int i = 0; i < keys.size(); i++) {
                int key = keys.get(i);
                if (key != 0) {
                    states[i] = new int[]{key};
                } else { // 默认颜色
                    states[i] = new int[]{};
                }
            }
            colors = new int[size];
            ArrayList<Integer> values = new ArrayList<>(size);
            values.addAll(hashMap.values());
            for (int i = 0; i < values.size(); i++) {
                colors[i] = values.get(i);
            }
        }
        return new ColorStateList(states, colors);
    }
}
