package com.aiyiqi.aiyiqi_project.assets;


import java.util.List;

public class ViewPagerImageUrl {

    /**
     * error : 0
     * message : ok
     * data : [{"title":"一起装修网成功上市","imagesrc":"http://appmanager.17house.com/upload/20161219/5857a5dbf1dc1_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161219/5857a5dc162dd_t.jpg","tid":"","type":4,"banner_url":"http://www.17house.com/news/260806.html"},{"title":"上市感恩大酬宾","imagesrc":"http://appmanager.17house.com/upload/20161224/585e86d475b7d_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161224/585e86d49ab81_t.jpg","tid":"","type":4,"banner_url":"http://wap.17house.com/tuan/2775.html"},{"title":"装修省40%的秘笈，看这里！","imagesrc":"http://appmanager.17house.com/upload/20161231/5867950d892e9_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161231/5867950db156b_t.jpg","tid":"","type":4,"banner_url":"http://tuan.17house.com/bj/2764k0s1e2008.html"},{"title":"0元装修","imagesrc":"http://appmanager.17house.com/upload/20161109/5822e89f15dc6_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161109/5822e89f371ab_t.jpg","tid":"","type":4,"banner_url":"http://wap.17house.com/daikuan/"},{"title":"全包装修80平米仅需5.4万","imagesrc":"http://appmanager.17house.com/upload/20160712/5784c5d8ec177_t.png","imagesrc2":"http://appmanager.17house.com/upload/20160712/5784c5d91e7a3_t.png","tid":"","type":4,"banner_url":"http://beijing.17zhuangxiu.com/zhengzhuang/"},{"title":"互联网家装户型设计大赛开赛啦！","imagesrc":"http://appmanager.17house.com/upload/20161209/584a865218887_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161209/584a86524bbdb_t.jpg","tid":"","type":4,"banner_url":"http://wap.17house.com/shejidasai/"}]
     */

    private int error;
    private String message;
    /**
     * title : 一起装修网成功上市
     * imagesrc : http://appmanager.17house.com/upload/20161219/5857a5dbf1dc1_t.jpg
     * imagesrc2 : http://appmanager.17house.com/upload/20161219/5857a5dc162dd_t.jpg
     * tid :
     * type : 4
     * banner_url : http://www.17house.com/news/260806.html
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private String imagesrc;
        private String imagesrc2;
        private String tid;
        private int type;
        private String banner_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImagesrc() {
            return imagesrc;
        }

        public void setImagesrc(String imagesrc) {
            this.imagesrc = imagesrc;
        }

        public String getImagesrc2() {
            return imagesrc2;
        }

        public void setImagesrc2(String imagesrc2) {
            this.imagesrc2 = imagesrc2;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getBanner_url() {
            return banner_url;
        }

        public void setBanner_url(String banner_url) {
            this.banner_url = banner_url;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "title='" + title + '\'' +
                    ", imagesrc='" + imagesrc + '\'' +
                    ", imagesrc2='" + imagesrc2 + '\'' +
                    ", tid='" + tid + '\'' +
                    ", type=" + type +
                    ", banner_url='" + banner_url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ViewPagerImageUrl{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
