package com.aiyiqi.aiyiqi_project.city.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.city.entity.CityEntity;
import com.finesdk.activity.BaseActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */

public class DetailActivity extends BaseActivity {
    private WebView webView;
    private ImageView city_img_title_back;
    private List<CityEntity.DataBean.ForumlistBean> forumlistBeenList;

    @Override
    public int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        webView = findViewByIdNoCast(R.id.detail_webview);
        city_img_title_back = findViewByIdNoCast(R.id.city_img_title_back);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        setOnClick(city_img_title_back);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE|WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void initData() {
        String urls = getIntent().getStringExtra("url");
        webView.loadUrl(urls);
        loading(webView);
        WebSettings settings = webView.getSettings();
        //支持JS，默认为不支持
        settings.setJavaScriptEnabled(true);
        //开启缓存
        settings.setAppCacheEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.city_img_title_back:
                startActivity(new Intent(DetailActivity.this,CityActivity.class));
                finish();
                break;
        }
    }

    public void loading(WebView webView){
        ProgressDialog dialog = new ProgressDialog(this);
        if (webView == null){
        dialog.setMessage("正在加载...");
        dialog.setCancelable(true);
        dialog.show();
        }else {
            dialog.dismiss();
        }
    }

    /**
     * 点击WebView后能返回
     */
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
