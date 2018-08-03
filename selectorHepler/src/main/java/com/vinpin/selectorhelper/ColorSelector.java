package com.vinpin.selectorhelper;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/02 10:11
 *     desc  : 颜色类型选择器
 * </pre>
 */
@SuppressWarnings("unused")
public class ColorSelector {

    private ArrayList<Integer> mStates;
    private ArrayList<Integer> mColors;

    @SuppressLint("UseSparseArrays")
    private ColorSelector() {
        mStates = new ArrayList<>();
        mColors = new ArrayList<>();
    }

    public static ColorSelector getInstance() {
        return new ColorSelector();
    }

    public ColorSelector enabled(boolean enabled, @ColorRes int color) {
        mStates.add(enabled ? android.R.attr.state_enabled : -android.R.attr.state_enabled);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector enabled(boolean enabled, @NonNull String color) {
        mStates.add(enabled ? android.R.attr.state_enabled : -android.R.attr.state_enabled);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorSelector pressed(boolean pressed, @ColorRes int color) {
        mStates.add(pressed ? android.R.attr.state_pressed : -android.R.attr.state_pressed);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector pressed(boolean pressed, @NonNull String color) {
        mStates.add(pressed ? android.R.attr.state_pressed : -android.R.attr.state_pressed);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorSelector selected(boolean selected, @ColorRes int color) {
        mStates.add(selected ? android.R.attr.state_selected : -android.R.attr.state_selected);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector selected(boolean selected, @NonNull String color) {
        mStates.add(selected ? android.R.attr.state_selected : -android.R.attr.state_selected);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorSelector checked(boolean checked, @ColorRes int color) {
        mStates.add(checked ? android.R.attr.state_checked : -android.R.attr.state_checked);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector checked(boolean checked, @NonNull String color) {
        mStates.add(checked ? android.R.attr.state_checked : -android.R.attr.state_checked);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorSelector checkable(boolean checkable, @ColorRes int color) {
        mStates.add(checkable ? android.R.attr.state_checkable : -android.R.attr.state_checkable);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector checkable(boolean checkable, @NonNull String color) {
        mStates.add(checkable ? android.R.attr.state_checkable : -android.R.attr.state_checkable);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorSelector focused(boolean focused, @ColorRes int color) {
        mStates.add(focused ? android.R.attr.state_focused : -android.R.attr.state_focused);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector focused(boolean focused, @NonNull String color) {
        mStates.add(focused ? android.R.attr.state_focused : -android.R.attr.state_focused);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorSelector windowFocused(boolean windowFocused, @ColorRes int color) {
        mStates.add(windowFocused ? android.R.attr.state_window_focused : -android.R.attr.state_window_focused);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector windowFocused(boolean windowFocused, @NonNull String color) {
        mStates.add(windowFocused ? android.R.attr.state_window_focused : -android.R.attr.state_window_focused);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorSelector defaultColor(@ColorRes int color) {
        mStates.add(0);
        mColors.add(ContextCompat.getColor(SelectorHelper.getContext(), color));
        return this;
    }

    public ColorSelector defaultColor(@NonNull String color) {
        mStates.add(0);
        mColors.add(Color.parseColor(color));
        return this;
    }

    public ColorStateList create() {
        int[][] states = null;
        if (mStates != null && mStates.size() > 0) {
            states = new int[mStates.size()][];
            for (int i = 0; i < mStates.size(); i++) {
                int state = mStates.get(i);
                if (state != 0) {
                    states[i] = new int[]{state};
                } else { // 默认颜色
                    states[i] = new int[]{};
                }
            }
        }
        int[] colors = null;
        if (mColors != null && mColors.size() > 0) {
            colors = new int[mColors.size()];
            for (int i = 0; i < mColors.size(); i++) {
                colors[i] = mColors.get(i);
            }
        }
        return new ColorStateList(states, colors);
    }
}
