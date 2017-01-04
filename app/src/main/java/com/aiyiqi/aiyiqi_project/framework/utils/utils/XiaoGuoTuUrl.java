package com.aiyiqi.aiyiqi_project.framework.utils.utils;


public class XiaoGuoTuUrl {
    /*效果图（目前只做列表显示）*/

    public static final String BASE_URL = "http://appapi.17house.com/";

    /*专题*/
    public static final String SPECIAL = "xiaoguotuApi.php";

/*
请求参数：
    version：版本，此处为固定值1
    page：页数
    pagesize：一页的数据条数
    action：ablumList2（专题）
    tagid ： 1
    model：android（固定值）
*/



    /*美图（此处筛选只做弹框效果）*/
    public static final String BEAUTI_IMAGE = "xiaoguotuApi.php";


/*
请求参数：
    version：版本，此处为固定值1
    page：页数
    pagesize：一页的数据条数
    action：imageList2（美图）
    tagid ： 0（全部），筛选的话更换tagid即可，多项筛选tagid格式为 1，1，1，1
    model：android（固定值）

*/
}
