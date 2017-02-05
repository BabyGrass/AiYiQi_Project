package com.aiyiqi.aiyiqi_project.view.fragment.tiezidetailfragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.LoginActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.Root;
import com.aiyiqi.aiyiqi_project.assets.TieziZanBean;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.DetailUrl;
import com.aiyiqi.aiyiqi_project.view.detailactivity.AuthodActivity;
import com.aiyiqi.aiyiqi_project.view.detailactivity.MyDialog;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.imageload.ImageLoader;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TieZiDetailFragment extends BaseFragment{
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
    @Bind(R.id.tiezi_detail_zan_ll)//帖子暂的线性布局
            LinearLayout tieziDetailZanLl;
    private Context context;
    private Root root;
    private LinearLayout zhongjian_tvandiv_ll;//中间显示图片和文字的线性布局
    private LinearLayout tiezi_detail_tags_ll;//底部的标签显示的线性布局
    //帖子赞
    private TieziZanBean tieziZanBean;
    //计算自定义Dialog
    private MyDialog dialog;

    private String tids;

    public void setTieziFragment(Context context, String tids,Root root) {
        this.context = context;
        this.tids = root.getData().getTid();
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
        if (root != null) {
            yezhuName.setText(root.getData().getAuthor());
            ImageLoader.getInstance().disPlayImage(authodIamgeHead, root.getData().getAvtUrl());
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(60)
                    .setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
            authodIamgeHead.getHierarchy().setRoundingParams(roundingParams);
            tieziDetailFragmentNametv.setText(root.getData().getTitle());
            yezhuDetail.setText(root.getData().getFid());
            tieziTime.setText(root.getData().getDateline());
            oneLuntan.setText(root.getData().getFname());
            getDataFromNet();
            setLayouout(getActivity());
            setTags(getActivity());
        }
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
            , R.id.tiezi_detail_weixinfengxiang, R.id.tiezi_detail_weixinpyq,
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
            case R.id.tiezi_detail_jisun_iv://计算测量(点击弹出Dialog)
                dialog = new MyDialog(getActivity(), R.style.myDialogStyle, (View.OnClickListener) getActivity());
                dialog.show();
              break;
            case R.id.queren_button:
                break;
            case R.id.cancle_button:
                dialog.dismiss();
                break;
        }
    }


    /**
     * 动态加载布局
     */
    public void setLayouout(Context context) {
        if (root != null) {
            oneLuntan.setText(root.getData().getFname());
            for (int i = 0; i < root.getData().getMessage().size(); i++) {
                if (root.getData().getMessage().get(i).getMsgType() == 0) {
                    TextView textView = new TextView(context);
                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(16);
                    textView.setPadding(10, 5, 10, 5);
                    textView.setLineSpacing(2, 2);
                    zhongjian_tvandiv_ll.addView(textView);
                    textView.setText(root.getData().getMessage().get(i).getMsg());
                }
                if (root.getData().getMessage().get(i).getMsgType() == 1) {
                    SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
                    simpleDraweeView.setPadding(10, 5, 10, 5);
                    simpleDraweeView.setMaxWidth(300);
                    simpleDraweeView.setMinimumWidth(300);
                    simpleDraweeView.setMaxHeight(500);
                    simpleDraweeView.setMinimumHeight(500);
                    simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
                    zhongjian_tvandiv_ll.addView(simpleDraweeView);
                    ImageLoader.getInstance().disPlayImage(simpleDraweeView, root.getData().getMessage().get(i).getMsg());
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

    public void getDataFromNet(){
        /**
         * 帖子赞网络请求
         */
        OkHttpUtil.post(DetailUrl.POST_ZAN_LIST, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if(response != null){
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    tieziZanBean = new Gson().fromJson(str,TieziZanBean.class);
                    Log.i("aaaaaa",tieziZanBean.toString());
                    addZanLayout(getActivity());
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        },getParam());
    }


    /**
     * 动态加载赞的布局
     */
    public void addZanLayout(Context context){
        if(tieziZanBean != null){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,10,10,10);
            TextView textView = new TextView(context);
            textView.setPadding(2,2,2,2);
            textView.setTextSize(14);
            tieziDetailZanLl.addView(textView);
            textView.setText("赞("+tieziZanBean.getData().size()+")");
            for(int i=0;i<tieziZanBean.getData().size();i++){
                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
                simpleDraweeView.setPadding(2,2,2,2);
                simpleDraweeView.setMaxHeight(50);
                simpleDraweeView.setMinimumWidth(50);
                simpleDraweeView.setMaxHeight(50);
                simpleDraweeView.setMinimumHeight(50);
                tieziDetailZanLl.addView(simpleDraweeView);
                ImageLoader.getInstance().disPlayImage(simpleDraweeView,tieziZanBean.getData().get(i).getAvtUrl());
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(50)
                        .setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
            }
        }

    }

    /**
     * 帖子赞参数
     */
    public List<OkHttpUtil.Param> getParam(){
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        String key1 = "a";
        String value1 = "threadZan";
        String key2 = "c";
        String value2 = "forumThread";
        String key3 = "tid";
        String value3 = tids;
        String key4 = "m";
        String value4 = "forum";
        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1,value1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2,value2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3,value3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4,value4);
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        return paramList;
    }


}
