package com.aiyiqi.aiyiqi_project.decorateSchool.activity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.decorateSchool.adapter.ArticlesAdapter;
import com.aiyiqi.aiyiqi_project.decorateSchool.entity.DecorateSchoolDetail;
import com.aiyiqi.aiyiqi_project.effectpicture.util.Url;
import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.IntentUtil;
import com.finesdk.util.common.ToastUtil;
import com.finesdk.util.display.ListViewUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class DecorateDetailActivity extends BaseActivity {
    private ImageView decorate_school_detail_back;
    private TextView decorate_school_detail_title, articles_tv_look, articles_tv_shoucang, articles_tv_pinglun;
    private LinearLayout decorate_school_detail_content;
    private RelativeLayout rl_decorate_school_detail;
    private ListView decorate_school_detail_lv;
    private DecorateSchoolDetail detail;
    private ArticlesAdapter articlesadapter;
    private List<DecorateSchoolDetail.DataBean.RelatedNewsBean> relatedNewsBean;
    private String newsId;

    @Override
    public int getContentViewId() {
        return R.layout.activity_decorateschool_detail;
    }

    @Override
    public void beforeInitView() {
        newsId = getIntent().getStringExtra("newsId");
    }

    @Override
    public void initView() {
        decorate_school_detail_back = findViewByIdNoCast(R.id.decorate_school_detail_back);
        decorate_school_detail_title = findViewByIdNoCast(R.id.decorate_school_detail_title);
        articles_tv_look = findViewByIdNoCast(R.id.articles_tv_look);
        articles_tv_shoucang = findViewByIdNoCast(R.id.articles_tv_shoucang);
        articles_tv_pinglun = findViewByIdNoCast(R.id.articles_tv_pinglun);
        decorate_school_detail_content = findViewByIdNoCast(R.id.decorate_school_detail_content);
        decorate_school_detail_lv = findViewByIdNoCast(R.id.decorate_school_detail_lv);
        rl_decorate_school_detail = findViewByIdNoCast(R.id.rl_decorate_school_detail);

    }

    @Override
    public void initData() {

        setOnClick(decorate_school_detail_back);
        getNetDataContent(newsId);
        relatedNewsBean = new ArrayList<>();
        articlesadapter = new ArticlesAdapter(relatedNewsBean, this);
        decorate_school_detail_lv.setAdapter(articlesadapter);
        decorate_school_detail_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DecorateSchoolDetail.DataBean.RelatedNewsBean newsBean = (DecorateSchoolDetail.DataBean.RelatedNewsBean) articlesadapter.getItem(position);
                String newId = newsBean.getNews_id();
                Bundle bundle = new Bundle();
                bundle.putString("newsId", newId);
                IntentUtil.openActivity(DecorateDetailActivity.this, DecorateDetailActivity.class, bundle);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.decorate_school_detail_back:
                IntentUtil.openActivity(DecorateDetailActivity.this, DecorateSchoolActivity.class);
                finish();
                break;
        }
    }

    /**
     * 网络获取数据
     */
    public void getNetDataContent(String newsId) {
        OkHttpUtil.get(Url.DECORATE_HEADER1 + "version=1&relatedNum=3&action=newsDetail&page=1&newsId="
                        + newsId + "&model=android",
                new OkHttpUtil.ResultCallback() {
                    @Override
                    public void onSuccess(Object response) {
                        if (response != null) {
                            detail = JSON.parseObject(response.toString(), DecorateSchoolDetail.class);
                            if (detail.getData() != null) {
                                showDecorateDetail(detail.getData());
                                rl_decorate_school_detail.setVisibility(View.VISIBLE);
                                articlesadapter.addData(detail.getData().getRelatedNews());
                                ListViewUtil.measureListViewHeight(decorate_school_detail_lv);
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
     * 设置对应内容
     * 判断内容是文字还是图片
     *
     * @param dataBean
     */
    public void showDecorateDetail(DecorateSchoolDetail.DataBean dataBean) {
        if (dataBean != null) {
            decorate_school_detail_title.setText(dataBean.getCurrentNews().getTitle());
            articles_tv_look.setText(String.valueOf(dataBean.getCurrentNews().getClick()));
            articles_tv_shoucang.setText(dataBean.getCurrentNews().getPeople_num());
            articles_tv_pinglun.setText(dataBean.getCurrentNews().getComment_count());
            List<String> content = dataBean.getCurrentNews().getContent();
            for (int i = 0; i < content.size(); i++) {
                if (i % 2 != 0) {
                    SimpleDraweeView img = new SimpleDraweeView(this);
                    img.setMinimumHeight(500);
                    img.setMaxHeight(700);
                    img.setPadding(10, 10, 10, 10);
                    img.setImageURI(content.get(i));
                    decorate_school_detail_content.addView(img);
                } else {
                    TextView textview = new TextView(this);
                    textview.setText(content.get(i));
                    textview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    textview.setPadding(10, 20, 10, 10);
                    decorate_school_detail_content.addView(textview);
                }
            }

        }
    }
}
