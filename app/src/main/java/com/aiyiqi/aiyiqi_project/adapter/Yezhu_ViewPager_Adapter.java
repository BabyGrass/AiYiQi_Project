package com.aiyiqi.aiyiqi_project.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class Yezhu_ViewPager_Adapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> datas;
    public Yezhu_ViewPager_Adapter(FragmentManager fm,List<Fragment> fragmentList,List<String> datas) {
        super(fm);
        this.fragmentList = fragmentList;
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList == null ? null :fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ?0:fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return datas.get(position % datas.size());
    }
}
