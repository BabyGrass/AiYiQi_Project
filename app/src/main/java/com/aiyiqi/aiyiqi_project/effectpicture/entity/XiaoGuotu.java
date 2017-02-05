package com.aiyiqi.aiyiqi_project.effectpicture.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */

public class XiaoGuotu implements Serializable {

    /**
     * error : 0
     * message : ok
     * data : {"totalCount":"515","list":[{"id":"605240","title":"电影空间：黑白日耳曼系北欧风一居室","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201612/06/201612061357054807.jpg","desc":"日耳曼系的简洁北欧风与黑白戏剧效果融合至室内设计中，黑白空间像电影一样性感迷人。","collected":"0","iscollect":0},{"id":"605235","title":"80㎡清新美式两居，你也可以这么装","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201611/02/201611021440467754.jpg","desc":"只有80㎡，却想要一个温馨又充满逼格的家？那你必须看看这个。","collected":"18","iscollect":0},{"id":"605234","title":"层高只有2.5米，如何装修不压抑？","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/27/201610271029579728.jpg","desc":"辛辛苦苦攒够钱，买了房子，却发现房子的层高只有区区2.5米，怎么看都觉得矮，怎么办？","collected":"4","iscollect":0},{"id":"605228","title":"30张图告诉你灰色珊瑚色如何搭配","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/13/201610131518046960.jpg","desc":"继公主粉之后，灰色最近又撩了个新妹\u2014\u2014珊瑚色。如果说奶奶灰+公主粉代表是优雅，那恬静灰+珊瑚色则是梦幻和温暖。","collected":"6","iscollect":0},{"id":"605227","title":"后悔了！装修完才知道飘窗还可以这么设计","like_num":"2","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/12/201610120949004486.jpg","desc":"现在的房子，很多都有飘窗。但是对于这个比窗台略宽的小空间很多人觉得好看，却不知道该用来干嘛。","collected":"8","iscollect":0},{"id":"605224","title":"房价这么贵 大神教你小空间极致利用","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/09/201610091611539826.jpg","desc":"房价那么贵，能买到房已经实属不易，怎么可以让任何一寸空间浪费？","collected":"12","iscollect":0},{"id":"605222","title":"不将就！小户型也要挤出餐区","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/28/201609281101095933.jpg","desc":"回家吃饭是一种生活态度。房子再小也是家，房子再小也得有个餐区，生活不将就！","collected":"4","iscollect":0},{"id":"605220","title":"最全小户型置物架攻略，收纳达人必看!","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/22/201609221152001055.JPEG","desc":"摆放置物架是家居收纳问题最简单的解决方式。一款造型美观又实用的置物架，不仅满足收纳需求，还能为家居空间增添几分文艺清新范儿，是小户型和租房者的最爱。在此献上创意独特的小户型必备置物架，拿走不谢!","collected":"18","iscollect":0},{"id":"605216","title":"一张圆桌拯救一个小户型","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/07/201609071527018776.jpg","desc":"圆桌占空间？那都是大house的专利？你错了！空间利用是个技术活，有的时候，一张看似占空间的圆桌却能妥妥地拯救一个小户型。","collected":"16","iscollect":0},{"id":"605214","title":"12种在客厅创造出一间卧室的妙招","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/01/201609011425328719.png","desc":"房子太小，又想多要一间卧室，怎么办？很多人把目光投向了还算宽敞的客厅。在客厅隔出一间卧室可是个技术活，看看外国的达人们都是怎么做的？","collected":"2","iscollect":0}]}
     */

