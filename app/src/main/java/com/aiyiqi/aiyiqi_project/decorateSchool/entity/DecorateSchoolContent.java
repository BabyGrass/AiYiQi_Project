package com.aiyiqi.aiyiqi_project.decorateSchool.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */

public class DecorateSchoolContent implements Serializable {
    public Data datas;

    public class Data{
        public String totalCount;
        public String currentPage;
        public String pageSize;
        public List<Lists> lists;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public List<Lists> getLists() {
            return lists;
        }

        public void setLists(List<Lists> lists) {
            this.lists = lists;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "totalCount='" + totalCount + '\'' +
                    ", currentPage='" + currentPage + '\'' +
                    ", pageSize='" + pageSize + '\'' +
                    ", lists=" + lists +
                    '}';
        }

        public class Lists{
            public String newsId;
            public String titles;
            public String description;
            public String viewCount;
            public String replies;
            public String images;
            public String postTime;
            public String isJump;
            public String jumpUrl;

            public String getFavNums() {
                return favNums;
            }

            public void setFavNums(String favNums) {
                this.favNums = favNums;
            }

            public String favNums;
            public List<String> tags;


            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getTitles() {
                return titles;
            }

            public void setTitles(String titles) {
                this.titles = titles;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getViewCount() {
                return viewCount;
            }

            public void setViewCount(String viewCount) {
                this.viewCount = viewCount;
            }

            public String getReplies() {
                return replies;
            }

            public void setReplies(String replies) {
                this.replies = replies;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getPostTime() {
                return postTime;
            }

            public void setPostTime(String postTime) {
                this.postTime = postTime;
            }

            public String getIsJump() {
                return isJump;
            }

            public void setIsJump(String isJump) {
                this.isJump = isJump;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }

            @Override
            public String toString() {
                return "Lists{" +
                        "newsId='" + newsId + '\'' +
                        ", titles='" + titles + '\'' +
                        ", description='" + description + '\'' +
                        ", viewCount='" + viewCount + '\'' +
                        ", replies='" + replies + '\'' +
                        ", images='" + images + '\'' +
                        ", postTime='" + postTime + '\'' +
                        ", isJump='" + isJump + '\'' +
                        ", jumpUrl='" + jumpUrl + '\'' +
                        ", favNums='" + favNums + '\'' +
                        ", tags=" + tags +
                        '}';
            }
        }
    }
}
