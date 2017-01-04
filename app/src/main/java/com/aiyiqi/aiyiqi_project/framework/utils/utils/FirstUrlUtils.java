package com.aiyiqi.aiyiqi_project.framework.utils.utils;


public class FirstUrlUtils {
    /* 基础接口*/
    public static final String BASE_URL = "http://appapi.17house.com/";

    /* 首页轮播*/

    public static final String First_bo = "AppManagerApi.php";

    /*文章（首页最下面列表数据，有帖子和新闻）*/
    public static final String BASE_URL2 = "http://bbs.17house.com/";
    /*第一页*/
    public static final String FIRST_PAGE = "motnt/index.php";

    /*加载更多*/
    public static final String DOWNLOAD_MORE = "motnt/index.php";


/*首页装修公司、同城活动等8个模块胡接口*/

    /**

     装修公司
     */

/*基础接口*/
    public static final String BASE_URL3 = "http://appapi.17house.com/";
    /*装修公司轮播广告*/
    public static final String CAROUSEL_ADVERTISING = "AppManagerApi.php";
    /*装修直播*/
    public static final String DECORATION_LIVE = "http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites";

/*
 请求方式：POST

    请求参数：
            token: DAB088BA50C9405E84C789055D657614
            city_id: 2
            cityName: 成都
            app_version: android_com.aiyiqi.galaxy_1.1
*/


    /*新房整装(h5网页)*/
    public static final String NEW_OUTFIT = "http://hui.17house.com/svc/payment-facade/h5/activity677/index.html?model=android";

    /*老房整装(h5网页)*/
    public static final String OLD_OUTFIT = "http://hui.17house.com/svc/payment-facade/h5/activity177/index.html?model=android";

    /*看现场（暂时预留，等讲完百度地图之后再做）*/
    public static final String LOOK_LIVE = "http://118.178.142.34/YiQiHouse/OnSite";


/*工地直播*/


    /*基本信息(人员及工程进度)*/
    public static final String BASE_MESSAGE = "http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite";

/*
 请求参数：
            token: DAB088BA50C9405E84C789055D657614
            app_version: android_com.aiyiqi.galaxy_1.1
            buildingId： 建筑id，此处取0的接口信息
            （如果从装修直播贴中进入工地直播，则替换buildingId值）
*/

    /*装修进度晒图评价列表*/
    public static final String EVALUATE_LIST = " http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteTrackByProgress";

/*
请求方式：POST

    请求参数：
        progressId： 进度Id，此处为1
        app_version : android_com.aiyiqi.galaxy_1.1（固定参数）
        buildingId :  建筑id（装修公司页面返回的）
        page : 页数
        pageSize： 一页的数据条数，默认10
*/


    /*一起团队*/
    public static final String GO_TEAM = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors";

/*
 请求方式：POST

    请求参数：
          token: DAB088BA50C9405E84C789055D657614
        app_version : android_com.aiyiqi.galaxy_1.1（固定参数）
        type: 1701（设计师），1702（监理），1703（工长）
        haspermission: yes
        pageNo : 页数，默认0
        pageSize： 一页的数据条数，默认10
*/


}
