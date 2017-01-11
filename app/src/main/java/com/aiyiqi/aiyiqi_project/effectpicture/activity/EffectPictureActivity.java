package com.aiyiqi.aiyiqi_project.effectpicture.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.aiyiqi.aiyiqi_project.MainActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.adapter.MyPagerAdapter;
import com.finesdk.activity.BaseActivity;
import com.finesdk.util.common.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class EffectPictureActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private View view1,view2;   //页卡视图
    private List<View> views;   //页卡视图集合
    private LayoutInflater inflater;
    private MyPagerAdapter adapter;
    private ImageView img_back;
    @Override
    public int getContentViewId() {
        return R.layout.activity_effect;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        tabLayout = findViewByIdNoCast(R.id.effect_tab);
        viewpager = findViewByIdNoCast(R.id.effect_viewpager);
        img_back = findViewByIdNoCast(R.id.effect_back);

    }

    @Override
    public void initData() {
        setOnClick(img_back);
        views = new ArrayList<>();
        inflater = LayoutInflater.from(this);
        view1 = inflater.inflate(R.layout.effect_zhuanti,null);
        view2 = inflater.inflate(R.layout.effect_meitu,null);
        views.add(view1);
        views.add(view2);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tabLayout.addTab(tabLayout.newTab().setText("专题"));
//        tabLayout.addTab(tabLayout.newTab().setText("美图"));

        adapter = new MyPagerAdapter(views);
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabsFromPagerAdapter(adapter);

        tabLayout.getTabAt(0).setText("专题");
        tabLayout.getTabAt(1).setText("美图");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.effect_back:
                IntentUtil.openActivity(EffectPictureActivity.this, MainActivity.class);
                break;
        }
    }
}
