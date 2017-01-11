package com.aiyiqi.aiyiqi_project.view.detailactivity;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.finesdk.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ViewPager详情页面
 */
public class ViewPagerDetailActivity extends BaseActivity {
    private WebView viewpagerWebview;
    @Bind(R.id.xianqing_back_tv)
    TextView xianqingBackTv;
    @Bind(R.id.viewpager_detail_share_imageview)
    ImageView viewpagerDetailShareImageview;
//    @Bind(R.id.viewpager_webview)
//    WebView viewpagerWebview;
    @Bind(R.id.detail_bottom_left_iv)
    ImageView detailBottomLeftIv;
    @Bind(R.id.detail_bottom_right_iv)
    ImageView detailBottomRightIv;
    @Bind(R.id.detail_bottom_refresh_iv)
    ImageView detailBottomRefreshIv;
    @Bind(R.id.detail_bottom)
    LinearLayout detailBottom;
  // private ViewPagerImageUrl.DataBean dataBean;
    private String sUrl;

    @Override
    public int getContentViewId() {
        return R.layout.viewpager_detail_activity_layout;
    }

    @Override
    public void beforeInitView() {
       sUrl = this.getIntent().getStringExtra("viewPagerDetial");
    }

    @Override
    public void initView() {
        viewpagerWebview = findViewByIdNoCast(R.id.viewpager_webview);
    }

    @Override
    public void initData() {
        //设置WebView属性，能够执行JavaScript脚本
        viewpagerWebview.getSettings().setJavaScriptEnabled(true);
        //设置全屏
        viewpagerWebview.getSettings().setLoadWithOverviewMode(true);
        //优先使用缓存
        viewpagerWebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //设置支持H5标签
        viewpagerWebview.getSettings().setDomStorageEnabled(true);
        if(sUrl != null){
            viewpagerWebview.loadUrl(sUrl);
        }
        viewpagerWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.xianqing_back_tv, R.id.viewpager_detail_share_imageview,
            R.id.detail_bottom_left_iv, R.id.detail_bottom_right_iv, R.id.detail_bottom_refresh_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.xianqing_back_tv://返回
                this.finish();
                break;
            case R.id.viewpager_detail_share_imageview://分享
                break;
            case R.id.detail_bottom_left_iv://左边的按钮
                break;
            case R.id.detail_bottom_right_iv://右边的按钮
                break;
            case R.id.detail_bottom_refresh_iv://刷新
                viewpagerWebview.reload();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (viewpagerWebview.canGoBack()) {
                viewpagerWebview.goBack();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
