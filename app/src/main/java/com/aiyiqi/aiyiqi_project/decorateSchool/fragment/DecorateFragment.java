package com.aiyiqi.aiyiqi_project.decorateSchool.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.decorateSchool.activity.DecorateDetailActivity;
import com.aiyiqi.aiyiqi_project.decorateSchool.adapter.MyListAdapter;
import com.aiyiqi.aiyiqi_project.decorateSchool.adapter.TagAdapter;
import com.aiyiqi.aiyiqi_project.decorateSchool.entity.DecorateSchoolContent;
import com.aiyiqi.aiyiqi_project.decorateSchool.entity.DecorateSchoolTag;
import com.aiyiqi.aiyiqi_project.effectpicture.util.Url;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.IntentUtil;
import com.finesdk.util.common.LogUtil;
import com.finesdk.util.common.ToastUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/11.
 */

public class DecorateFragment extends BaseFragment{

    private RecyclerView decorate_school_recycler;
    private ListView decorate_school_list;
    private TagAdapter adapter;
    private MyListAdapter listadapter;
    private List<DecorateSchoolContent.Data.Lists> newList;
    private MaterialRefreshLayout refresh;
    private int stage;
    private int page = 1;
    private boolean isLoadMore;
//    public static DecorateFragment newInstance(String text){
//        Bundle bundle = new Bundle();
//        bundle.putString("text",text);
//        DecorateFragment fragment = new DecorateFragment();
//        fragment.setArguments(bundle);
//        return fragment;
//    }

    public void setStage(int position ){
        stage = position + 1;
        getNetTagData(stage);
        getNetContentData(0,1,false);
    }

