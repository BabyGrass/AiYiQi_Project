package com.aiyiqi.aiyiqi_project.decorate_budget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aiyiqi.aiyiqi_project.framework.utils.utils.BudgetUrl;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.ShejiUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class BudgetViewPagerAdapter extends FragmentPagerAdapter {
    private List<FragmentViewpager> fragments;
    public BudgetViewPagerAdapter(FragmentManager fm,boolean isBudget) {
        super(fm);
        fragments = new ArrayList<>();
        if (isBudget){
            fragments.add(new FragmentViewpager(BudgetUrl.DECORATION_BUDGET));
            fragments.add(new FragmentViewpager(null));
        }else {
            fragments.add(new FragmentViewpager(ShejiUrl.FREE_DESIGN));
            fragments.add(new FragmentViewpager(ShejiUrl.FREE_MEASURE));
        }

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
