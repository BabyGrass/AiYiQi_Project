package com.aiyiqi.aiyiqi_project.design_amountofroom;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.decorate_budget.BudgetViewPagerAdapter;
import com.aiyiqi.aiyiqi_project.decorate_budget.LineView;
import com.finesdk.activity.BaseActivity;

/**
 * Created by Administrator on 2017/1/5.
 */

public class DesignActivity extends BaseActivity {
    private CheckedTextView title_back,title_budget,title_price;
    private ImageView title_phoneimg;
    private FragmentManager fm;
    private ViewPager viewPager;
    private BudgetViewPagerAdapter adapter;
    private LineView myViewLine;
    private RelativeLayout bottom;
    private RelativeLayout bottm_order,bottm_answer;
    @Override
    public int getContentViewId() {
        return R.layout.budget_activity;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        title_back = findViewByIdNoCast(R.id.title_backimg);
        title_price = findViewByIdNoCast(R.id.title_price);
        title_budget = findViewByIdNoCast(R.id.title_budget);
        viewPager = findViewByIdNoCast(R.id.budget_viewPager);
        myViewLine = findViewByIdNoCast(R.id.title_myViewLine);
        title_phoneimg = findViewByIdNoCast(R.id.title_phone);
        bottom = findViewByIdNoCast(R.id.bottm_rl);
        bottm_order = findViewByIdNoCast(R.id.bottm_order);
        bottm_answer = findViewByIdNoCast(R.id.bottm_answer);
    }

    @Override
    public void initData() {
        title_price.setText("免费计量");
        title_budget.setText("免费量房");
        title_phoneimg.setVisibility(View.VISIBLE);
        bottom.setVisibility(View.VISIBLE);
        fm = getSupportFragmentManager();
        adapter = new BudgetViewPagerAdapter(fm,false);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int width = myViewLine.getWidth()/2;
                myViewLine.smoothScrollTo(-width*position, 0);
                switch (position) {
                    case 0:
                        title_price.setChecked(true);
                        title_budget.setChecked(false);
                        break;
                    case 1:
                        title_price.setChecked(false);
                        title_budget.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setOnClick(title_back,title_budget,title_price,title_phoneimg,bottm_order,bottm_answer);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_backimg:
                finish();
                break;
            case R.id.title_price:
                viewPager.setCurrentItem(0);
                break;
            case R.id.title_budget:
                viewPager.setCurrentItem(1);
                break;
            case R.id.title_phone:
                //跳转拨打客服电话
                break;
            case R.id.bottm_order:
                //跳转到登录界面
                break;
            case R.id.bottm_answer:
                //跳转到客服发短信
                break;
        }
    }
}