    private int error;
    public String message;
    /**
     * totalCount : 515
     * list : [{"id":"605240","title":"电影空间：黑白日耳曼系北欧风一居室","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201612/06/201612061357054807.jpg","desc":"日耳曼系的简洁北欧风与黑白戏剧效果融合至室内设计中，黑白空间像电影一样性感迷人。","collected":"0","iscollect":0},{"id":"605235","title":"80㎡清新美式两居，你也可以这么装","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201611/02/201611021440467754.jpg","desc":"只有80㎡，却想要一个温馨又充满逼格的家？那你必须看看这个。","collected":"18","iscollect":0},{"id":"605234","title":"层高只有2.5米，如何装修不压抑？","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/27/201610271029579728.jpg","desc":"辛辛苦苦攒够钱，买了房子，却发现房子的层高只有区区2.5米，怎么看都觉得矮，怎么办？","collected":"4","iscollect":0},{"id":"605228","title":"30张图告诉你灰色珊瑚色如何搭配","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/13/201610131518046960.jpg","desc":"继公主粉之后，灰色最近又撩了个新妹\u2014\u2014珊瑚色。如果说奶奶灰+公主粉代表是优雅，那恬静灰+珊瑚色则是梦幻和温暖。","collected":"6","iscollect":0},{"id":"605227","title":"后悔了！装修完才知道飘窗还可以这么设计","like_num":"2","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/12/201610120949004486.jpg","desc":"现在的房子，很多都有飘窗。但是对于这个比窗台略宽的小空间很多人觉得好看，却不知道该用来干嘛。","collected":"8","iscollect":0},{"id":"605224","title":"房价这么贵 大神教你小空间极致利用","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201610/09/201610091611539826.jpg","desc":"房价那么贵，能买到房已经实属不易，怎么可以让任何一寸空间浪费？","collected":"12","iscollect":0},{"id":"605222","title":"不将就！小户型也要挤出餐区","like_num":"1","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/28/201609281101095933.jpg","desc":"回家吃饭是一种生活态度。房子再小也是家，房子再小也得有个餐区，生活不将就！","collected":"4","iscollect":0},{"id":"605220","title":"最全小户型置物架攻略，收纳达人必看!","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/22/201609221152001055.JPEG","desc":"摆放置物架是家居收纳问题最简单的解决方式。一款造型美观又实用的置物架，不仅满足收纳需求，还能为家居空间增添几分文艺清新范儿，是小户型和租房者的最爱。在此献上创意独特的小户型必备置物架，拿走不谢!","collected":"18","iscollect":0},{"id":"605216","title":"一张圆桌拯救一个小户型","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/07/201609071527018776.jpg","desc":"圆桌占空间？那都是大house的专利？你错了！空间利用是个技术活，有的时候，一张看似占空间的圆桌却能妥妥地拯救一个小户型。","collected":"16","iscollect":0},{"id":"605214","title":"12种在客厅创造出一间卧室的妙招","like_num":"0","comment_count":"0","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201609/01/201609011425328719.png","desc":"房子太小，又想多要一间卧室，怎么办？很多人把目光投向了还算宽敞的客厅。在客厅隔出一间卧室可是个技术活，看看外国的达人们都是怎么做的？","collected":"2","iscollect":0}]
     */

    public DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String totalCount;
        /**
         * id : 605240
         * title : 电影空间：黑白日耳曼系北欧风一居室
         * like_num : 0
         * comment_count : 0
         * url : http://static-xiaoguotu.17house.com/web/xiaoguotu/201612/06/201612061357054807.jpg
         * desc : 日耳曼系的简洁北欧风与黑白戏剧效果融合至室内设计中，黑白空间像电影一样性感迷人。
         * collected : 0
         * iscollect : 0
         */

        public List<ListBean> list;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            public String id;
            public String title;
            public String like_num;
            public String comment_count;
            public String url;
            public String desc;
            public String collected;
            public String iscollect;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLike_num() {
                return like_num;
            }

            public void setLike_num(String like_num) {
                this.like_num = like_num;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getCollected() {
                return collected;
            }

            public void setCollected(String collected) {
                this.collected = collected;
            }

            public String getIscollect() {
                return iscollect;
            }

            public void setIscollect(String iscollect) {
                this.iscollect = iscollect;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", like_num='" + like_num + '\'' +
                        ", comment_count='" + comment_count + '\'' +
                        ", url='" + url + '\'' +
                        ", desc='" + desc + '\'' +
                        ", collected='" + collected + '\'' +
                        ", iscollect='" + iscollect + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "XiaoGuotu{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
