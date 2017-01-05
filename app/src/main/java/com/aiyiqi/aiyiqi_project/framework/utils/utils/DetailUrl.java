package com.aiyiqi.aiyiqi_project.framework.utils.utils;


public class DetailUrl {
    /*详情接口*/

    /*文章详情*/
    public static final String ARTICLE_DETAIL = "http://appapi.17house.com/NewsApi.php";

/*
请求参数：
    version：版本，此处为固定值1
    action：newsDetail
    newsId： 新闻Id
    page : 1
    relatedNum：相关文章返回的条数，此处默认给3个推荐文章
    model：android（固定值）
*/


/*帖子详情*/

    public static final String POST_DETAIL = "http://bbs.17house.com/motnt/index.php";

/*
请求参数：
    tid： 帖子id
    其他参数不变
*/





/*详情页面的评论和赞列表*/

    public static final String POST_ZAN_LIST = "http://bbs.17house.com/motnt/index.php";



/*
请求参数：
    a：threadZan（赞）
    tid：帖子id

*/


/*帖子评论列表*/

    public static final String POST_PINLUN_LIST = "http://bbs.17house.com/motnt/index.php";


/*
请求参数：
    a：viewThread（评论）
    tid：帖子id
    page: 页数
*/



    /*文章评论列表（文章没有赞列表）*/
    public static final String ARTICLE_PINLUN_LIST = "http://appapi.17house.com/newsApi.php";


/*
请求参数：
    page：1
    dataId：新闻id
    action：commentList（评论列表）
    limit：10 ，限制评论条数为10
*/


}
