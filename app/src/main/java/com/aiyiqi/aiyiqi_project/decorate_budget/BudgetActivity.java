package com.aiyiqi.aiyiqi_project.decorate_budget;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckedTextView;
import com.aiyiqi.aiyiqi_project.R;
import com.finesdk.activity.BaseActivity;

/**
 * Created by Administrator on 2017/1/4.
 */

public class BudgetActivity extends BaseActivity {
    private CheckedTextView title_back,title_budget,title_price;
    private FragmentManager fm;
    private ViewPager viewPager;
    private BudgetViewPagerAdapter adapter;
    private LineView myViewLine;
    private FragmentViewpager fragment;
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
    }

    @Override
    public void initData() {
        fm = getSupportFragmentManager();
        adapter = new BudgetViewPagerAdapter(fm,true);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                fragment = (FragmentViewpager) adapter.getItem(position);
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

        setOnClick(title_back,title_budget,title_price);
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
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        WebView webView = fragment.getWebView();
        if ((keyCode == KeyEvent.KEYCODE_BACK) &&  webView .canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
