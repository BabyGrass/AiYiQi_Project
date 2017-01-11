package com.aiyiqi.aiyiqi_project.view.fragment.tiezidetailfragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.LoginActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.Root;
import com.aiyiqi.aiyiqi_project.view.detailactivity.AuthodActivity;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.imageload.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TieZiDetailFragment extends BaseFragment {
    @Bind(R.id.authod_iamge_head)
    SimpleDraweeView authodIamgeHead;
    @Bind(R.id.yezhu_name)
    TextView yezhuName;
    @Bind(R.id.yezhu_detail)
    TextView yezhuDetail;
    @Bind(R.id.add_guanzhu_textview)
    TextView addGuanzhuTextview;
    @Bind(R.id.tiezi_detail_fragment_nametv)
    TextView tieziDetailFragmentNametv;
    @Bind(R.id.one_luntan)
    TextView oneLuntan;
    @Bind(R.id.tiezi_time)
    TextView tieziTime;
    @Bind(R.id.tiezi_detail_weixinfengxiang)
    ImageView tieziDetailWeixinfengxiang;
    @Bind(R.id.tiezi_detail_weixinpyq)
    ImageView tieziDetailWeixinpyq;
    @Bind(R.id.tiezi_detail_qq)
    ImageView tieziDetailQq;
    @Bind(R.id.tiezi_detail_jisun_iv)
    ImageView tieziDetailJisunIv;
    private Context context;
    private Root root;
    private LinearLayout zhongjian_tvandiv_ll;//中间显示图片和文字的线性布局
    private LinearLayout tiezi_detail_tags_ll;//底部的标签显示的线性布局

    public void setTieziFragment(Context context, Root root) {
        this.context = context;
        this.root = root;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.tiezi_xiangqing_fragment;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        zhongjian_tvandiv_ll = findViewByIdNoCast(R.id.zhongjian_tvandiv_ll);
        tiezi_detail_tags_ll = findViewByIdNoCast(R.id.tiezi_detail_tags_ll);
    }

    @Override
    protected void initData() {
        //设置数据
        if(root != null){
            yezhuName.setText(root.getData().getAuthor());
            ImageLoader.getInstance().disPlayImage(authodIamgeHead,root.getData().getAvtUrl());
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(60)
               .setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
            authodIamgeHead.getHierarchy().setRoundingParams(roundingParams);
            tieziDetailFragmentNametv.setText(root.getData().getTitle());
            yezhuDetail.setText(root.getData().getFid());
            tieziTime.setText(root.getData().getDateline());
            oneLuntan.setText(root.getData().getFname());
        }
        setLayouout(getActivity());
        setTags(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.authod_iamge_head, R.id.add_guanzhu_textview, R.id.one_luntan
    ,R.id.tiezi_detail_weixinfengxiang, R.id.tiezi_detail_weixinpyq,
            R.id.tiezi_detail_qq, R.id.tiezi_detail_jisun_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.authod_iamge_head://头像
                Intent intent = new Intent(context, AuthodActivity.class);
                startActivity(intent);
                break;
            case R.id.add_guanzhu_textview://关注
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.one_luntan://论坛
                break;
            case R.id.tiezi_detail_weixinfengxiang://微信好友
                break;
            case R.id.tiezi_detail_weixinpyq://微信朋友圈
                break;
            case R.id.tiezi_detail_qq://QQ好友
                break;
            case R.id.tiezi_detail_jisun_iv://计算测量
                break;
        }
    }

    /**
     * 动态加载布局
     */
    public void setLayouout(Context context) {
        if (root != null) {
            TextView textView = new TextView(context);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(16);
            textView.setPadding(10, 5, 10, 5);
            textView.setLineSpacing(2, 2);
            zhongjian_tvandiv_ll.addView(textView);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            simpleDraweeView.setPadding(10, 5, 10, 5);
            simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            simpleDraweeView.setMaxHeight(500);
            simpleDraweeView.setMaxWidth(500);
            zhongjian_tvandiv_ll.addView(simpleDraweeView);
            if (root != null) {
                oneLuntan.setText(root.getData().getFname());
                for (int i = 0; i < root.getData().getMessage().size(); i++) {
                    if (root.getData().getMessage().get(i).getMsgType() == 0) {
                        textView.setText(root.getData().getMessage().get(i).getMsg());
                    }
                    if (root.getData().getMessage().get(i).getMsgType() == 1) {
                        ImageLoader.getInstance().disPlayImage(simpleDraweeView, root.getData().getMessage().get(i).getMsg());
                    }
                }
            }
        }

    }

    /**
     * 设置底部标签的数据的方法
     */
    public void setTags(Context context) {
        if (root != null) {
            //            if(root.getData().getTags() == null){
            //                tiezi_detail_tags_ll.setVisibility(View.GONE);
            //            }
            if (root.getData().getTags() != null) {
                for (int i = 0; i < root.getData().getTags().size(); i++) {
                    TextView tv = new TextView(context);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(10, 5, 10, 5);
                    tv.setPadding(5, 5, 5, 5);
                    tv.setTextColor(Color.BLACK);
                    tv.setBackgroundColor(Color.GRAY);
                    tv.setTextSize(12);
                    tv.setLayoutParams(params);
                    tiezi_detail_tags_ll.addView(tv);
                    tv.setText(root.getData().getTags().get(i).getTagname());
                }

            }
        }
    }
}
