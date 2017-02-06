package com.aiyiqi.aiyiqi_project.view.fragment.yezhutalkfragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.adapter.YeZheJinghuaFragmentAdapter;
import com.aiyiqi.aiyiqi_project.assets.YeZhuJinghuaResultBean;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.YeZhuTalkUrl;
import com.aiyiqi.aiyiqi_project.view.detailactivity.TieZiDetailActivity;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.view.RefreshListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class JinhuaFragment extends BaseFragment {
    private YeZhuJinghuaResultBean yeZhuJinghuaResultBean;
    private YeZheJinghuaFragmentAdapter adapter;
    private RefreshListView refreshListView;
    private int currentPage = 1;
    private String id;
    @Override
    protected int getResource() {
        return R.layout.yezhu_jignhua_fragment_layout;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        refreshListView = findViewByIdNoCast(R.id.jinhua_own_listview);
        /**
         * 设置点击item监听，跳转到帖子详情
         */
        refreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TieZiDetailActivity.class);
                intent.putExtra("tiezi",yeZhuJinghuaResultBean.getData().get(position-1).getTid());
                intent.putExtra("replies",yeZhuJinghuaResultBean.getData().get(position-1).getReplies());
                startActivity(intent);
            }
        });
        /**
         * 刷新和加载更多
         */
        refreshListView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {//刷新
                currentPage = 1;
                getDataFromConn();
            }

            @Override
            public void onLoadingMore() {//加载
                currentPage++;
                getDataFromConn();
            }
        });
        adapter = new YeZheJinghuaFragmentAdapter(getActivity());
        refreshListView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        getDataFromConn();
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 网络请求的方法
     */
    public void getDataFromConn() {
        OkHttpUtil.post(YeZhuTalkUrl.BEST, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if(response != null){
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    Log.i("msg",str);
                    str = str.replace("\"houseInfo\":[]","\"houseInfo\":null");
                    yeZhuJinghuaResultBean = new Gson().fromJson(str,YeZhuJinghuaResultBean.class);
                    id = yeZhuJinghuaResultBean.getData().get(yeZhuJinghuaResultBean.getData().size()-1).getTid();
                    adapter.setData(yeZhuJinghuaResultBean.getData());
                    adapter.notifyDataSetChanged();
                    refreshListView.completeRefresh();
                }
            }

            @Override
            public void onFailure(Exception e) {
                currentPage--;
            }
        },getParams());
    }

    /**
     * Post请求数据的参数
     */
    public List<OkHttpUtil.Param> getParams() {
        String key1 = "page";
        String value1 = currentPage+" ";
        String key2 = "pageSize";
        String value2 = "10";
        String key3 = "a";
        String value3 = "allThread";
        String key4 = "c";
        String value4 = "forumThreadList";
        String key5 = "m";
        String value5 = "forum";
        String key6 = "mode";
        String value6 = "digest";
        String key7 = "uuid";
        String value7 = "86305803367590";
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1, value1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2, value2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3, value3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4, value4);
        OkHttpUtil.Param param5 = new OkHttpUtil.Param(key5, value5);
        OkHttpUtil.Param param6 = new OkHttpUtil.Param(key6, value6);
        OkHttpUtil.Param param7 = new OkHttpUtil.Param(key7, value7);
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        paramList.add(param5);
        paramList.add(param6);
        paramList.add(param7);
        return paramList;
    }
}

