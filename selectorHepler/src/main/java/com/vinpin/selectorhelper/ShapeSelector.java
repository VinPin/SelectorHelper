package com.vinpin.selectorhelper;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/01 16:05
 *     desc  : Shape类型选择器
 * </pre>
 */
public class ShapeSelector {

    private StateListDrawable mSelector;

    private ShapeSelector() {
        mSelector = new StateListDrawable();
    }

    public static ShapeSelector getInstance() {
        return new ShapeSelector();
    }

    public ShapeSelector enabled(boolean enabled, @NonNull GradientDrawable shape) {
        if (enabled) {
            mSelector.addState(new int[]{android.R.attr.state_enabled}, shape);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_enabled}, shape);
        }
        return this;
    }

    public ShapeSelector pressed(boolean pressed, @NonNull GradientDrawable shape) {
        if (pressed) {
            mSelector.addState(new int[]{android.R.attr.state_pressed}, shape);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_pressed}, shape);
        }
        return this;
    }

    public ShapeSelector selected(boolean selected, @NonNull GradientDrawable shape) {
        if (selected) {
            mSelector.addState(new int[]{android.R.attr.state_selected}, shape);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_selected}, shape);
        }
        return this;
    }

    public ShapeSelector checked(boolean checked, @NonNull GradientDrawable shape) {
        if (checked) {
            mSelector.addState(new int[]{android.R.attr.state_checked}, shape);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_checked}, shape);
        }
        return this;
    }

    public ShapeSelector checkable(boolean checkable, @NonNull GradientDrawable shape) {
        if (checkable) {
            mSelector.addState(new int[]{android.R.attr.state_checkable}, shape);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_checkable}, shape);
        }
        return this;
    }

    public ShapeSelector focused(boolean focused, @NonNull GradientDrawable shape) {
        if (focused) {
            mSelector.addState(new int[]{android.R.attr.state_focused}, shape);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_focused}, shape);
        }
        return this;
    }

    public ShapeSelector windowFocused(boolean windowFocused, @NonNull GradientDrawable shape) {
        if (windowFocused) {
            mSelector.addState(new int[]{android.R.attr.state_window_focused}, shape);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_window_focused}, shape);
        }
        return this;
    }

    /**
     * 默认的Shape，放在最后生效
     */
    public ShapeSelector defaultShape(@NonNull GradientDrawable shape) {
        mSelector.addState(new int[]{}, shape);
        return this;
    }

    public StateListDrawable create() {
        return mSelector;
    }
}
