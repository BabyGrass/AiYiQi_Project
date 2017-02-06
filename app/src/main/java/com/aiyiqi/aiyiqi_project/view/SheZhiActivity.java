package com.aiyiqi.aiyiqi_project.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.LoginActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.finesdk.activity.BaseActivity;

/**
 * Created by Administrator on 2017/1/8.
 */

public class SheZhiActivity extends BaseActivity {
    private ImageView shezhi_back_iv;
    private Button shezhi_login_button;
    @Override
    public int getContentViewId() {
        return R.layout.shezhi_activity_layout;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        shezhi_back_iv = findViewByIdNoCast(R.id.shezhi_back_iv);
        shezhi_login_button = findViewByIdNoCast(R.id.shezhi_login_button);
    }

    @Override
    public void initData() {
        setOnClick(shezhi_back_iv,shezhi_login_button);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.shezhi_back_iv:
                this.finish();
                break;
            case R.id.shezhi_login_button:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
