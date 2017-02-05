package com.aiyiqi.aiyiqi_project.view.detailactivity;


import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aiyiqi.aiyiqi_project.LoginActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.Root;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.DetailUrl;
import com.aiyiqi.aiyiqi_project.view.RepliceActivity;
import com.aiyiqi.aiyiqi_project.view.fragment.tiezidetailfragment.TieZiDetailFragment;
import com.aiyiqi.aiyiqi_project.view.fragment.tiezidetailfragment.TieZiRepliceFragment;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.google.gson.Gson;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.List;



public class TieZiDetailActivity extends BaseActivity implements View.OnClickListener{
    private EditText tiezi_back_edittext;
    private TextView tiezi_back_tv;
    private ImageView tiezi_bottom_like,tiezi_bottom_collect,tiezi_bottom_share;

    private String id;
    private String replices;
    private TieZiDetailFragment tieZiDetailFragment;
    private TieZiRepliceFragment tieZiRepliceFragment;
    private Root root;
    /**
     * 分享Dialog的
     */
    private TextView share_dialog_qq,share_dialog_wechat,share_dialog_wecharmoments,
            share_dialog_qzone,share_dialog_weibo;
    private Button share_button_cancle;

    /**
     * Dialog的显示
     * @return
     */
    public Dialog dialog;
    private View inflate;

    @Override
    public int getContentViewId() {
        return R.layout.tiezi_activity_layout;
    }

    @Override
    public void beforeInitView() {
        id = this.getIntent().getStringExtra("tiezi");
        replices = this.getIntent().getStringExtra("replies");
    }

    @Override
    public void initView() {
        tiezi_back_edittext = findViewByIdNoCast(R.id.tiezi_back_edittext);
        tiezi_back_tv = findViewByIdNoCast(R.id.tiezi_back_tv);
        tiezi_bottom_like = findViewByIdNoCast(R.id.tiezi_bottom_like);
        tiezi_bottom_collect = findViewByIdNoCast(R.id.tiezi_bottom_collect);
        tiezi_bottom_share = findViewByIdNoCast(R.id.tiezi_bottom_share);

        tieZiDetailFragment = (TieZiDetailFragment) getSupportFragmentManager().findFragmentById(R.id.tiezi_detail_fragment);
        tieZiRepliceFragment = (TieZiRepliceFragment) getSupportFragmentManager().findFragmentById(R.id.replice_fragment);
    }

    @Override
    public void initData() {
        setOnClick(tiezi_back_edittext,tiezi_back_tv,tiezi_bottom_like,tiezi_bottom_collect,tiezi_bottom_share);
        getDataFromNetwork();
    }



    /**
     * 网络请求
     */
    public void getDataFromNetwork(){
        OkHttpUtil.post(DetailUrl.POST_DETAIL, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if(response != null){
                    String s ;
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    if(str.contains("\"houseInfo\":[]")){
                        s = str.replace("\"houseInfo\":[]","\"houseInfo\":{}");
                    }
                    else{
                        s = str;
                    }
                    root = new Gson().fromJson(s,Root.class);
                    Log.i("msg",root.toString());
                    tieZiDetailFragment.setTieziFragment(TieZiDetailActivity.this,id,root);
                    tieZiRepliceFragment.setTieziFragment(TieZiDetailActivity.this,root.getData().getTid(),replices);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        },getParam());
    }

    /**
     * 参数
     */
    public List<OkHttpUtil.Param> getParam(){
        List<OkHttpUtil.Param> paramList = new ArrayList<>();
        String key1 = "tid";
        String vlaue1 = id;
        String key2 = "a";
        String vlaue2 = "viewThread";
        String key3 = "c";
        String vlaue3 = "forumThread";
        String key4 = "m";
        String vlaue4 = "forum";
        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1,vlaue1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2,vlaue2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3,vlaue3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4,vlaue4);
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        return paramList;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tiezi_back_edittext://点击回复跳转到回复的Activity
                startActivity(new Intent(this, RepliceActivity.class));
                break;
            case R.id.tiezi_back_tv:
                TieZiDetailActivity.this.finish();
                break;
            case R.id.tiezi_bottom_like:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.tiezi_bottom_collect:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.tiezi_bottom_share://分享
                showDialog();
                break;
            case R.id.share_dialog_qq:
                break;
            case R.id.share_dialog_wechat:
                break;
            case R.id.share_dialog_wecharmoments:
                break;
            case R.id.share_dialog_qzone:
                break;
            case R.id.share_dialog_weibo:
//                new ShareAction(TieZiDetailActivity.this).setPlatform(SHARE_MEDIA.SINA)
//                        .withText("你好").setCallback(umShareListener).share();
                break;
            case R.id.share_button_cancle:
                dialog.dismiss();
                break;
        }
    }

    /**
     * 显示分享的Dialog
     */
    public void showDialog(){
        dialog = new Dialog(this,R.style.photoDialog);
        inflate = LayoutInflater.from(this).inflate(R.layout.share_dialog_layout,null);
        dialog.setContentView(inflate);
        share_dialog_qq = (TextView) inflate.findViewById(R.id.share_dialog_qq);
        share_dialog_wechat = (TextView) inflate.findViewById(R.id.share_dialog_wechat);
        share_dialog_wecharmoments = (TextView) inflate.findViewById(R.id.share_dialog_wecharmoments);
        share_dialog_qzone = (TextView) inflate.findViewById(R.id.share_dialog_qzone);
        share_dialog_weibo = (TextView) inflate.findViewById(R.id.share_dialog_weibo);
        share_button_cancle = (Button) inflate.findViewById(R.id.share_button_cancle);
        share_dialog_qq.setOnClickListener(this);
        share_dialog_wechat.setOnClickListener(this);
        share_dialog_wecharmoments.setOnClickListener(this);
        share_dialog_qzone.setOnClickListener(this);
        share_dialog_weibo.setOnClickListener(this);
        share_button_cancle.setOnClickListener(this);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = window.getAttributes();
        Display d = window.getWindowManager().getDefaultDisplay();
        //获取屏幕宽
        lp.width = d.getWidth();
        lp.y = 0;
        window.setAttributes(lp);
        dialog.show();
    }

    /**
     * 友盟微博分享回调接口
     */
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            //Log.d("plat","platform"+platform);

            Toast.makeText(TieZiDetailActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(TieZiDetailActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                //Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(TieZiDetailActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

}
