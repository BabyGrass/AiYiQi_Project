package com.aiyiqi.aiyiqi_project;

import com.finesdk.BaseApplication;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;


/**
 * Created by Administrator on 2017/1/6.
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        PlatformConfig.setSinaWeibo("1973269772","e06aa8094c86d8cf6a3a3582834b019b");
        Config.REDIRECT_URL = "aiyiqi_project.WBShareActivity";//新浪后台的分享地址
    }


}