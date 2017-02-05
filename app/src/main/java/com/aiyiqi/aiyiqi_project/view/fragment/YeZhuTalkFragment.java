package com.aiyiqi.aiyiqi_project.view.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.adapter.Yezhu_ViewPager_Adapter;
import com.aiyiqi.aiyiqi_project.view.SearchActivity;
import com.aiyiqi.aiyiqi_project.view.fragment.yezhutalkfragment.BanKuaiFragment;
import com.aiyiqi.aiyiqi_project.view.fragment.yezhutalkfragment.JinhuaFragment;
import com.aiyiqi.aiyiqi_project.view.fragment.yezhutalkfragment.NewFragment;
import com.finesdk.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 业主说
 */

public class YeZhuTalkFragment extends BaseFragment implements View.OnClickListener{
    @Bind(R.id.yezhu_fragment_popiv)
    ImageView yezhuFragmentPopiv;
    private ImageView yezhu_fragment_search_iv;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //ViewPager适配器
    private Yezhu_ViewPager_Adapter adapter;
    private List<Fragment> fragmentList = null;//Fragment集合
    private List<String> datas = null;//TabLayout的数据集合
    //Fragment
    private JinhuaFragment jinhuaFragment;
    private NewFragment newFragment;
    private BanKuaiFragment banKuaiFragment;
    //显示Dialog
    private Dialog dialog;
    private View inflater;
    private TextView yezhu_fatie_tv,yezhu_shaidan_tv,yezhu_riji_tv,yezhu_toushubiaoyan_tv;
    @Override
    protected int getResource() {
        return R.layout.yezhu_fragment_layout;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        yezhu_fragment_search_iv = findViewByIdNoCast(R.id.yezhu_fragment_search_iv);
        tabLayout = findViewByIdNoCast(R.id.tablayout);
        viewPager = findViewByIdNoCast(R.id.viewPager);
        setOnClick(yezhu_fragment_search_iv);
    }

    @Override
    protected void initData() {
        if (jinhuaFragment == null) {
            jinhuaFragment = new JinhuaFragment();
        }
        if (newFragment == null) {
            newFragment = new NewFragment();
        }
        if (banKuaiFragment == null) {
            banKuaiFragment = new BanKuaiFragment();
        }
        /**
         * 把Frgment添加到集合
         */
        fragmentList = new ArrayList<>();
        fragmentList.add(jinhuaFragment);
        fragmentList.add(newFragment);
        fragmentList.add(banKuaiFragment);

        /**
         * 添加TabLayout的数据集合
         */
        datas = new ArrayList<>();
        datas.add("精华");
        datas.add("最新");
        datas.add("板块");
        /**
         * 添加到TabLayout
         */
        tabLayout.addTab(tabLayout.newTab().setText(datas.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(datas.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(datas.get(2)));

        adapter = new Yezhu_ViewPager_Adapter(getActivity().getSupportFragmentManager(), fragmentList, datas);
        //viewPager加载Fragment
        viewPager.setAdapter(adapter);
        //TabLayout加载Viewpager
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yezhu_fragment_search_iv:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.yezhu_fatie_tv://发帖
                break;
            case R.id.yezhu_shaidan_tv://晒单
                break;
            case R.id.yezhu_riji_tv://日记
                break;
            case R.id.yezhu_toushubiaoyan_tv://投诉表扬
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
private boolean isClick = true;//默认没有点击
    @OnClick(R.id.yezhu_fragment_popiv)//点击弹出popWindow
    public void onClick() {

        if(isClick){//点击
            showDialog();
            yezhuFragmentPopiv.setImageResource(R.drawable.float_layer_menu_close);
            isClick = false;
        }
        else{
            dialog.dismiss();
            yezhuFragmentPopiv.setImageResource(R.drawable.float_layer_menu_normal);
            isClick = true;
        }

    }

    /**
     * 显示Dialog的方法
     */
    public void showDialog(){
        dialog = new Dialog(getActivity(),R.style.FullScreenDialog);
        inflater = LayoutInflater.from(getActivity()).inflate(R.layout.yezhu_popupwindow_layout,null);
        dialog.setContentView(inflater);
        yezhu_fatie_tv = (TextView) inflater.findViewById(R.id.yezhu_fatie_tv);
        yezhu_shaidan_tv = (TextView) inflater.findViewById(R.id.yezhu_shaidan_tv);
        yezhu_riji_tv = (TextView) inflater.findViewById(R.id.yezhu_riji_tv);
        yezhu_toushubiaoyan_tv = (TextView) inflater.findViewById(R.id.yezhu_toushubiaoyan_tv);
        yezhu_fatie_tv.setOnClickListener(this);
        yezhu_shaidan_tv.setOnClickListener(this);
        yezhu_riji_tv.setOnClickListener(this);
        yezhu_toushubiaoyan_tv.setOnClickListener(this);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.show();

    }


}
