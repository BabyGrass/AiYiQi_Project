package com.aiyiqi.aiyiqi_project.effectpicture.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.adapter.FeaturesAdapter;
import com.aiyiqi.aiyiqi_project.effectpicture.entity.XiaoGuotu;
import com.aiyiqi.aiyiqi_project.effectpicture.util.Url;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class FeaturesFragment extends BaseFragment {
    private List<XiaoGuotu.DataBean.ListBean> listBeen;
    private RecyclerView recyclerView;
    private MaterialRefreshLayout refresh_decorate_features;
    private FeaturesAdapter adapter;
    private XiaoGuotu xiaoGuotu;
    private int page = 1;
    private boolean isLoadMore = false;

    @Override
    protected int getResource() {
        return R.layout.effect_zhuanti;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        recyclerView = findViewByIdNoCast(R.id.effect_zhuanti_recycler);
        refresh_decorate_features = findViewByIdNoCast(R.id.refresh_decorate_features);
    }

    @Override
    protected void initData() {
        listBeen = new ArrayList<>();
        getNetDatas(page,false);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new FeaturesAdapter(listBeen);
        recyclerView.setAdapter(adapter);

        initRefresh();
    }

    private void initRefresh() {
        refresh_decorate_features.setLoadMore(true);
        refresh_decorate_features.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (listBeen == null) {
                            Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                        }else {
                            page = 1;
                            getNetDatas(page,false);
                            Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                        }
                        refresh_decorate_features.finishRefresh();
                    }
                }, 3000);
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (listBeen == null){
                            getNetDatas(page,true);
                            Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                        }else {
                            page++;
                            getNetDatas(page,true);
                            Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                        }
                        refresh_decorate_features.finishRefreshLoadMore();
                    }
                }, 3000);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 网络获取数据添加到适配器中
     */
    public void getNetDatas(int page,final boolean isLoadMore){
        OkHttpUtil.get(Url.HEADER +
                "version=1&page="+page+"&action=albumList2&pageSize=10&tagid=1&model=android"
                , new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response != null){
                    xiaoGuotu = new Gson().fromJson(response.toString(),XiaoGuotu.class);
                    adapter.addDatas(xiaoGuotu.getData().getList(),isLoadMore);
                }
            }

            @Override
            public void onFailure(Exception e) {
                ToastUtil.showToast("网络异常");
            }
        });
    }
}
