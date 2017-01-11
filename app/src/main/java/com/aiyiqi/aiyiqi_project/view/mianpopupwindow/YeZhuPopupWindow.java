package com.aiyiqi.aiyiqi_project.view.mianpopupwindow;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;

import butterknife.Bind;
import butterknife.OnClick;

public class YeZhuPopupWindow extends PopupWindow {

    @Bind(R.id.yezhu_fatie_tv)
    TextView yezhuFatieTv;
    @Bind(R.id.yezhu_shaidan_tv)
    TextView yezhuShaidanTv;
    @Bind(R.id.yezhu_riji_tv)
    TextView yezhuRijiTv;
    @Bind(R.id.yezhu_toushubiaoyan_tv)
    TextView yezhuToushubiaoyanTv;

    public YeZhuPopupWindow(Context context) {
        super(context);
        View view = View.inflate(context, R.layout.yezhu_popupwindow_layout, null);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);//设置窗口可弹出
        this.setAnimationStyle(R.style.mypopwindow_anim_style);
        this.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
    }

    @OnClick({R.id.yezhu_fatie_tv, R.id.yezhu_shaidan_tv, R.id.yezhu_riji_tv, R.id.yezhu_toushubiaoyan_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yezhu_fatie_tv://发帖
                break;
            case R.id.yezhu_shaidan_tv://晒单
                break;
            case R.id.yezhu_riji_tv://日记
                break;
            case R.id.yezhu_toushubiaoyan_tv://投诉和表扬
                break;
        }
    }
}
