package com.aiyiqi.aiyiqi_project.city.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aiyiqi.aiyiqi_project.MainActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.city.adapter.CityAdapter;
import com.aiyiqi.aiyiqi_project.city.entity.CityEntity;
import com.aiyiqi.aiyiqi_project.effectpicture.util.Url;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.IntentUtil;
import com.finesdk.util.common.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class CityActivity extends BaseActivity{
    private ImageView city_img_title_back;
    private RecyclerView mRecyclerView;
    private MaterialRefreshLayout refresh_city;
    private List<CityEntity.DataBean.ForumlistBean> mForumlistBeanList;
    private CityEntity resultBean;
    private CityAdapter adapter;



    @Override
    public int getContentViewId() {
        return R.layout.activity_city;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        city_img_title_back = findViewByIdNoCast(R.id.city_img_title_back);
        mRecyclerView = findViewByIdNoCast(R.id.city_content);
        refresh_city = findViewByIdNoCast(R.id.refresh_city);
        setOnClick(city_img_title_back);
    }

    @Override
    public void initData() {
        setOnClick(city_img_title_back);
        mForumlistBeanList = new ArrayList<>();
        getNetData();
        //动态添加Item
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new CityAdapter(this);
        mRecyclerView.setAdapter(adapter);
        //回调监听recyclerView的Item
        adapter.setOnItemClickListener(new CityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                ToastUtil.showToast("点击了第"+position+"个按钮");
                Intent intent = new Intent(CityActivity.this,DetailActivity.class);
                if (0 == position){
                    intent.putExtra("url",resultBean.getData().getForumlist().get(position).getGroupon_urls());
                }else {
                    intent.putExtra("url",resultBean.getData().getForumlist().get(position).getUrls());
                }
                startActivity(intent);
            }
        });
        initRefresh();
    }

    private void initRefresh() {
        refresh_city.setLoadMore(true);
        refresh_city.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CityActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                        refresh_city.finishRefresh();
                    }
                },3000);
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CityActivity.this, "没有更多数据", Toast.LENGTH_SHORT).show();
                        refresh_city.finishRefreshLoadMore();
                    }
                }, 3000);
            }
        });
    }


    /**
     * 获取网络数据
     */
    private void getNetData() {
        OkHttpUtil.get(Url.HEADER_HUODONG
                + "a=activityThreadlist&c=forumThreadList&uuid=a444d1b2af4f&pageSize=10&uid=1633055&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1",
                new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                resultBean = new Gson().fromJson( response.toString(), CityEntity.class);
//                LogUtil.d("msg","-------------"+resultBean.getData().toString());
                //添加数据到适配器中
                if (resultBean != null){
                    adapter.addDatas( resultBean.getData().getForumlist());
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.city_img_title_back:
                IntentUtil.openActivity(CityActivity.this, MainActivity.class);
                finish();
                break;
        }
    }




    /**
 * Unicode转换成字符串
 * @param unicode
 * @return
 */
    public static String unicodeString(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }


}
