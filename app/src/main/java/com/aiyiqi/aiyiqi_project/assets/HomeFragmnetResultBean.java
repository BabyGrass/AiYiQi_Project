package com.aiyiqi.aiyiqi_project.assets;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class HomeFragmnetResultBean implements Parcelable{

    /**
     * data : [{"type":3,"id":"1225449","title":"螃蟹一家人的挪窝历程（二）","author":"横着爬","uid":"90481","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=90481&size=big","dateline":"15小时前","sort":"1483629115","views":"142","replies":"2","like_num":1,"path":"http://static-news.17house.com/web/bbs/201701/05/2311058578.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"261388","title":"45㎡甜蜜公寓处处是亮点，享受专属两个人的小生活","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201701/05/201701051643022733.jpg","views":258,"like_num":0,"replies":"0","dateline":"22小时前","sort":"1483606140","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/261388.html"},{"type":1,"id":"261387","title":"我家有一面墙美得一塌糊涂！","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201701/05/201701051635018415.jpg","views":217,"like_num":0,"replies":"0","dateline":"22小时前","sort":"1483605427","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/261387.html"},{"type":1,"id":"261386","title":"还在用华丽大水晶灯？这样真的有点土豪","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201701/05/201701051631335493.jpg","views":196,"like_num":0,"replies":"0","dateline":"22小时前","sort":"1483605130","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/261386.html"},{"type":3,"id":"1225384","title":"环保家装四大要点N项注意，绿色家装全指南","author":"long-北京","uid":"1531237","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1531237&size=big","dateline":"2天前","sort":"1483585148","views":"156","replies":"1","like_num":3,"path":"http://static-news.17house.com/bbs/forum/201701/05/105243ei4hiks7zvcskyiy.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"261375","title":"黑白灰三色打造的家，想要的生活就是这么简单！","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201701/04/201701041600103892.jpg","views":361,"like_num":0,"replies":"0","dateline":"2天前","sort":"1483516899","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/261375.html"},{"type":1,"id":"261374","title":"小空间怎么布置有情调又实用？","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201701/04/201701041530128734.jpg","views":558,"like_num":0,"replies":"0","dateline":"2天前","sort":"1483515758","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/261374.html"},{"type":1,"id":"261373","title":"墙面刷一半 fashion不一般","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201701/04/201701041521398234.jpg","views":289,"like_num":0,"replies":"0","dateline":"2天前","sort":"1483514607","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/261373.html"},{"type":3,"id":"1225294","title":"螃蟹一家人的挪窝历程（一）","author":"横着爬","uid":"90481","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=90481&size=big","dateline":"3天前","sort":"1483453350","views":"275","replies":"9","like_num":6,"path":"http://static-news.17house.com/web/bbs/201701/03/2221146909.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"261358","title":"2017年告别木地板和瓷砖，给地面来点水泥味吧","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201701/03/201701031600151040.jpg","views":563,"like_num":0,"replies":"0","dateline":"3天前","sort":"1483430669","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/261358.html"}]
     * newCount : 150
     * currentPage : 1
     * totalCount : 150
     * error : 0
     * message : 成功
     */

    private String newCount;
    private String currentPage;
    private String totalCount;
    private String error;
    private String message;
    /**
     * type : 3
     * id : 1225449
     * title : 螃蟹一家人的挪窝历程（二）
     * author : 横着爬
     * uid : 90481
     * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=90481&size=big
     * dateline : 15小时前
     * sort : 1483629115
     * views : 142
     * replies : 2
     * like_num : 1
     * path : http://static-news.17house.com/web/bbs/201701/05/2311058578.jpg!w720
     * forum : {"fid":"2","name":"北京装修论坛"}
     * followed : 0
     */

    private List<DataBean> data;

    protected HomeFragmnetResultBean(Parcel in) {
        newCount = in.readString();
        currentPage = in.readString();
        totalCount = in.readString();
        error = in.readString();
        message = in.readString();
        data = in.createTypedArrayList(DataBean.CREATOR);
    }

    public static final Creator<HomeFragmnetResultBean> CREATOR = new Creator<HomeFragmnetResultBean>() {
        @Override
        public HomeFragmnetResultBean createFromParcel(Parcel in) {
            return new HomeFragmnetResultBean(in);
        }

        @Override
        public HomeFragmnetResultBean[] newArray(int size) {
            return new HomeFragmnetResultBean[size];
        }
    };

    public String getNewCount() {
        return newCount;
    }

    public void setNewCount(String newCount) {
        this.newCount = newCount;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(newCount);
        dest.writeString(currentPage);
        dest.writeString(totalCount);
        dest.writeString(error);
        dest.writeString(message);
        dest.writeTypedList(data);
    }

    public static class DataBean  implements Parcelable{
        private String type;
        private String id;
        private String title;
        private String author;
        private String uid;
        private String avtUrl;
        private String dateline;
        private String sort;
        private String views;
        private String replies;
        private String like_num;
        private String path;
        /**
         * fid : 2
         * name : 北京装修论坛
         */

        private ForumBean forum;
        private String followed;
        private String h5Url;

        protected DataBean(Parcel in) {
            type = in.readString();
            id = in.readString();
            title = in.readString();
            author = in.readString();
            uid = in.readString();
            avtUrl = in.readString();
            dateline = in.readString();
            sort = in.readString();
            views = in.readString();
            replies = in.readString();
            like_num = in.readString();
            path = in.readString();
            followed = in.readString();
            h5Url = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        @Override
        public String toString() {
            return "DataBean{" +
                    "type='" + type + '\'' +
                    ", id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", uid='" + uid + '\'' +
                    ", avtUrl='" + avtUrl + '\'' +
                    ", dateline='" + dateline + '\'' +
                    ", sort='" + sort + '\'' +
                    ", views='" + views + '\'' +
                    ", replies='" + replies + '\'' +
                    ", like_num='" + like_num + '\'' +
                    ", path='" + path + '\'' +
                    ", forum=" + forum +
                    ", followed='" + followed + '\'' +
                    ", h5Url='" + h5Url + '\'' +
                    '}';
        }

        /**
         * fid : 0
         * name :
         */




        public String getH5Url() {
            return h5Url;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReplies() {
            return replies;
        }

        public void setReplies(String replies) {
            this.replies = replies;
        }

        public String getLike_num() {
            return like_num;
        }

        public void setLike_num(String like_num) {
            this.like_num = like_num;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public ForumBean getForum() {
            return forum;
        }

        public void setForum(ForumBean forum) {
            this.forum = forum;
        }

        public String getFollowed() {
            return followed;
        }

        public void setFollowed(String followed) {
            this.followed = followed;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(type);
            dest.writeString(id);
            dest.writeString(title);
            dest.writeString(author);
            dest.writeString(uid);
            dest.writeString(avtUrl);
            dest.writeString(dateline);
            dest.writeString(sort);
            dest.writeString(views);
            dest.writeString(replies);
            dest.writeString(like_num);
            dest.writeString(path);
            dest.writeString(followed);
            dest.writeString(h5Url);
        }

        public static class ForumBean {
            private String fid;
            private String name;

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
