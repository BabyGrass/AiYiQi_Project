package com.aiyiqi.aiyiqi_project.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.MainActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.finesdk.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {
    @Bind(R.id.search_edit_f)
    EditText searchEditF;
    @Bind(R.id.serch_deit_cancel)
    TextView serchDeitCancel;
    @Bind(R.id.search_title)
    LinearLayout searchTitle;
    @Bind(R.id.view)
    View view;

    @Override
    public int getContentViewId() {
        return R.layout.search_activity_layout;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.search_edit_f, R.id.serch_deit_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_edit_f://搜索
                break;
            case R.id.serch_deit_cancel://取消
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
