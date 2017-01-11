package com.aiyiqi.aiyiqi_project.city.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class CityEntity implements Serializable{

    private DataBean data;
    /**
     * data : {"forumlist":[{"tid":"0","fid":"0","subject":"1月7日【成都】一起装修网上市感恩大酬宾","author":"成都站","authorid":"0","avtUrl":"","dateline":"","lastpost":"","lastposter":"","views":"","replies":"","forumname":"","displayorder":"","typeid":"","digest":"","urls":"","groupon_urls":"http://m.17house.com/tuan/2772.html","attachment":"","starttimefrom":0,"expiration":1483804799000,"attachments":"http://apptest-picture.oss-cn-beijing.aliyuncs.com/tuangouhui/tuangouhaibao2.jpg","activityclose":0,"isfollow":0,"iszan":0,"isfavorite":0},{"tid":"1204153","fid":"4303","subject":"报名天猫&一起装修网 · 中秋万人团购（9月15-16日），签到送好礼啦~~","author":"一起网小天","authorid":"1293480","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1293480&size=small","dateline":"2016-08-01","lastpost":"2016-08-30","lastposter":"一起网小天","views":"521","replies":"0","forumname":"成都装修论坛","displayorder":"0","typeid":"0","digest":"1","urls":"http://bbs.17house.com/thread-1204153-1-1.html","attachment":"2","starttimefrom":1471536000000,"expiration":1474016400000,"attachments":"http://bbs.17house.com/data/attachment/forum/201608/18/171503od4hmhmabp1mvi8z.jpg","activityclose":1,"isfollow":0,"iszan":0,"isfavorite":0},{"tid":"1202096","fid":"4303","subject":"报名7月24日建材家具活动，签到送好礼啦~~","author":"一起网小天","authorid":"1293480","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1293480&size=small","dateline":"2016-07-04","lastpost":"2016-07-18","lastposter":"一起网小天","views":"338","replies":"0","forumname":"成都装修论坛","displayorder":"0","typeid":"129","digest":"1","urls":"http://bbs.17house.com/thread-1202096-1-1.html","attachment":"2","starttimefrom":1469325600000,"expiration":1469339220000,"attachments":"http://bbs.17house.com/data/attachment/forum/201607/04/141407j2aeial4euiumejl.jpg","activityclose":1,"isfollow":0,"iszan":0,"isfavorite":0},{"tid":"1202789","fid":"4303","subject":"定制家具特价抢先在知！报名7月24日活动，签到送好礼~~","author":"一起网小天","authorid":"1293480","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1293480&size=small","dateline":"2016-07-14","lastpost":"2016-07-18","lastposter":"一起网小天","views":"264","replies":"0","forumname":"成都装修论坛","displayorder":"0","typeid":"0","digest":"1","urls":"http://bbs.17house.com/thread-1202789-1-1.html","attachment":"2","starttimefrom":1469325600000,"expiration":1469289600000,"attachments":"http://bbs.17house.com/data/attachment/forum/201607/14/090157hva8oohhh97ue5qs.jpg","activityclose":1,"isfollow":0,"iszan":0,"isfavorite":0},{"tid":"1199814","fid":"4303","subject":"报名6月19日建材家具活动，下单送好礼啦~~","author":"一起网小天","authorid":"1293480","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1293480&size=small","dateline":"2016-06-06","lastpost":"2016-06-06","lastposter":"一起网小天","views":"421","replies":"0","forumname":"成都装修论坛","displayorder":"0","typeid":"0","digest":"0","urls":"http://bbs.17house.com/thread-1199814-1-1.html","attachment":"1","starttimefrom":1466305200000,"expiration":1466265600000,"attachments":"http://bbs.17house.com/data/attachment/forum/201606/06/152701euzidved7btewowd.jpg","activityclose":1,"isfollow":0,"iszan":0,"isfavorite":0}]}
     * currentPage : 1
     * totalCount : 5
     * error : 0
     * message : 成功
     */

    public String currentPage;
    public String totalCount;
    public String error;
    public String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "CityEntity{" +
                "data=" + data +
                ", currentPage='" + currentPage + '\'' +
                ", totalCount='" + totalCount + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static class DataBean {
        /**
         * tid : 0
         * fid : 0
         * subject : 1月7日【成都】一起装修网上市感恩大酬宾
         * author : 成都站
         * authorid : 0
         * avtUrl :
         * dateline :
         * lastpost :
         * lastposter :
         * views :
         * replies :
         * forumname :
         * displayorder :
         * typeid :
         * digest :
         * urls :
         * groupon_urls : http://m.17house.com/tuan/2772.html
         * attachment :
         * starttimefrom : 0
         * expiration : 1483804799000
         * attachments : http://apptest-picture.oss-cn-beijing.aliyuncs.com/tuangouhui/tuangouhaibao2.jpg
         * activityclose : 0
         * isfollow : 0
         * iszan : 0
         * isfavorite : 0
         */

        public List<ForumlistBean> forumlist;

        public List<ForumlistBean> getForumlist() {
            return forumlist;
        }

        public void setForumlist(List<ForumlistBean> forumlist) {
            this.forumlist = forumlist;
        }

        public static class ForumlistBean {
            public String tid;
            public String fid;
            public String subject;
            public String author;
            public String authorid;
            public String avtUrl;
            public String dateline;
            public String lastpost;
            public String lastposter;
            public String views;
            public String replies;
            public String forumname;
            public String displayorder;
            public String typeid;
            public String digest;
            public String urls;
            public String groupon_urls;
            public String attachment;
            public String starttimefrom;
            public String expiration;
            public String attachments;
            public String activityclose;
            public String isfollow;
            public String iszan;
            public String isfavorite;



            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getAuthorid() {
                return authorid;
            }

            public void setAuthorid(String authorid) {
                this.authorid = authorid;
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

            public String getLastpost() {
                return lastpost;
            }

            public void setLastpost(String lastpost) {
                this.lastpost = lastpost;
            }

            public String getLastposter() {
                return lastposter;
            }

            public void setLastposter(String lastposter) {
                this.lastposter = lastposter;
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

            public String getForumname() {
                return forumname;
            }

            public void setForumname(String forumname) {
                this.forumname = forumname;
            }

            public String getDisplayorder() {
                return displayorder;
            }

            public void setDisplayorder(String displayorder) {
                this.displayorder = displayorder;
            }

            public String getTypeid() {
                return typeid;
            }

            public void setTypeid(String typeid) {
                this.typeid = typeid;
            }

            public String getDigest() {
                return digest;
            }

            public void setDigest(String digest) {
                this.digest = digest;
            }

            public String getUrls() {
                return urls;
            }

            public void setUrls(String urls) {
                this.urls = urls;
            }

            public String getGroupon_urls() {
                return groupon_urls;
            }

            public void setGroupon_urls(String groupon_urls) {
                this.groupon_urls = groupon_urls;
            }

            public String getAttachment() {
                return attachment;
            }

            public void setAttachment(String attachment) {
                this.attachment = attachment;
            }

            public String getStarttimefrom() {
                return starttimefrom;
            }

            public void setStarttimefrom(String starttimefrom) {
                this.starttimefrom = starttimefrom;
            }

            public String getExpiration() {
                return expiration;
            }

            public void setExpiration(String expiration) {
                this.expiration = expiration;
            }

            public String getAttachments() {
                return attachments;
            }

            public void setAttachments(String attachments) {
                this.attachments = attachments;
            }

            public String getActivityclose() {
                return activityclose;
            }

            public void setActivityclose(String activityclose) {
                this.activityclose = activityclose;
            }

            public String getIsfollow() {
                return isfollow;
            }

            public void setIsfollow(String isfollow) {
                this.isfollow = isfollow;
            }

            public String getIszan() {
                return iszan;
            }

            public void setIszan(String iszan) {
                this.iszan = iszan;
            }

            public String getIsfavorite() {
                return isfavorite;
            }

            public void setIsfavorite(String isfavorite) {
                this.isfavorite = isfavorite;
            }

            @Override
            public String toString() {
                return "ForumlistBean{" +
                        "tid='" + tid + '\'' +
                        ", fid='" + fid + '\'' +
                        ", subject='" + subject + '\'' +
                        ", author='" + author + '\'' +
                        ", authorid='" + authorid + '\'' +
                        ", avtUrl='" + avtUrl + '\'' +
                        ", dateline='" + dateline + '\'' +
                        ", lastpost='" + lastpost + '\'' +
                        ", lastposter='" + lastposter + '\'' +
                        ", views='" + views + '\'' +
                        ", replies='" + replies + '\'' +
                        ", forumname='" + forumname + '\'' +
                        ", displayorder='" + displayorder + '\'' +
                        ", typeid='" + typeid + '\'' +
                        ", digest='" + digest + '\'' +
                        ", urls='" + urls + '\'' +
                        ", groupon_urls='" + groupon_urls + '\'' +
                        ", attachment='" + attachment + '\'' +
                        ", starttimefrom='" + starttimefrom + '\'' +
                        ", expiration='" + expiration + '\'' +
                        ", attachments='" + attachments + '\'' +
                        ", activityclose='" + activityclose + '\'' +
                        ", isfollow='" + isfollow + '\'' +
                        ", iszan='" + iszan + '\'' +
                        ", isfavorite='" + isfavorite + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "forumlist=" + forumlist +
                    '}';
        }
    }
}
