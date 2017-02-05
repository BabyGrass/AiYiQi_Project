package com.aiyiqi.aiyiqi_project;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.view.fragment.HomeFragment;
import com.aiyiqi.aiyiqi_project.view.fragment.MessageFragment;
import com.aiyiqi.aiyiqi_project.view.fragment.MineFragment;
import com.aiyiqi.aiyiqi_project.view.fragment.YeZhuTalkFragment;
import com.finesdk.activity.BaseActivity;
import com.finesdk.util.common.ToastUtil;

public class MainActivity extends BaseActivity {
    private LinearLayout souye_ll,yezhu_ll,msg_ll,mine_ll;
    private TextView tv1,tv2,tv3,tv4;
    private TextView [] textViews = null;
    private ImageView iv1,iv2,iv3,iv4;
    private ImageView [] imageViews = null;
    //改变的图片
    private int image_change[] = {R.drawable.main_tab_home_selected, R.drawable.main_tab_community_selected
            , R.drawable.main_tab_msg_selected, R.drawable.main_tab_my_selected};
    //不改变的图片
    private int image_Nochange[] = {R.drawable.main_tab_home_normal, R.drawable.main_tab_community_normal
            , R.drawable.main_tab_msg_normal, R.drawable.main_tab_my_normal};
    //Fragment
    private HomeFragment homeFragment;
    private YeZhuTalkFragment yeZhuTalkFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        souye_ll = findViewByIdNoCast(R.id.souye_ll);
        yezhu_ll = findViewByIdNoCast(R.id.yezhu_ll);
        msg_ll = findViewByIdNoCast(R.id.msg_ll);
        mine_ll = findViewByIdNoCast(R.id.mine_ll);
        setOnClick(souye_ll,yezhu_ll,msg_ll,mine_ll);

        tv1 = findViewByIdNoCast(R.id.souye_tv);
        tv2 = findViewByIdNoCast(R.id.yezhu_tv);
        tv3 = findViewByIdNoCast(R.id.msg_tv);
        tv4 = findViewByIdNoCast(R.id.mine_tv);
        textViews = new TextView[]{tv1,tv2,tv3,tv4};

        iv1 = findViewByIdNoCast(R.id.souye_iv);
        iv2 = findViewByIdNoCast(R.id.yezhu_ll_iv);
        iv3 = findViewByIdNoCast(R.id.msg_iv);
        iv4 = findViewByIdNoCast(R.id.mine_iv);
        imageViews = new ImageView[]{iv1,iv2,iv3,iv4};

        //设置默认显示的
        setDefaultFragment();
    }

    /**
     * 设置默认显示的Fragment
     */
    private void setDefaultFragment() {
       FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = new HomeFragment();
       transaction.replace(R.id.rl, homeFragment);
       transaction.commit();
        textViews[0].setTextColor(Color.GREEN);
        imageViews[0].setImageResource(image_change[0]);
        }



    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch(v.getId()){
            case R.id.souye_ll:
                if(homeFragment == null){
                    homeFragment = new HomeFragment();
                }
                transaction.replace(R.id.rl,homeFragment);
                setClickChange(0);
                break;
            case R.id.yezhu_ll:
                if(yeZhuTalkFragment == null){
                    yeZhuTalkFragment = new YeZhuTalkFragment();
                }
                transaction.replace(R.id.rl,yeZhuTalkFragment);
                setClickChange(1);
                break;
            case R.id.msg_ll:
                if(messageFragment == null){
                    messageFragment = new MessageFragment();
                }
                transaction.replace(R.id.rl,messageFragment);
                setClickChange(2);
                break;
            case R.id.mine_ll:
                if(mineFragment == null){
                    mineFragment = new MineFragment();
                }
                transaction.replace(R.id.rl,mineFragment);
                setClickChange(3);
                break;
        }
        transaction.commit();
    }

    /**
     * 设置颜色和改变图片的方法
     */
    public void setClickChange(int position){
        for(int i =0;i<textViews.length;i++){
            if(i == position){
                textViews[i].setTextColor(Color.GREEN);
                imageViews[i].setImageResource(image_change[i]);
            }
            else{
                textViews[i].setTextColor(Color.BLACK);
                imageViews[i].setImageResource(image_Nochange[i]);
            }
        }
    }


    /**
     * 监听Back键
     */
    private static final int TIEMS = 2000;

    private boolean isBack = true;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(isBack){//判断是否点击返回键
               ToastUtil.showToast("再按一下 返回键 退出应用");
               isBack = false;
               mHandler.sendEmptyMessageDelayed(10001,TIEMS);//2秒钟之后发送消息
            }else{
               finish();//否者取消
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 10001:
                    isBack = true;
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }




}
