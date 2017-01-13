package com.aiyiqi.aiyiqi_project.effectpicture.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.adapter.FeaturesAdapter;
import com.aiyiqi.aiyiqi_project.effectpicture.entity.XiaoGuotu;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.aiyiqi.aiyiqi_project.effectpicture.util.Url.ZHUANTI_URL;

/**
 * Created by Administrator on 2017/1/6.
 */

public class FeaturesFragment extends BaseFragment {
    private List<XiaoGuotu.DataBean.ListBean> listBeen;
    private RecyclerView recyclerView;
    private FeaturesAdapter adapter;
    private XiaoGuotu xiaoGuotu;

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
    }

    @Override
    protected void initData() {
        listBeen = new ArrayList<>();
        getNetDatas();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new FeaturesAdapter(listBeen);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 网络获取数据添加到适配器中
     */
    public void getNetDatas(){
        OkHttpUtil.get(ZHUANTI_URL, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response != null){
                    xiaoGuotu = new Gson().fromJson(response.toString(),XiaoGuotu.class);
                    adapter.addDatas(xiaoGuotu.getData().getList());
                }
            }

            @Override
            public void onFailure(Exception e) {
                ToastUtil.showToast("网络异常");
            }
        });
    }
}
