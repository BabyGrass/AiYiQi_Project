package com.aiyiqi.aiyiqi_project.decorate_budget;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aiyiqi.aiyiqi_project.R;
import com.finesdk.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/1/4.
 */

public class FragmentViewpager extends BaseFragment {
    private WebView webView;
    private WebSettings setting;
    private String fristurl;
    public FragmentViewpager(String url) {
        this.fristurl = url;
    }

    @Override
    protected int getResource() {
        return R.layout.budget_fragment_webview;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        webView = findViewByIdNoCast(R.id.budget_webView);
        setting = webView.getSettings();
    }

    @Override
    protected void initData() {
        setting.setAllowContentAccess(true);
        setting.setBuiltInZoomControls(true);
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);
        setting.setDefaultTextEncodingName("GBK");
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(fristurl);
        setting.setJavaScriptEnabled(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return super.shouldOverrideKeyEvent(view, event);
            }
        });
    }
    @Override
    public void onClick(View v) {

    }
    public WebView getWebView(){
        return this.webView;
    }
}
