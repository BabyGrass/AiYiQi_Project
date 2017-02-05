package com.aiyiqi.aiyiqi_project.assets;


import java.util.List;

public class TieziZanBean {

    /**
     * data : [{"uid":"1636170","dateline":"1484138030","username":"天上神龙","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1636170&size=big"},{"uid":"1242566","dateline":"1483669586","username":"懒惰邹邹","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1242566&size=big"},{"uid":"1516666","dateline":"1483606692","username":"老房有喜","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1516666&size=big"}]
     * currentPage : 1
     * totalCount : 5
     * error : 0
     * message : 成功
     */

    private int currentPage;
    private int totalCount;
    private String error;
    private String message;
    /**
     * uid : 1636170
     * dateline : 1484138030
     * username : 天上神龙
     * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1636170&size=big
     */

    private List<DataBean> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
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

    public static class DataBean {
        private String uid;
        private String dateline;
        private String username;
        private String avtUrl;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "uid='" + uid + '\'' +
                    ", dateline='" + dateline + '\'' +
                    ", username='" + username + '\'' +
                    ", avtUrl='" + avtUrl + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TieziZanBean{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
