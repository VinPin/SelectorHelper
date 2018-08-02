package com.vinpin.selectorhelperdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vinpin.adapter.MultiItemTypeAdapter;
import com.vinpin.adapter.base.ItemViewDelegate;
import com.vinpin.adapter.base.ViewHolder;
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

    private static final int COUNT = 7;
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
            addItemViewDelegate(new ItemViewDelegate<Integer>() {
                @Override
                public int getItemViewLayoutId() {
                    return R.layout.item_shape_list;
                }

                @Override
                public boolean isForViewType(Integer item, int position) {
                    return item < COUNT;
                }

                @Override
                public void convert(ViewHolder holder, Integer item, int position) {
                    shapeHelperApiDemo(holder, item);
                }
            });
        }
    }

    private void shapeHelperApiDemo(ViewHolder holder, int item) {
        switch (item) {
            case 0:
                holder.setText(R.id.txt_1, "边角-填充");
                holder.getView(R.id.txt_1).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .cornerRadius(dp2px(5))
                                .create());
                holder.setText(R.id.txt_2, "边角-边框");
                holder.getView(R.id.txt_2).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary)
                                .cornerRadius(dp2px(5))
                                .create());
                holder.setText(R.id.txt_3, "边角-边框-虚线");
                holder.getView(R.id.txt_3).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary, dp2px(8), dp2px(4))
                                .cornerRadius(dp2px(5))
                                .create());
                break;
            case 1:
                holder.setText(R.id.txt_1, "圆角-填充");
                holder.getView(R.id.txt_1).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_2, "圆角-边框");
                holder.getView(R.id.txt_2).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary)
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_3, "圆角-边框-虚线");
                holder.getView(R.id.txt_3).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .stroke(dp2px(1), R.color.colorPrimary, dp2px(8), dp2px(4))
                                .cornerRadius(dp2px(20))
                                .create());
                break;
            case 2:
                holder.setText(R.id.txt_1, "圆角-边框");
                holder.getView(R.id.txt_1).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .stroke(dp2px(1), R.color.colorAccent)
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_2, "圆角-边框-虚线");
                holder.getView(R.id.txt_2).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .stroke(dp2px(1), R.color.colorAccent, dp2px(8), dp2px(4))
                                .cornerRadius(dp2px(20))
                                .create());
                holder.setText(R.id.txt_3, "边角-边框");
                holder.getView(R.id.txt_3).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .stroke(dp2px(1), R.color.colorPrimary)
                                .cornerRadius(dp2px(5))
                                .create());
                break;
            case 3:
                holder.setText(R.id.txt_1, "左上边角");
                holder.getView(R.id.txt_1).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .tlRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_2, "右上边角");
                holder.getView(R.id.txt_2).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .trRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_3, "左右上边角");
                holder.getView(R.id.txt_3).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .trRadius(dp2px(10))
                                .tlRadius(dp2px(10))
                                .create());
                break;
            case 4:
                holder.setText(R.id.txt_1, "左下边角");
                holder.getView(R.id.txt_1).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .blRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_2, "右下边角");
                holder.getView(R.id.txt_2).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .brRadius(dp2px(10))
                                .create());
                holder.setText(R.id.txt_3, "左右下边角");
                holder.getView(R.id.txt_3).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .solidColor(R.color.colorAccent)
                                .blRadius(dp2px(10))
                                .brRadius(dp2px(10))
                                .create());
                break;
            case 5:
                holder.setText(R.id.txt_1, "上下渐变");
                holder.getView(R.id.txt_1).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .gradient(new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                holder.setText(R.id.txt_2, "上下渐变边角");
                holder.getView(R.id.txt_2).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .cornerRadius(dp2px(5))
                                .gradient(new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                holder.setText(R.id.txt_3, "下上渐变");
                holder.getView(R.id.txt_3).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .gradient(ShapeHelper.BOTTOM_TOP, new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                break;
            case 6:
                holder.setText(R.id.txt_1, "左右渐变");
                holder.getView(R.id.txt_1).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .gradient(ShapeHelper.LEFT_RIGHT, new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                holder.setText(R.id.txt_2, "左右渐变边角");
                holder.getView(R.id.txt_2).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .cornerRadius(dp2px(5))
                                .gradient(ShapeHelper.LEFT_RIGHT, new int[]{R.color.colorAccent, R.color.colorPrimary})
                                .create());
                holder.setText(R.id.txt_3, "右左渐变");
                holder.getView(R.id.txt_3).setBackgroundDrawable(
                        ShapeHelper.getInstance()
                                .gradient(ShapeHelper.RIGHT_LEFT, new int[]{R.color.colorAccent, R.color.colorPrimary})
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
