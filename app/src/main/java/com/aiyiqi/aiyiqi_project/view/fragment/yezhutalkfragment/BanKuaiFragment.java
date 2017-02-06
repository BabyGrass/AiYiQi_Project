package com.aiyiqi.aiyiqi_project.view.fragment.yezhutalkfragment;

import android.view.View;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.adapter.BanKuaiAdapter;
import com.aiyiqi.aiyiqi_project.assets.YeZhuBankuaiResultBean;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.YeZhuTalkUrl;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.view.RefreshListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class BanKuaiFragment extends BaseFragment {
    private YeZhuBankuaiResultBean yeZhuBankuaiResultBean;
    private RefreshListView listview;
    private BanKuaiAdapter adapter;
    @Override
    protected int getResource() {
        return R.layout.yezhu_bankuai_fragment_layout;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        listview =findViewByIdNoCast(R.id.bankuai_listview);
        listview.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                getDataFromNet();
            }

            @Override
            public void onLoadingMore() {

            }
        });
    }

    @Override
    protected void initData() {
        getDataFromNet();
    }

    @Override
    public void onClick(View v) {

    }
    /**
     * 网络请求数据的方法
     */
    public void getDataFromNet(){
        OkHttpUtil.post(YeZhuTalkUrl.PLATE, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if(response != null){
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    yeZhuBankuaiResultBean = new Gson().fromJson(str,YeZhuBankuaiResultBean.class);
                    adapter = new BanKuaiAdapter(getActivity(),yeZhuBankuaiResultBean.getData());
                    listview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        },getParam());
        listview.completeRefresh();
    }
    /**
     * 请求参数
     */
    public List<OkHttpUtil.Param> getParam(){
        String key1 = "cityName";
        String value1 = "成都";
        String key2 = "cityId";
        String value2 = "2";
        String key3 = "a";
        String value3 = "miscForum";
        String key5 = "m";
        String value5 = "misc";
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1, value1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2, value2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3, value3);
        OkHttpUtil.Param param5 = new OkHttpUtil.Param(key5, value5);
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param5);
        return paramList;
    }
}
