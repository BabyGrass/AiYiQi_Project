package com.aiyiqi.aiyiqi_project.decorateSchool.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.aiyiqi.aiyiqi_project.MainActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.decorateSchool.adapter.MyDecorateSchoolAdapter;
import com.finesdk.activity.BaseActivity;
import com.finesdk.util.common.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */

public class DecorateSchoolActivity extends BaseActivity {
    private ImageView decorate_school_back,decorate_school_more;
    private TabLayout decorate_school_title;
    private List<String> list;
    private ViewPager viewpager;
    private MyDecorateSchoolAdapter adapter;
    @Override
    public int getContentViewId() {
        return R.layout.activity_decorateschool;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        decorate_school_back = findViewByIdNoCast(R.id.decorate_school_back);
        decorate_school_more = findViewByIdNoCast(R.id.decorate_school_more);
        viewpager = findViewByIdNoCast(R.id.decorate_school_viewpager);
        decorate_school_title = findViewByIdNoCast(R.id.decorate_school_title);
    }

    @Override
    public void initData() {
        list = new ArrayList<>();
        list.add("验房收房");
        list.add("装修公司");
        list.add("量房设计");
        list.add("辅材选购");
        list.add("主材选购");
        list.add("家具选购");
        list.add("装修合同");
        list.add("主体拆迁");
        list.add("水电改造");
        list.add("防水处理");
        list.add("水木工程");
        list.add("瓦工工程");
        list.add("油工工程");
        list.add("安装主材");
        list.add("竣工验收");
        list.add("软件配装");
        list.add("居家生活");
        adapter = new MyDecorateSchoolAdapter(getSupportFragmentManager(),list);
        decorate_school_title.setupWithViewPager(viewpager);
        viewpager.setAdapter(adapter);
        setOnClick(decorate_school_back,decorate_school_more);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.decorate_school_back:
                IntentUtil.openActivity(DecorateSchoolActivity.this, MainActivity.class);
                break;
            case R.id.decorate_school_more:
//                IntentUtil.openActivity(DecorateSchoolActivity.this, MainActivity.class);
                break;
        }
    }
}
