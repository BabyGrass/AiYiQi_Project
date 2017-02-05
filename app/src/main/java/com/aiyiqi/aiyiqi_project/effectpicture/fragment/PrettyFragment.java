package com.aiyiqi.aiyiqi_project.effectpicture.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.TitlePopupWindow;
import com.aiyiqi.aiyiqi_project.effectpicture.activity.PrettyLookActivity;
import com.aiyiqi.aiyiqi_project.effectpicture.adapter.MeituAdapter;
import com.aiyiqi.aiyiqi_project.effectpicture.entity.Meitu;
import com.aiyiqi.aiyiqi_project.effectpicture.util.Url;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.IntentUtil;
import com.finesdk.util.common.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */

public class PrettyFragment extends BaseFragment {
    private RecyclerView effect_meitu_recycler;
    private MaterialRefreshLayout refresh_decorate_pretty;
    private List<Meitu.DataBean.ListBean> listBeen;
    private MeituAdapter adapter;
    private Meitu meitu;
    private LinearLayout meitu_ll_title;
    private LinearLayout meitu_ll_title1, meitu_ll_title2, meitu_ll_title3, meitu_ll_title4;
    private CheckedTextView meitu_tv1, meitu_tv2, meitu_tv3, meitu_tv4;
    private TitlePopupWindow pop_window;
    private List<String> list;
    private String result;
    private int page = 1;
    private boolean isLoadMore = false;
    private List<Meitu.DataBean.ListBean> list1 = new ArrayList<Meitu.DataBean.ListBean>();

    @Override
    protected int getResource() {
        return R.layout.effect_meitu;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        effect_meitu_recycler = findViewByIdNoCast(R.id.effect_meitu_recycler);
        meitu_ll_title1 = findViewByIdNoCast(R.id.meitu_ll_title1);
        meitu_ll_title2 = findViewByIdNoCast(R.id.meitu_ll_title2);
        meitu_ll_title3 = findViewByIdNoCast(R.id.meitu_ll_title3);
        meitu_ll_title4 = findViewByIdNoCast(R.id.meitu_ll_title4);
        meitu_ll_title = findViewByIdNoCast(R.id.meitu_ll_title);


        meitu_tv1 = findViewByIdNoCast(R.id.meitu_tv1);
        meitu_tv2 = findViewByIdNoCast(R.id.meitu_tv2);
        meitu_tv3 = findViewByIdNoCast(R.id.meitu_tv3);
        meitu_tv4 = findViewByIdNoCast(R.id.meitu_tv4);

        refresh_decorate_pretty = findViewByIdNoCast(R.id.refresh_decorate_pretty);
    }

    @Override
    protected void initData() {
        setOnClick(meitu_ll_title1, meitu_ll_title2, meitu_ll_title3, meitu_ll_title4);

        getNetDatas(page,false);
        listBeen = new ArrayList<>();
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        effect_meitu_recycler.setLayoutManager(layoutManager);
        adapter = new MeituAdapter(listBeen);
        effect_meitu_recycler.setAdapter(adapter);

        adapter.setOnClickItem(new MeituAdapter.OnClickItemListener() {
            @Override
            public void OnClickItem(int position, View view) {
                Meitu.DataBean.ListBean list = listBeen.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",list);
                IntentUtil.openActivity(getContext(), PrettyLookActivity.class,bundle);
            }
        });


        initRefresh();

    }

    /**
     * 刷新
     */
    private void initRefresh() {
        refresh_decorate_pretty.setLoadMore(true);
        refresh_decorate_pretty.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (listBeen == null){
                            getNetDatas(page,false);
                            Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                        }else {
                            page = 1;
                            getNetDatas(page,false);
                            Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                        }
                        refresh_decorate_pretty.finishRefresh();
                    }
                }, 3000);
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (list1 == listBeen) {
                            getNetDatas(page,true);
                            Toast.makeText(getContext(), "没有更多数据", Toast.LENGTH_SHORT).show();
                        }else {
                            page++;
                            getNetDatas(page,true);
                            Toast.makeText(getContext(), "加载完成", Toast.LENGTH_SHORT).show();
                        }
                        list1 = listBeen;
                        refresh_decorate_pretty.finishRefreshLoadMore();
                    }
                }, 3000);
            }
        });
    }

    @Override
    public void onClick(View v) {
        list = new ArrayList<>();
        pop_window = new TitlePopupWindow(getContext());
        result = pop_window.getCallBackString();
        switch (v.getId()) {
            case R.id.meitu_ll_title1:
                setPop_window();
//                if (pop_window.isShowing()){
//                    meitu_tv1.setTextColor(Color.parseColor("#339933"));
//                    meitu_img1.setImageResource(R.mipmap.arrow_pic_tab_top_press);
//                }else {
//                    meitu_tv1.setTextColor(Color.parseColor("ffffff"));
//                    meitu_img1.setImageResource(R.mipmap.arrow_pic_tab_down);
//                }
                final String Kongjian[] = {"全部", "客厅", "玄关", "起居室", "厨房", "餐厅", "衣帽间", "庭院", "卫生间", "阳台", "儿童房", "露台", "卧室", "书房", "娱乐室"};
                for (int i = 0; i < Kongjian.length; i++) {
                    list.add(Kongjian[i]);
                }
                pop_window.setlistData1(list);
                pop_window.showPopupWindow(meitu_ll_title);
//                meitu_tv1.setText(result);
                break;
            case R.id.meitu_ll_title2:
                final String Fengge[] = {"全部", "现代", "简欧", "简约", "欧式", "田园", "中式", "欧式古典", "北欧", "小资", "新中式", "混搭", "乡村", "美式", "宜家", "日式", "新古典", "地中海", "东南亚"};
                list.clear();
                for (int i = 0; i < Fengge.length; i++) {
                    list.add(Fengge[i]);
                }
                pop_window.setlistData2(list);
                pop_window.showPopupWindow(meitu_ll_title);
                break;
            case R.id.meitu_ll_title3:
                final String Jubu[] = {"全部", "背景墙", "收纳", "照片墙", "前面", "窗帘", "餐台", "储物间", "隔断", "飘窗", "楼梯", "门窗", "吧台", "工作区", "吊顶", "地面", "灯具", "过道", "地台", "壁炉"};
                list.clear();
                for (int i = 0; i < Jubu.length; i++) {
                    list.add(Jubu[i]);
                }
                pop_window.setlistData3(list);
                pop_window.showPopupWindow(meitu_ll_title);
                break;
            case R.id.meitu_ll_title4:
                final String Yanse[] = {"全部", "红色", "白色", "绿色", "黑色", "原木", "紫色", "粉色", "春色", "黄色", "蓝色"};
                list.clear();
                for (int i = 0; i < Yanse.length; i++) {
                    list.add(Yanse[i]);
                }
                pop_window.setlistData4(list);
                pop_window.showPopupWindow(meitu_ll_title);
                break;
        }
    }

    public void getNetDatas(int page, final boolean isLoadMore) {
        OkHttpUtil.get(Url.HEADER+"version=1&page="
                +page+"&action=imageList2&pageSize=10&tagid=0&model=android",
                new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response != null) {
                    meitu = new Gson().fromJson(response.toString(), Meitu.class);
//                    meitu = JSONObject.parseObject(response.toString(), Meitu.class);
                    adapter.addDatas(PrettyFragment.this.meitu.getData().getList(),isLoadMore);
                }
            }

            @Override
            public void onFailure(Exception e) {
                ToastUtil.showToast("网络异常");
            }
        });
    }


    public void setPop_window(){
        if (pop_window.isShowing()){
            pop_window.dismiss();
        }
    }

}
