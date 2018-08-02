package com.vinpin.selectorhelper;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/02 11:23
 *     desc  : Drawable类型选择器
 * </pre>
 */
@SuppressWarnings("unused")
public class DrawableSelector {

    private StateListDrawable mSelector;

    private DrawableSelector() {
        mSelector = new StateListDrawable();
    }

    public static DrawableSelector getInstance() {
        return new DrawableSelector();
    }

    public DrawableSelector enabled(boolean enabled, @DrawableRes int drawableRes) {
        if (enabled) {
            mSelector.addState(new int[]{android.R.attr.state_enabled},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_enabled},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        }
        return this;
    }

    public DrawableSelector enabled(boolean enabled, @NonNull Drawable drawable) {
        if (enabled) {
            mSelector.addState(new int[]{android.R.attr.state_enabled}, drawable);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_enabled}, drawable);
        }
        return this;
    }

    public DrawableSelector pressed(boolean pressed, @DrawableRes int drawableRes) {
        if (pressed) {
            mSelector.addState(new int[]{android.R.attr.state_pressed},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_pressed},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        }
        return this;
    }

    public DrawableSelector pressed(boolean pressed, @NonNull Drawable drawable) {
        if (pressed) {
            mSelector.addState(new int[]{android.R.attr.state_pressed}, drawable);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_pressed}, drawable);
        }
        return this;
    }

    public DrawableSelector selected(boolean selected, @DrawableRes int drawableRes) {
        if (selected) {
            mSelector.addState(new int[]{android.R.attr.state_selected},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_selected},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        }
        return this;
    }

    public DrawableSelector selected(boolean selected, @NonNull Drawable drawable) {
        if (selected) {
            mSelector.addState(new int[]{android.R.attr.state_selected}, drawable);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_selected}, drawable);
        }
        return this;
    }

    public DrawableSelector checked(boolean checked, @DrawableRes int drawableRes) {
        if (checked) {
            mSelector.addState(new int[]{android.R.attr.state_checked},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_checked},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        }
        return this;
    }

    public DrawableSelector checked(boolean checked, @NonNull Drawable drawable) {
        if (checked) {
            mSelector.addState(new int[]{android.R.attr.state_checked}, drawable);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_checked}, drawable);
        }
        return this;
    }

    public DrawableSelector checkable(boolean checkable, @DrawableRes int drawableRes) {
        if (checkable) {
            mSelector.addState(new int[]{android.R.attr.state_checkable},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_checkable},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        }
        return this;
    }

    public DrawableSelector checkable(boolean checkable, @NonNull Drawable drawable) {
        if (checkable) {
            mSelector.addState(new int[]{android.R.attr.state_checkable}, drawable);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_checkable}, drawable);
        }
        return this;
    }

    public DrawableSelector focused(boolean focused, @DrawableRes int drawableRes) {
        if (focused) {
            mSelector.addState(new int[]{android.R.attr.state_focused},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_focused},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        }
        return this;
    }

    public DrawableSelector focused(boolean focused, @NonNull Drawable drawable) {
        if (focused) {
            mSelector.addState(new int[]{android.R.attr.state_focused}, drawable);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_focused}, drawable);
        }
        return this;
    }

    public DrawableSelector windowFocused(boolean windowFocused, @DrawableRes int drawableRes) {
        if (windowFocused) {
            mSelector.addState(new int[]{android.R.attr.state_window_focused},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_window_focused},
                    ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        }
        return this;
    }

    public DrawableSelector windowFocused(boolean windowFocused, @NonNull Drawable drawable) {
        if (windowFocused) {
            mSelector.addState(new int[]{android.R.attr.state_window_focused}, drawable);
        } else {
            mSelector.addState(new int[]{-android.R.attr.state_window_focused}, drawable);
        }
        return this;
    }

    public DrawableSelector defaultDrawable(@DrawableRes int drawableRes) {
        mSelector.addState(new int[]{}, ContextCompat.getDrawable(SelectorHelper.getContext(), drawableRes));
        return this;
    }

    public DrawableSelector defaultDrawable(@NonNull Drawable drawable) {
        mSelector.addState(new int[]{}, drawable);
        return this;
    }

    public StateListDrawable create() {
        return mSelector;
    }
}
