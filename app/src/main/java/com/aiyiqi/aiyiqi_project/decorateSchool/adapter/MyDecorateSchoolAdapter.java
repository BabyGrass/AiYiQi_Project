package com.aiyiqi.aiyiqi_project.decorateSchool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aiyiqi.aiyiqi_project.decorateSchool.fragment.DecorateFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */
public class MyDecorateSchoolAdapter extends FragmentPagerAdapter{
    private List<String> list;
//    private String titles[] = {"验房收房","装修公司","量房设计","辅材选购","主材选购","家具选购","装修合同","主体拆迁","水电改造","防水处理","水木工程","瓦工工程","油工工程","安装主材","竣工验收","软件配装","居家生活"};
    public MyDecorateSchoolAdapter(FragmentManager fm, List<String> lists) {
        super(fm);
        this.list = lists;
    }

    @Override
    public Fragment getItem(int position) {
        DecorateFragment fragment = new DecorateFragment();
        fragment.setStage(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
