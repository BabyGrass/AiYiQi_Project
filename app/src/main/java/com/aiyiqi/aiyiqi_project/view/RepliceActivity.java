package com.aiyiqi.aiyiqi_project.view;


import android.app.Dialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.finesdk.activity.BaseActivity;


public class RepliceActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout picture_chose_layout;
    private EditText replice_back_deit;
    private TextView finish_repilce_tiezi,replice_back;
    /**
     * dialog
     */
    private Dialog dialog;
    private View inflate;
    private TextView carame_textview,photo_textview,cancle_dialog_textview;
    @Override
    public int getContentViewId() {
        return R.layout.replice_activity_layout;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        picture_chose_layout = (LinearLayout) findViewById(R.id.picture_chose_layout);
        replice_back_deit = (EditText) findViewById(R.id.replice_back_deit);
        finish_repilce_tiezi = (TextView) findViewById(R.id.finish_repilce_tiezi);
        replice_back = (TextView) findViewById(R.id.replice_back);
        picture_chose_layout.setOnClickListener(this);
        finish_repilce_tiezi.setOnClickListener(this);
        replice_back.setOnClickListener(this);
    }

    @Override
    public void initData() {
    }



    public void showDialogP(){
        dialog = new Dialog(this,R.style.photoDialog);
        inflate = LayoutInflater.from(this).inflate(R.layout.picture_dialog_layout, null);
        dialog.setContentView(inflate);
        carame_textview = (TextView) inflate.findViewById(R.id.carame_textview);
        photo_textview = (TextView) inflate.findViewById(R.id.photo_textview);
        cancle_dialog_textview = (TextView) inflate.findViewById(R.id.cancle_dialog_textview);
        carame_textview.setOnClickListener(this);
        photo_textview.setOnClickListener(this);
        cancle_dialog_textview.setOnClickListener(this);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity( Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(true);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.picture_chose_layout://选择图片
                showDialogP();
                break;
            case R.id.finish_repilce_tiezi://完成
                break;
            case R.id.replice_back://返回
                this.finish();
                break;
            case R.id.carame_textview://相机
                break;
            case R.id.photo_textview://相册
                break;
            case R.id.cancle_dialog_textview://取消Dialog
                dialog.dismiss();
                break;
        }
    }
}
