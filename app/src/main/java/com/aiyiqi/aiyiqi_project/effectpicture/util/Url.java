package com.aiyiqi.aiyiqi_project.effectpicture.util;

/**
 * Created by Administrator on 2017/1/7.
 */

public class Url  {
    //活动的接口
    public static final String HEADER_HUODONG = "http://bbs.17house.com/motnt/index.php?";
    //效果图接口
    public static final String HEADER = "http://appapi.17house.com/xiaoguotuApi.php?";
    public static final String ZHUANTI_URL = HEADER + "version=1&page=1&action=albumList2&pageSize=10&tagid=1&model=android";
    public static final String MEITU = HEADER + "version=1&page=1&action=imageList2&pageSize=10&tagid=0&model=android";
    //装修学堂
    public static final String DECORATE_HEADER = "http://appapi.17house.com/StageApi.php?";
    public static final String DECORATE_HEADER1 = "http://appapi.17house.com/NewsApi.php?";
    public static final String DECORATE_SCHOOL_TAG = DECORATE_HEADER + "version=1&action=getTagsByStage&stage=1&model=android";
    public static final String DECORATE_SCHOOL_NEWS = DECORATE_HEADER1 + "version=1&action=getNewsByStage&stage=1&page=1&pagesize=10&model=android";
    public static final String DECORATE_SCHOOL_DETAIL = DECORATE_HEADER1 + "version=1&relatedNum=3&action=newsDetail&page=1&newsId=261583&model=android";
}
