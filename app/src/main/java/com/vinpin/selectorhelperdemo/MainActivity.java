package com.vinpin.selectorhelperdemo;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vinpin.adapter.MultiItemTypeAdapter;
import com.vinpin.adapter.base.ItemViewDelegate;
import com.vinpin.adapter.base.ViewHolder;
import com.vinpin.selectorhelper.SelectorHelper;
import com.vinpin.selectorhelper.ShapeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: vinpin
 *     time  : 2018/08/02 13:55
 *     desc  : 主界面
 * </pre>
 */
public class MainActivity extends AppCompatActivity {

    private static final int COUNT = 11;
    private RecyclerView recyclerView;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        getData(savedInstanceState);
    }

    public void findViewById() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    public void getData(@Nullable Bundle savedInstanceState) {
        ArrayList<Integer> infos = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            infos.add(i);
        }
        if (mAdapter == null) {
            mAdapter = new MainAdapter(this, infos);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    class MainAdapter extends MultiItemTypeAdapter<Integer> {

        public MainAdapter(Context context, List<Integer> datas) {
            super(context, datas);
            // 矩形
            addItemViewDelegate(new ItemViewDelegate<Integer>() {
                @Override
                public int getItemViewLayoutId() {
                    return R.layout.item_shape_list;
                }

                @Override
                public boolean isForViewType(Integer item, int position) {
                    return item < 7;
                }

                @Override
                public void convert(ViewHolder holder, Integer item, int position) {
                    shapeHelperApi(holder, item);
                }
            });
            // 圆形
            addItemViewDelegate(new ItemViewDelegate<Integer>() {
                @Override
                public int getItemViewLayoutId() {
                    return R.layout.item_shape_oval_list;
                }

                @Override
                public boolean isForViewType(Integer item, int position) {
                    return item == 7;
                }

                @Override
                public void convert(ViewHolder holder, Integer item, int position) {
                    shapeHelperApi(holder, item);
                }
            });
            // ShapeSelector
            addItemViewDelegate(new ItemViewDelegate<Integer>() {
                @Override
                public int getItemViewLayoutId() {
                    return R.layout.item_shape_list;
                }

                @Override
                public boolean isForViewType(Integer item, int position) {
                    return item == 8;
                }

                @Override
                public void convert(ViewHolder holder, Integer item, int position) {
                    shapeSelectorApi(holder, item);
                }
            });
            // ColorSelector
            addItemViewDelegate(new ItemViewDelegate<Integer>() {
                @Override
                public int getItemViewLayoutId() {
                    return R.layout.item_color_list;
                }

                @Override
                public boolean isForViewType(Integer item, int position) {
                    return item == 9;
                }

                @Override
                public void convert(ViewHolder holder, Integer item, int position) {
                    colorSelectorApi(holder, item);
                }
            });
            // DrawableSelector
            addItemViewDelegate(new ItemViewDelegate<Integer>() {
                @Override
                public int getItemViewLayoutId() {
                    return R.layout.item_color_list;
                }

                @Override
                public boolean isForViewType(Integer item, int position) {
                    return item == 10;
                }

                @Override
                public void convert(ViewHolder holder, Integer item, int position) {
                    drawableSelectorApi(holder, item);
                }
            });
        }
    }

    private void shapeHelperApi(ViewHolder holder, int item) {
        switch (item) {
            case 0:
                holder.setText(R.id.txt_1, "边角-填充");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .cornerRadius(dp2px(5))
                                .create());
                holder.setText(R.id.txt_2, "边角-边框");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary)
                                .cornerRadius(dp2px(5))
                                .create());
                holder.setText(R.id.txt_3, "边角-边框-虚线");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary, dp2px(8), dp2px(4))
                                .cornerRadius(dp2px(5))
                                .create());
                break;
            case 1:
                holder.setText(R.id.txt_1, "圆角-填充");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_2, "圆角-边框");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary)
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_3, "圆角-边框-虚线");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary, dp2px(8), dp2px(4))
                                .cornerRadius(dp2px(20))
                                .create());
                break;
            case 2:
                holder.setText(R.id.txt_1, "圆角-边框");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .stroke(dp2px(1), R.color.colorAccent)
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_2, "圆角-边框-虚线");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .stroke(dp2px(1), R.color.colorAccent, dp2px(8), dp2px(4))
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_3, "边角-边框");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .stroke(dp2px(1), R.color.colorPrimary)
                                .cornerRadius(dp2px(5))
                                .create());
                break;
            case 3:
                holder.setText(R.id.txt_1, "左上边角");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .tlRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_2, "左右上边角");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .tlRadius(dp2px(10))
                                .trRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_3, "右上边角");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .trRadius(dp2px(10))
                                .create());
                break;
            case 4:
                holder.setText(R.id.txt_1, "左下边角");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .blRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_2, "左右下边角");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .blRadius(dp2px(10))
                                .brRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_3, "右下边角");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .brRadius(dp2px(10))
                                .create());
                break;
            case 5:
                holder.setText(R.id.txt_1, "上下渐变");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .gradient(new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                holder.setText(R.id.txt_2, "上下渐变边角");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .cornerRadius(dp2px(5))
                                .gradient(new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                holder.setText(R.id.txt_3, "下上渐变");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .gradient(ShapeHelper.BOTTOM_TOP, R.color.colorAccent, R.color.colorPrimary)
                                .create());
                break;
            case 6:
                holder.setText(R.id.txt_1, "左右渐变");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .gradient(ShapeHelper.LEFT_RIGHT, R.color.colorAccent, R.color.colorPrimary)
                                .create());
                holder.setText(R.id.txt_2, "左右渐变边角");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .cornerRadius(dp2px(5))
                                .gradient(ShapeHelper.LEFT_RIGHT, R.color.colorAccent, R.color.colorPrimary)
                                .create());
                holder.setText(R.id.txt_3, "右左渐变");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .gradient(ShapeHelper.RIGHT_LEFT, new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                break;
            case 7:
                holder.setText(R.id.txt_1, "圆形-填充");
                holder.getView(R.id.txt_1).setBackground(
                        ShapeHelper.getInstance()
                                .shape(GradientDrawable.OVAL)
                                .solidColor(R.color.colorAccent)
                                .create());
                holder.setText(R.id.txt_2, "扫描-渐变");
                holder.getView(R.id.txt_2).setBackground(
                        ShapeHelper.getInstance()
                                .shape(GradientDrawable.OVAL)
                                .gradientSweep(R.color.colorAccent, R.color.colorPrimary)
                                .create());
                holder.setText(R.id.txt_3, "辐射-渐变");
                holder.getView(R.id.txt_3).setBackground(
                        ShapeHelper.getInstance()
                                .shape(GradientDrawable.OVAL)
                                .gradientRadial(dp2px(30), new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                break;
            default:
                break;
        }
    }

    private void shapeSelectorApi(ViewHolder holder, int item) {
        switch (item) {
            case 8:
                holder.setText(R.id.txt_1, "边角填充触摸");
                holder.getView(R.id.txt_1).setClickable(true);
                holder.getView(R.id.txt_1).setBackground(
                        SelectorHelper.shapeSelector()
                                .pressed(true, ShapeHelper.getInstance()
                                        .solidColor(R.color.colorPrimary)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .defaultShape(ShapeHelper.getInstance()
                                        .solidColor(R.color.colorAccent)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .create());
                holder.setText(R.id.txt_2, "圆角触摸");
                holder.getView(R.id.txt_2).setClickable(true);
                holder.getView(R.id.txt_2).setBackground(
                        SelectorHelper.shapeSelector()
                                .pressed(true, ShapeHelper.getInstance()
                                        .stroke(dp2px(1), R.color.colorPrimary)
                                        .cornerRadius(dp2px(20))
                                        .create())
                                .defaultShape(ShapeHelper.getInstance()
                                        .stroke(dp2px(1), R.color.colorAccent)
                                        .cornerRadius(dp2px(20))
                                        .create())
                                .create());
                holder.setText(R.id.txt_3, "边角触摸");
                holder.getView(R.id.txt_3).setClickable(true);
                holder.getView(R.id.txt_3).setBackground(
                        SelectorHelper.shapeSelector()
                                .pressed(true, ShapeHelper.getInstance()
                                        .stroke(dp2px(1), R.color.colorPrimary)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .defaultShape(ShapeHelper.getInstance()
                                        .stroke(dp2px(1), R.color.colorAccent)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .create());
                break;
            default:
                break;
        }
    }

    private void colorSelectorApi(ViewHolder holder, int item) {
        switch (item) {
            case 9:
                holder.setText(R.id.txt_1, "不可用状态");
                TextView txt1 = holder.getView(R.id.txt_1);
                txt1.setTextColor(SelectorHelper.colorSelector()
                        .enabled(false, "#9B9B9B")
                        .defaultColor(R.color.colorAccent)
                        .create());
                txt1.setEnabled(false);
                holder.setText(R.id.txt_2, "触摸改变字体颜色");
                TextView txt2 = holder.getView(R.id.txt_2);
                txt2.setClickable(true);
                txt2.setTextColor(SelectorHelper.colorSelector()
                        .pressed(true, R.color.colorPrimary)
                        .defaultColor(R.color.colorAccent)
                        .create());
                holder.setText(R.id.txt_3, "选中改变字体颜色");
                final CheckBox txt3 = holder.getView(R.id.txt_3);
                txt3.setTextColor(SelectorHelper.colorSelector()
                        .checked(true, R.color.colorPrimary)
                        .defaultColor(R.color.colorAccent)
                        .create());
                break;
            default:
                break;
        }
    }

    private void drawableSelectorApi(ViewHolder holder, int item) {
        switch (item) {
            case 10:
                holder.setText(R.id.txt_1, "不可用状态");
                holder.getView(R.id.txt_1).setBackground(
                        SelectorHelper.drawableSelector()
                                .enabled(false, ShapeHelper.getInstance()
                                        .solidColor("#9B9B9B")
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .defaultDrawable(ShapeHelper.getInstance()
                                        .solidColor(R.color.colorAccent)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .create());
                holder.getView(R.id.txt_1).setEnabled(false);
                holder.setText(R.id.txt_2, "触摸改变背景");
                holder.getView(R.id.txt_2).setClickable(true);
                holder.getView(R.id.txt_2).setBackground(
                        SelectorHelper.drawableSelector()
                                .pressed(true, ShapeHelper.getInstance()
                                        .solidColor(R.color.colorPrimary)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .defaultDrawable(ShapeHelper.getInstance()
                                        .solidColor(R.color.colorAccent)
                                        .cornerRadius(dp2px(5))
                                        .create())
                                .create());
                holder.setText(R.id.txt_3, "选中改变背景");
                final CheckBox txt3 = holder.getView(R.id.txt_3);
                txt3.setBackground(SelectorHelper.drawableSelector()
                        .checked(true, ShapeHelper.getInstance()
                                .solidColor(R.color.colorPrimary)
                                .cornerRadius(dp2px(5))
                                .create())
                        .defaultDrawable(ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .cornerRadius(dp2px(5))
                                .create())
                        .create());
                break;
            default:
                break;
        }
    }

    private int dp2px(int dpValue) {
        float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
