package com.aiyiqi.aiyiqi_project.view.detailactivity;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aiyiqi.aiyiqi_project.R;

public class MyDialog extends Dialog implements View.OnClickListener{
    private Button queren,cancle;
    private View.OnClickListener onClickListener;

    public MyDialog(Context context,int theme,View.OnClickListener onClickListener) {
        super(context,theme);
        this.onClickListener = onClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.mydialog_layout);
        //点击空白处取消Dialog
        setCanceledOnTouchOutside(true);
        queren = (Button) findViewById(R.id.queren_button);
        cancle = (Button) findViewById(R.id.cancle_button);
        queren.setOnClickListener(this);
        cancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.queren_button://取消
                onClickListener.onClick(v);
                break;
            case R.id.cancle_button://确定
                onClickListener.onClick(v);
                break;
        }
    }
}
