package com.aiyiqi.aiyiqi_project.effectpicture.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.aiyiqi.aiyiqi_project.MainActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.adapter.MyPagerAdapter;
import com.aiyiqi.aiyiqi_project.effectpicture.fragment.FeaturesFragment;
import com.aiyiqi.aiyiqi_project.effectpicture.fragment.PrettyFragment;
import com.finesdk.activity.BaseActivity;
import com.finesdk.util.common.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class EffectPictureActivity extends BaseActivity {
    private List<Fragment> fragments;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private ImageView effect_back;
    private MyPagerAdapter adapter;
    @Override
    public int getContentViewId() {
        return R.layout.activity_effect;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        viewpager = findViewByIdNoCast(R.id.effect_viewpager);
        tabLayout = findViewByIdNoCast(R.id.effect_tab);
        effect_back = findViewByIdNoCast(R.id.effect_back);
    }

    @Override
    public void initData() {
        setOnClick(effect_back);
        fragments = new ArrayList<>();
        fragments.add(new FeaturesFragment());
        fragments.add(new PrettyFragment());

        adapter = new MyPagerAdapter(getSupportFragmentManager(),fragments);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.effect_back:
                IntentUtil.openActivity(this, MainActivity.class);
                break;
        }
    }
}
