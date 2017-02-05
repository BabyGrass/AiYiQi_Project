package com.aiyiqi.aiyiqi_project.view.fragment.tiezidetailfragment;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.adapter.TieziBackAdapter;
import com.aiyiqi.aiyiqi_project.assets.TieziBackBean;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.DetailUrl;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.display.ListViewUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class TieZiRepliceFragment extends BaseFragment {
    private TextView tiezi_back_replice,tiezi_detail_no_comment;
    private ListView repilce_listview;
    //适配器
    private Context context;
    private String tids;
    private TieziBackAdapter adapter;
    private TieziBackBean tieziBackBean;
    private String replies;

    public void setTieziFragment(Context context, String tids,String replies) {
        this.context = context;
        this.tids = tids;
        this.replies = replies;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.tiezi_replice_fragment_layout;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tiezi_back_replice = findViewByIdNoCast(R.id.tiezi_back_replice);
        tiezi_detail_no_comment = findViewByIdNoCast(R.id.tiezi_detail_no_comment);
        repilce_listview = findViewByIdNoCast(R.id.repilce_listview);

    }

    @Override
    protected void initData() {
        if(replies != null){
            tiezi_back_replice.setText("回帖("+replies+")");
          //  getDatas();
        }
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 网络请求数据的方法(帖子回复)
     */
    private void getDatas() {
        OkHttpUtil.post(DetailUrl.POST_PINLUN_LIST, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response != null) {
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    Log.i("sssss", str);
                    str = str.replace("\"houseInfo\":[]","\"houseInfo\":{}");
                    tieziBackBean = new Gson().fromJson(str, TieziBackBean.class);
                    adapter = new TieziBackAdapter(getActivity(), (List<TieziBackBean.DataBean>) tieziBackBean.getData());
                    repilce_listview.setAdapter(adapter);
                    adapter.setData((List<TieziBackBean.DataBean>) tieziBackBean.getData());
                    adapter.notifyDataSetChanged();
                    ListViewUtil.measureListViewHeight(repilce_listview);
                    if(adapter.getCount() == 0){
                        tiezi_detail_no_comment.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, getParams());

    }

    /**
     * 参数
     */
    private List<OkHttpUtil.Param> getParams() {
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        String key1 = "a";
        String values1 = "viewThread";
        String key2 = "page";
        String values2 = "1";
        String key3 = "tid";
        Log.i("djkdjd",tids+"      fda");
        String values3 = tids;
        String key4 = "c";
        String values4 = "forumThread";
        String key5 = "pageSize";
        String values5 = "10";
        String key6 = "m";
        String values6 = "forum";
        OkHttpUtil.Param param = new OkHttpUtil.Param(key1, values1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2, values2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3, values3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4, values4);
        OkHttpUtil.Param param5 = new OkHttpUtil.Param(key5, values5);
        OkHttpUtil.Param param6 = new OkHttpUtil.Param(key6, values6);
        paramList.add(param);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        paramList.add(param5);
        paramList.add(param6);
        return paramList;
    }


}
