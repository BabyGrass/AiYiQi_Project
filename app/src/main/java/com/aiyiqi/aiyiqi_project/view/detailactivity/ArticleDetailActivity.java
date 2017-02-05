package com.aiyiqi.aiyiqi_project.view.detailactivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.HomeFragmnetResultBean;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.DetailUrl;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ArticleDetailActivity extends BaseActivity {
    @Bind(R.id.article_back_tv)
    TextView articleBackTv;
    @Bind(R.id.article_pinglun_edittext)
    EditText articlePinglunEdittext;
    @Bind(R.id.article_bottom_collect)
    ImageView articleBottomCollect;
    @Bind(R.id.article_bottom_share)
    ImageView articleBottomShare;
    @Bind(R.id.title)
    RelativeLayout title;
    @Bind(R.id.article_detail_title)
    TextView articleDetailTitle;
    @Bind(R.id.article_detail_tags_ll)
    LinearLayout articleDetailTagsLl;
    @Bind(R.id.article_detail_weixinfengxiang)
    ImageView articleDetailWeixinfengxiang;
    @Bind(R.id.article_detail_weixinpyq)
    ImageView articleDetailWeixinpyq;
    @Bind(R.id.article_detail_qq)
    ImageView articleDetailQq;
    @Bind(R.id.article_detail_jisun_iv)
    ImageView articleDetailJisunIv;
    @Bind(R.id.bottom)
    LinearLayout bottom;
    private ScrollView article_detail_scrollview;
    private HomeFragmnetResultBean.DataBean dataBean;

    @Override
    public int getContentViewId() {
        return R.layout.article_activity_layout;
    }

    @Override
    public void beforeInitView() {
        dataBean = this.getIntent().getParcelableExtra("article");
    }

    @Override
    public void initView() {
        article_detail_scrollview = findViewByIdNoCast(R.id.article_detail_scrollview);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.article_back_tv, R.id.article_bottom_collect, R.id.article_bottom_share
    ,R.id.article_detail_weixinfengxiang, R.id.article_detail_weixinpyq, R.id.article_detail_qq,
            R.id.article_detail_jisun_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.article_back_tv://返回
                finish();
                break;
            case R.id.article_bottom_collect://星星
                break;
            case R.id.article_bottom_share://分享
                break;
            case R.id.article_detail_weixinfengxiang://微信分享
                break;
            case R.id.article_detail_weixinpyq://朋友圈
                break;
            case R.id.article_detail_qq://QQ分享
                break;
            case R.id.article_detail_jisun_iv://计算测量
                break;
        }
    }

    /**
     * 网络请求数据的方法
     */
    public void getData(){
        OkHttpUtil.post(DetailUrl.ARTICLE_DETAIL, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        },getParams());
    }
    /**
     * 网络请求参数
     */
    public List<OkHttpUtil.Param> getParams(){
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        String key1 = "newsId";
        String vlaue1 = dataBean.getId();
        String key2 = "relatedNum";
        String vlaue2 = "3";
        String key3 = "model";
        String vlaue3 = "android";
        String key4 = "page";
        String vlaue4 = "1";
        String key5 ="version";
        String value5 = "1";
        String key6 = "action";
        String value6 = "newsDetail";

        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1,vlaue1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2,vlaue2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3,vlaue3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4,vlaue4);
        OkHttpUtil.Param param5 = new OkHttpUtil.Param(key5,value5);
        OkHttpUtil.Param param6 = new OkHttpUtil.Param(key6,value6);
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        paramList.add(param5);
        paramList.add(param6);
        return paramList;
    }

    /**
     * 动态添加标签的方法
     */
//    public void setTags(Context context) {
//        if (root != null) {
//            //            if(root.getData().getTags() == null){
//            //                tiezi_detail_tags_ll.setVisibility(View.GONE);
//            //            }
//            if (root.getData().getTags() != null) {
//                for (int i = 0; i < root.getData().getTags().size(); i++) {
//                    TextView tv = new TextView(context);
//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                    params.setMargins(10, 5, 10, 5);
//                    tv.setPadding(5, 5, 5, 5);
//                    tv.setTextColor(Color.BLACK);
//                    tv.setBackgroundColor(Color.GRAY);
//                    tv.setTextSize(12);
//                    tv.setLayoutParams(params);
//                    tiezi_detail_tags_ll.addView(tv);
//                    tv.setText(root.getData().getTags().get(i).getTagname());
//                }
//
//            }
//        }
//    }



}
