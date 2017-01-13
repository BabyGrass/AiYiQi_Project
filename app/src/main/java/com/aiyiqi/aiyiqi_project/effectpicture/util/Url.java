package com.aiyiqi.aiyiqi_project.effectpicture.util;

/**
 * Created by Administrator on 2017/1/7.
 */

public class Url  {
    //活动的接口
    public static final String HUODONG_URL = "http://bbs.17house.com/motnt/index.php?a=activityThreadlist&c=forumThreadList&uuid=a444d1b2af4f&pageSize=10&uid=1633055&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    //效果图接口
    public static final String HEADER = "http://appapi.17house.com/xiaoguotuApi.php?";
    public static final String ZHUANTI_URL = HEADER + "version=1&page=1&action=albumList2&pageSize=10&tagid=1&model=android";
    public static final String MEITU = HEADER + "version=1&page=1&action=imageList2&pageSize=10&tagid=0&model=android";
    //装修学堂
    public static final String DECORATE_HEADER = "http://appapi.17house.com/StageApi.php?";
    public static final String DECORATE_SCHOOL_TAG = DECORATE_HEADER + "version=1&action=getTagsByStage&stage=1&model=android";
    public static final String DECORATE_SCHOOL_NEWS = DECORATE_HEADER + "version=1&action=getNewsByStage&stage=1&page=1&pagesize=10&model=android";
}
