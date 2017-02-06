package com.aiyiqi.aiyiqi_project.assets;

import java.util.List;

/**
 * Created by Administrator on 2017/1/8.
 */

public class YeZhuBankuaiResultBean {

    /**
     * data : [[{"id":"4303","title":"成都装修论坛","icon":"http://bbs.17house.com/data/attachment/common/b0/common_4303_icon.png","threadsnum":"2799","postsnum":"10636"},{"id":"4304","title":"成都投诉表扬","icon":"http://bbs.17house.com/data/attachment/common/7e/common_4304_icon.png","threadsnum":"36","postsnum":"147"},{"id":"4608","title":"成都业主装修日记","icon":"http://bbs.17house.com/data/attachment/common/3c/common_4608_icon.png","threadsnum":"76","postsnum":"166"},{"id":"4306","title":"成都商家交流","icon":"http://bbs.17house.com/data/attachment/common/b0/common_4306_icon.png","threadsnum":"537","postsnum":"1042"}],[{"id":"22268","title":"一起美装","icon":"http://static-news.17house.com/web/bbs/201605/06/1754441718.jpg","threadsnum":"82","postsnum":191},{"id":"10027","title":"木门","icon":"http://static-news.17house.com/web/bbs/201604/20/1358187528.jpg","threadsnum":"341","postsnum":698},{"id":"10475","title":"橱柜","icon":"http://static-news.17house.com/web/bbs/201604/20/1358332470.jpg","threadsnum":"866","postsnum":1755},{"id":"5996","title":"地板","icon":"http://static-news.17house.com/web/bbs/201604/20/1357349797.jpg","threadsnum":"1112","postsnum":2236},{"id":"12087","title":"瓷砖","icon":"http://static-news.17house.com/web/bbs/201604/20/1400025645.jpg","threadsnum":"342","postsnum":698},{"id":"6172","title":"壁纸","icon":"http://static-news.17house.com/web/bbs/201604/20/1357517352.jpg","threadsnum":"444","postsnum":903}]]
     * error : 0
     * message : 成功
     */

    private String error;
    private String message;
    private List<List<DataBean>> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4303
         * title : 成都装修论坛
         * icon : http://bbs.17house.com/data/attachment/common/b0/common_4303_icon.png
         * threadsnum : 2799
         * postsnum : 10636
         */

        private String id;
        private String title;
        private String icon;
        private String threadsnum;
        private String postsnum;


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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getThreadsnum() {
            return threadsnum;
        }

        public void setThreadsnum(String threadsnum) {
            this.threadsnum = threadsnum;
        }

        public String getPostsnum() {
            return postsnum;
        }

        public void setPostsnum(String postsnum) {
            this.postsnum = postsnum;
        }
    }
}
