package com.aiyiqi.aiyiqi_project.view.fragment.yezhutalkfragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.adapter.YeZheFragmentAdapter;
import com.aiyiqi.aiyiqi_project.assets.YeZhuJinghuaResultBean;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.YeZhuTalkUrl;
import com.aiyiqi.aiyiqi_project.view.detailactivity.TieZiDetailActivity;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.view.RefreshListView;
import com.google.gson.Gson;
import com.umeng.socialize.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class NewFragment extends BaseFragment{
    private YeZheFragmentAdapter adapter;
    private RefreshListView refreshListView;
    private YeZhuJinghuaResultBean yeZhuJinghuaResultBean;
    private int pages = 1;
    @Override
    protected int getResource() {
        return R.layout.yezhu_new_fragment_layout;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        refreshListView = findViewByIdNoCast(R.id.yezhu_new_listview);
        /**
         * 设置点击Item监听跳转
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
        refreshListView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {//刷新
                pages = 1;
                getDataFromNet();
            }

            @Override
            public void onLoadingMore() {//加载
                pages++;
                getDataFromNet();
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

    /**网络访问的方法
     *
     */
    public void getDataFromNet(){
//        OkHttpUtil.get("http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&uuid=86305803367590&pageSize=10&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1",
//                new OkHttpUtil.ResultCallback() {
//                    @Override
//                    public void onSuccess(Object response) {
//                        if(response != null){
//                            String str = OkHttpUtil.decodeUnicode(response.toString());
//                            str = str.replace("\"houseInfo\":[]","\"houseInfo\":{}");
//                            yeZhuNewResultBean = new Gson().fromJson(str,YeZhuNewResultBean.class);
//                            adapter = new YeZheFragmentAdapter(getActivity(),yeZhuNewResultBean.getData());
//                            adapter.setData(yeZhuNewResultBean.getData());
//                            refreshListView.setAdapter(adapter);
//                            adapter.notifyDataSetChanged();
//                            refreshListView.completeRefresh();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//
//                    }
//                });
        OkHttpUtil.post(YeZhuTalkUrl.NEW, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if(response != null){
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    Log.i("jsdkkjsdkjsjkjsksjj",str);
                 //   str = str.replace("\"houseInfo\":[]","\"houseInfo\":{}");
                    str = str.replace("\"houseInfo\":[]","\"houseInfo\":{}");
                    Log.i("aaaaaaaaaaaaaaaa",str);
                    yeZhuJinghuaResultBean = new Gson().fromJson(str,YeZhuJinghuaResultBean.class);
                    adapter = new YeZheFragmentAdapter(getActivity(),yeZhuJinghuaResultBean.getData());
                    adapter.setData(yeZhuJinghuaResultBean.getData());
                    refreshListView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    refreshListView.completeRefresh();
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        },getParam());
    }

    public List<OkHttpUtil.Param> getParam(){
        String key1 = "cityName";
        String vlaue1 = "成都";
        String key2 = "page";
        String vlaue2 = "1";
        String key3 = "pageSize";
        String vlaue3 = "10";
        String key4 = "a";
        String vlaue4 = "allThread";
        String key5 = "c";
        String vlaue5 = "forumThreadList";
        String key6 = "m";
        String vlaue6 = "forum";
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1,vlaue1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2,vlaue2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3,vlaue3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4,vlaue4);
        OkHttpUtil.Param param5 = new OkHttpUtil.Param(key5,vlaue5);
        OkHttpUtil.Param param6 = new OkHttpUtil.Param(key6,vlaue6);
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        paramList.add(param5);
        paramList.add(param6);
        return paramList;
    }

}
