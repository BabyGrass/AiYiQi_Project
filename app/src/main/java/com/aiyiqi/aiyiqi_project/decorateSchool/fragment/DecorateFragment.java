package com.aiyiqi.aiyiqi_project.decorateSchool.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.decorateSchool.adapter.TagAdapter;
import com.aiyiqi.aiyiqi_project.decorateSchool.entity.DecorateSchoolTag;
import com.aiyiqi.aiyiqi_project.effectpicture.util.Url;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.ToastUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/11.
 */

public class DecorateFragment extends BaseFragment{

    private RecyclerView decorate_school_recycler;
    private ListView decorate_school_list;
    private TagAdapter adapter;
    private int stage;
//    public static DecorateFragment newInstance(String text){
//        Bundle bundle = new Bundle();
//        bundle.putString("text",text);
//        DecorateFragment fragment = new DecorateFragment();
//        fragment.setArguments(bundle);
//        return fragment;
//    }

    public void setStage(int position ){
        stage = position + 1;
        getNetData(stage);
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
    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        decorate_school_recycler.setLayoutManager(manager);
        adapter = new TagAdapter();
        decorate_school_recycler.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }

    public void  getNetData(int stage){
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
}