    @Override
    protected int getResource() {
        return R.layout.frag_decorateschool;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        decorate_school_recycler = findViewByIdNoCast(R.id.decorate_school_recycler);
        decorate_school_list = findViewByIdNoCast(R.id.decorate_school_list);
        refresh = findViewByIdNoCast(R.id.refresh_decorate_articleslist);
    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        decorate_school_recycler.setLayoutManager(manager);
        adapter = new TagAdapter();
        decorate_school_recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new TagAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position, View view) {
                ToastUtil.showToast("点击了"+position+"个标签");
                getNetContentData(position + 1,1,false);
            }
        });

        newList = new ArrayList<>();
        listadapter = new MyListAdapter(getContext(),newList);
        decorate_school_list.setAdapter(listadapter);
        decorate_school_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DecorateSchoolContent.Data.Lists lists = (DecorateSchoolContent.Data.Lists) listadapter.getItem(position);
                String newsId = lists.newsId;
                LogUtil.d("msg","newsId1:"+newsId.toString());
                Bundle bundle = new Bundle();
                bundle.putString("newsId",newsId);
                IntentUtil.openActivity(getActivity(),DecorateDetailActivity.class,bundle);
            }
        });
        //上拉下拉刷新
        initRefresh();
    }

    private void initRefresh() {
        refresh.setLoadMore(true);
        refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            /**
             * 下拉刷新加载更多
             * @param materialRefreshLayout
             */
            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        getNetContentData(stage,page,true);
                        if (newList != null) {
                            Toast.makeText(getContext(), "加载完成", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getContext(), "没有更多数据", Toast.LENGTH_SHORT).show();
                        }
                        refresh.finishRefreshLoadMore();
                    }
                },3000);
            }

            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        getNetContentData(stage,page,false);
                        if (newList != null){
                            Toast.makeText(getContext(), "刷新完成", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                        }
                        refresh.finishRefresh();
                    }
                }, 3000);
            }
        });
    }




    @Override
    public void onClick(View v) {

    }

    /**
     * 获取标签数据
     * @param stage
     */
    public void  getNetTagData(int stage){
        OkHttpUtil.get(Url.DECORATE_HEADER
                + "version=1&action=getTagsByStage&stage="
                + stage +"&model=android",
                new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response != null){
                    //动态Key 解析
                   JSONObject obj1 = JSON.parseObject((String) response);
                    DecorateSchoolTag tag = new DecorateSchoolTag();
                    tag.setError(obj1.getInteger("error"));
                    tag.setMessage(obj1.getString("message"));
                    tag.tags = new ArrayList<String>();
                    LogUtil.d("msg","tag.tags:"+tag.tags.size());
                    String ttag = obj1.getString("data");
                    JSONObject obj2 = JSON.parseObject(ttag);
                    Set<String> set = obj2.keySet();
                    Iterator<String> iterator = set.iterator();
                    while (iterator.hasNext()){
                         String key = iterator.next();
                        tag.tags.add(obj2.getString(key));
                    }
                    adapter.addData(tag.tags);
                }
            }

            @Override
            public void onFailure(Exception e) {
                ToastUtil.showToast("网络异常");
            }
        });
    }

    /**
     * 获取标签内容数据
     * @param stage
     */
    public void getNetContentData(int stage, int page, final boolean isLoadMore){
        String url = Url.DECORATE_HEADER1+ "version=1&action=getNewsByStage&stage="
                + stage +"&page="+page+"&pagesize=10&model=android";
        LogUtil.i("msg","url:"+url);
        OkHttpUtil.get(url,new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                LogUtil.i("msg", "json1:" + response.toString());
                if (response != null) {
//                    DecorateSchoolContent content = new Gson().fromJson(response.toString(), DecorateSchoolContent.class);
//                    List<DecorateSchoolContent.Data.Lists> lists = content.datas.lists;
                    JSONObject object1 = JSONObject.parseObject((String) response);
                    DecorateSchoolContent content = new DecorateSchoolContent();
                    LogUtil.i("msg","json:"+(String) response);
                    DecorateSchoolContent.Data data = content.new Data();
                    JSONObject object2 = object1.getJSONObject("data");
                    //    JSONObject object2 = JSONObject.parseObject(object1.getString("data"));
                    data.totalCount = object2.getString("totalCount");
                    data.currentPage = String.valueOf(object2.getInteger("currentPage"));
                    data.pageSize = String.valueOf(object2.getInteger("pageSize"));
                    JSONArray arr1 = object2.getJSONArray("list");
                    List<DecorateSchoolContent.Data.Lists> lists  = new ArrayList<DecorateSchoolContent.Data.Lists>();

                    if(arr1 != null){
                        for (int i = 0; i < arr1.size(); i++) {
                            DecorateSchoolContent.Data.Lists list = data.new Lists();
                            JSONObject object3 = arr1.getJSONObject(i);
                            list.newsId = String.valueOf(object3.getInteger("newsId"));
                            list.titles = object3.getString("title");
                            list.description = object3.getString("description");
                            list.replies = String.valueOf(object3.getInteger("replies"));
                            list.images = object3.getString("image");
                            list.viewCount = String.valueOf(object3.getInteger("viewCount"));
                            list.postTime = String.valueOf(object3.getInteger("postTime"));
                            list.isJump = String.valueOf(object3.getInteger("isJump"));
                            list.jumpUrl = object3.getString("jumpUrl");
                            list.favNums = String.valueOf(object3.getInteger("favNums"));
                            lists.add(list);
                        }
                        data.lists = lists;
                        content.datas = data;
                        LogUtil.i("msg","img:"+content.datas.lists.get(0).images);
                        listadapter.addData(lists,isLoadMore);
//                    listadapter.setData(content.datas.lists);
                    }
                }
            }
            @Override
            public void onFailure(Exception e) {
                ToastUtil.showToast("网络异常");
            }
        });
    }


    /**
     * Unicode转码
     * @param unicode
     * @return
     */
    public static String decode(String unicode) {
        StringBuffer str = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            str.append((char) data);
        }
        return str.length() > 0 ? str.toString() : unicode;
    }
}
