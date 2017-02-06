package com.aiyiqi.aiyiqi_project.zhuangxiugongsi;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.FirstUrlUtils;
import com.finesdk.activity.BaseActivity;

/**
 * 新房整装
 * Created by Administrator on 2017/1/6.
 */

public class ZhuangXiuXfZz extends BaseActivity {
    private TextView zx_tx_title;//title
    private WebView webView;
    private ImageView imageView;//返回

    @Override
    public int getContentViewId() {
        return R.layout.activity_zhuangxiugongsi_xfzx;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        zx_tx_title = findViewByIdNoCast(R.id.zx_tx_title);
        webView = findViewByIdNoCast(R.id.xfzx_vebview);
        imageView = (ImageView) findViewById(R.id.zx_iv_fanhui);
    }

    @Override
    public void initData() {
        setOnClick(imageView);
        //通过getSettings方法设置浏览器的属性，此处是通过方法设置VebView支持javaScript脚本
        webView.getSettings().setJavaScriptEnabled(true);
        //必须设置， 通过这个方法可以让WebView在跳转下个网页时 还是使用WebView控件显示
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(FirstUrlUtils.OLD_OUTFIT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zx_iv_fanhui://返回键
                finish();
                break;
        }
    }
}
