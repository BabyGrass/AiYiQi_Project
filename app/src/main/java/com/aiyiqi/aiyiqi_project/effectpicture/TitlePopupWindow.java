package com.aiyiqi.aiyiqi_project.effectpicture;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.adapter.MyPopAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class TitlePopupWindow extends PopupWindow {
    private List<String> list;
    private LayoutInflater inflater;
    private RecyclerView pop_recycler;
    private View view;
    private MyPopAdapter adapter;
    private Context context;
    private String str;
    private PopItemCallBack mCallBack;

    public TitlePopupWindow(Context context) {
        super(context);
        //布局渲染器
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //设置布局
        view = View.inflate(context, R.layout.meitu_pop, null);
        this.setContentView(view);
        //设置宽高
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        this.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        //设置聚焦点
        this.setFocusable(true);
        this.setFocusable(true);
        //设置外部点击
        this.setOutsideTouchable(true);
        //刷新状态
        this.update();
        //软键盘输入
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //设置背景
        this.setBackgroundDrawable(new BitmapDrawable());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        initView();
        initData();
    }

    /**
     * View初始化
     */
    public void initView() {
        pop_recycler = (RecyclerView) view.findViewById(R.id.pop_recycler);

    }

    /**
     * 数据初始化
     */
    private void initData() {
        list = new ArrayList<>();

        GridLayoutManager layoutManager = new GridLayoutManager(context, 4);
        pop_recycler.setLayoutManager(layoutManager);
        adapter = new MyPopAdapter(list);
        pop_recycler.setAdapter(adapter);
        adapter.setClickListener(new MyPopAdapter.OnItemClickListener() {
            @Override
            public void itemClickListener(int position, View view) {
                TextView pop_tv = (TextView) view.findViewById(R.id.pop_tv);
                pop_tv.setTextColor(Color.WHITE);
                pop_tv.setBackgroundColor(Color.parseColor("#00CC00"));
                str = pop_tv.getText().toString();
                dismiss();

            }
        });

    }

    /**
     * 显示PopupWindow在哪个位置下方
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, parent.getLayoutParams().width, 0);
        } else {
            this.dismiss();
        }
    }

    /**
     * 设置数据
     *
     * @param list
     */
    public void setlistData1(List<String> list) {
        if (list != null) {
            adapter.addData(list);
        }
        adapter.notifyDataSetChanged();
    }
    public void setlistData2(List<String> list) {
        if (list != null) {
            adapter.addData(list);
        }
        adapter.notifyDataSetChanged();
    }
    public void setlistData3(List<String> list) {
        if (list != null) {
            adapter.addData(list);
        }
        adapter.notifyDataSetChanged();
    }
    public void setlistData4(List<String> list) {
        if (list != null) {
            adapter.addData(list);
        }
        adapter.notifyDataSetChanged();
    }
    public String getCallBackString(){
        return str;
    }
    public interface PopItemCallBack{
        void popItemCallBack(String result);
    }

}
