package com.aiyiqi.aiyiqi_project.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.LoginActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.view.JiFenActivity;
import com.aiyiqi.aiyiqi_project.view.SheZhiActivity;
import com.aiyiqi.aiyiqi_project.view.fragment.yezhutalkfragment.JinhuaFragment;
import com.finesdk.fragment.BaseFragment;

/**
 * 我的
 */


public class MineFragment extends BaseFragment{
    private RelativeLayout denglu_rl;//登陆
    private TextView jifen_guize;//积分规则
    private RelativeLayout my_shezhi_rl;//设置
    @Override
    protected int getResource() {
        return R.layout.main_msg_fragment_layout;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        denglu_rl = findViewByIdNoCast(R.id.denglu_rl);
        jifen_guize = findViewByIdNoCast(R.id.jifen_guize);
        my_shezhi_rl = findViewByIdNoCast(R.id.my_shezhi_rl);
    }

    @Override
    protected void initData() {
        setOnClick(denglu_rl,jifen_guize,my_shezhi_rl);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.denglu_rl:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.jifen_guize:
                startActivity(new Intent(getActivity(),JiFenActivity.class));
                break;
            case R.id.my_shezhi_rl:
                startActivity(new Intent(getActivity(), SheZhiActivity.class));
                break;
        }
    }
}
