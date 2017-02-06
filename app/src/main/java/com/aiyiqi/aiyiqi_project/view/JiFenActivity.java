package com.aiyiqi.aiyiqi_project.view;

import android.view.View;
import android.widget.ImageView;

import com.aiyiqi.aiyiqi_project.R;
import com.finesdk.activity.BaseActivity;

/**
 * Created by Administrator on 2017/1/8.
 */

public class JiFenActivity extends BaseActivity {
    private ImageView jifen_back_iv;
    @Override
    public int getContentViewId() {
        return R.layout.jifen_activity_layout;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        jifen_back_iv = findViewByIdNoCast(R.id.jifen_back_iv);
    }

    @Override
    public void initData() {
        setOnClick(jifen_back_iv);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.jifen_back_iv:
                this.finish();
                break;
        }
    }
}
