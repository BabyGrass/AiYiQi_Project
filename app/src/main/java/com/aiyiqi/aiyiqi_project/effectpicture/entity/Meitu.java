package com.aiyiqi.aiyiqi_project.effectpicture.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */

public class Meitu implements Serializable{

    /**
     * error : 0
     * message : ok
     * data : {"totalCount":"800","list":[{"id":"3717117","title":"北欧风格客厅工作区装修","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031011136443.jpg","like_num":"0","tag":[{"id":"1","name":"客厅"},{"id":"30","name":"北欧"},{"id":"57","name":"工作区"}],"collected":"1","iscollect":0},{"id":"3717118","title":"北欧风格一居卧室装修设计","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031012267407.jpg","like_num":"0","tag":[{"id":"4","name":"卧室"},{"id":"30","name":"北欧"},{"id":"34","name":"一居"}],"collected":"1","iscollect":0},{"id":"3717119","title":"北欧风格白色厨房装修","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031013237900.jpg","like_num":"0","tag":[{"id":"3","name":"厨房"},{"id":"30","name":"北欧"},{"id":"66","name":"白色"}],"collected":"1","iscollect":0},{"id":"3717120","title":"北欧风一居室卫生间设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031015121899.jpg","like_num":"0","tag":[{"id":"7","name":"卫生间"},{"id":"30","name":"北欧"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717121","title":"现代一居室餐厅装修设计","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050923374033.jpg","like_num":"0","tag":[{"id":"2","name":"餐厅"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717122","title":"现代一居室客厅设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050933053046.jpg","like_num":"0","tag":[{"id":"1","name":"客厅"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717123","title":"现代风一居室厨房设计大全","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050933542985.jpg","like_num":"0","tag":[{"id":"3","name":"厨房"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717124","title":"现代一居室书房装修设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050934353777.jpg","like_num":"0","tag":[{"id":"6","name":"书房"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717125","title":"现代风二居室卫生间设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050935191216.jpg","like_num":"0","tag":[{"id":"7","name":"卫生间"},{"id":"16","name":"现代"},{"id":"84","name":"二居"}],"collected":0,"iscollect":0},{"id":"3717126","title":"现代风格厨房墙面装修图片","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050936007914.jpg","like_num":"0","tag":[{"id":"3","name":"厨房"},{"id":"16","name":"现代"},{"id":"51","name":"墙面"}],"collected":0,"iscollect":0}]}
     */

    private int error;
    private String message;
    /**
     * totalCount : 800
     * list : [{"id":"3717117","title":"北欧风格客厅工作区装修","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031011136443.jpg","like_num":"0","tag":[{"id":"1","name":"客厅"},{"id":"30","name":"北欧"},{"id":"57","name":"工作区"}],"collected":"1","iscollect":0},{"id":"3717118","title":"北欧风格一居卧室装修设计","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031012267407.jpg","like_num":"0","tag":[{"id":"4","name":"卧室"},{"id":"30","name":"北欧"},{"id":"34","name":"一居"}],"collected":"1","iscollect":0},{"id":"3717119","title":"北欧风格白色厨房装修","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031013237900.jpg","like_num":"0","tag":[{"id":"3","name":"厨房"},{"id":"30","name":"北欧"},{"id":"66","name":"白色"}],"collected":"1","iscollect":0},{"id":"3717120","title":"北欧风一居室卫生间设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031015121899.jpg","like_num":"0","tag":[{"id":"7","name":"卫生间"},{"id":"30","name":"北欧"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717121","title":"现代一居室餐厅装修设计","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050923374033.jpg","like_num":"0","tag":[{"id":"2","name":"餐厅"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717122","title":"现代一居室客厅设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050933053046.jpg","like_num":"0","tag":[{"id":"1","name":"客厅"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717123","title":"现代风一居室厨房设计大全","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050933542985.jpg","like_num":"0","tag":[{"id":"3","name":"厨房"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717124","title":"现代一居室书房装修设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050934353777.jpg","like_num":"0","tag":[{"id":"6","name":"书房"},{"id":"16","name":"现代"},{"id":"34","name":"一居"}],"collected":0,"iscollect":0},{"id":"3717125","title":"现代风二居室卫生间设计图","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050935191216.jpg","like_num":"0","tag":[{"id":"7","name":"卫生间"},{"id":"16","name":"现代"},{"id":"84","name":"二居"}],"collected":0,"iscollect":0},{"id":"3717126","title":"现代风格厨房墙面装修图片","url":"http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/05/201701050936007914.jpg","like_num":"0","tag":[{"id":"3","name":"厨房"},{"id":"16","name":"现代"},{"id":"51","name":"墙面"}],"collected":0,"iscollect":0}]
     */

    private DataBean data;

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
        public String totalCount;
        /**
         * id : 3717117
         * title : 北欧风格客厅工作区装修
         * url : http://static-xiaoguotu.17house.com/web/xiaoguotu/201701/03/201701031011136443.jpg
         * like_num : 0
         * tag : [{"id":"1","name":"客厅"},{"id":"30","name":"北欧"},{"id":"57","name":"工作区"}]
         * collected : 1
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
            public String url;
            public String like_num;
            public String collected;
            public String iscollect;
            /**
             * id : 1
             * name : 客厅
             */

            private List<TagBean> tag;

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getLike_num() {
                return like_num;
            }

            public void setLike_num(String like_num) {
                this.like_num = like_num;
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

            public List<TagBean> getTag() {
                return tag;
            }

            public void setTag(List<TagBean> tag) {
                this.tag = tag;
            }

            public static class TagBean {
                public String id;
                public String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                @Override
                public String toString() {
                    return "TagBean{" +
                            "id='" + id + '\'' +
                            ", name='" + name + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", like_num='" + like_num + '\'' +
                        ", collected='" + collected + '\'' +
                        ", iscollect='" + iscollect + '\'' +
                        ", tag=" + tag +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "totalCount='" + totalCount + '\'' +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Meitu{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
