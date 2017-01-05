package com.aiyiqi.aiyiqi_project.framework.utils.utils;


public class MainUrlUtils {
    /**
     * 首页
     */
    /*基础接口*/
    public static final String BASE_URL = "http://appapi.17house.com/";

    /*首页轮播*/
    public static final String First_Page = BASE_URL+"AppManagerApi.php";
    /**
     * 请求参数：
     action：getownerinfo
     cityId：2（此处固定值，因目前只有成都有内容）
     */


    /*文章（首页最下面列表数据，有帖子和新闻）*/
    public static final String BASE_URL2 = "http://bbs.17house.com/";
    /*第一页*/
    public static final String FIRST_PAGE = BASE_URL2+"motnt/index.php";

    /*加载更多*/
    public static final String DOWNLOAD_MORE = BASE_URL2+"motnt/index.php";

    /**
     * 请求参数：
     pageSize： 默认是10
     page： 页数，值等于上一页加1  page++
     type： 上一页最后一条数据的type值
     id： 上一页最后一条数据的id值
     */

}
