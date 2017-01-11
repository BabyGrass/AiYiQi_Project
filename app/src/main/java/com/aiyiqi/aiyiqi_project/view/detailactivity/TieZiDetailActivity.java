package com.aiyiqi.aiyiqi_project.view.detailactivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.LoginActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.Root;
import com.aiyiqi.aiyiqi_project.assets.TieZiDetailResultBean;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.DetailUrl;
import com.aiyiqi.aiyiqi_project.view.fragment.tiezidetailfragment.TieZiDetailFragment;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TieZiDetailActivity extends BaseActivity {

    @Bind(R.id.tiezi_back_tv)
    TextView tieziBackTv;
    @Bind(R.id.tiezi_scrollview)
    ScrollView tieziScrollview;
    @Bind(R.id.tiezi_back_edittext)
    EditText tieziBackEdittext;
    @Bind(R.id.tiezi_bottom_like)
    ImageView tieziBottomLike;
    @Bind(R.id.tiezi_bottom_collect)
    ImageView tieziBottomCollect;
    @Bind(R.id.tiezi_bottom_share)
    ImageView tieziBottomShare;
    private String id;
    private TieZiDetailResultBean tieZiDetailResultBean;
    private TieZiDetailFragment tieZiDetailFragment;
    private Root root;

    @Override
    public int getContentViewId() {
        return R.layout.tiezi_activity_layout;
    }

    @Override
    public void beforeInitView() {
        id = this.getIntent().getStringExtra("tiezi");
    }

    @Override
    public void initView() {
        tieZiDetailFragment = (TieZiDetailFragment) getSupportFragmentManager().findFragmentById(R.id.tiezi_detail_fragment);
    }

    @Override
    public void initData() {
        getDataFromNetwork();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tiezi_back_tv, R.id.tiezi_bottom_like, R.id.tiezi_bottom_collect, R.id.tiezi_bottom_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tiezi_back_tv://返回
                finish();
                break;
            case R.id.tiezi_bottom_like://喜欢点赞
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.tiezi_bottom_collect://收藏
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.tiezi_bottom_share://分享
                break;
        }
    }

    /**
     * 网络请求
     */
    public void getDataFromNetwork(){
        OkHttpUtil.post(DetailUrl.POST_DETAIL, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if(response != null){
                    String s = null;
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    if(str.contains("\"houseInfo\":[]")){
                        s = str.replace("\"houseInfo\":[]","\"houseInfo\":{}");
                    }
                    else{
                        s = str;
                    }
                    root = new Gson().fromJson(s,Root.class);
                    Log.i("msg",root.toString());
                    tieZiDetailFragment.setTieziFragment(TieZiDetailActivity.this,root);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        },getParam());
    }

    /**
     * 参数
     */
    public List<OkHttpUtil.Param> getParam(){
//        a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid=1216903&
//                m=forum&haspermission=yes&model=android&
//                app_version=android_com.aiyiqi.galaxy_1.1"
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        String key1 = "tid";
        String vlaue1 = id;
        String key2 = "a";
        String vlaue2 = "viewThread";
        String key3 = "c";
        String vlaue3 = "forumThread";
        String key4 = "m";
        String vlaue4 = "forum";
        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1,vlaue1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2,vlaue2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3,vlaue3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4,vlaue4);
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        return paramList;
    }



}
