package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data;

/**
 *  装修直播数据第二层
 *  Created by Administrator on 2017/1/5.
 */

public class ZxZbData {
        private ZxZbBuildingSite buildingSite;

        private ZxZbOrderHouse orderHouse;

        private ZxZbUserDetail userDetail;

        private String imageUrl;

        private String latestTrackProgressId;

        public void setBuildingSite(ZxZbBuildingSite buildingSite){
            this.buildingSite = buildingSite;
        }
        public ZxZbBuildingSite getBuildingSite(){
            return this.buildingSite;
        }
        public void setOrderHouse(ZxZbOrderHouse orderHouse){
            this.orderHouse = orderHouse;
        }
        public ZxZbOrderHouse getOrderHouse(){
            return this.orderHouse;
        }
        public void setUserDetail(ZxZbUserDetail userDetail){
            this.userDetail = userDetail;
        }
        public ZxZbUserDetail getUserDetail(){
            return this.userDetail;
        }
        public void setImageUrl(String imageUrl){
            this.imageUrl = imageUrl;
        }
        public String getImageUrl(){
            return this.imageUrl;
        }
        public void setLatestTrackProgressId(String latestTrackProgressId){
            this.latestTrackProgressId = latestTrackProgressId;
        }
        public String getLatestTrackProgressId(){
            return this.latestTrackProgressId;
        }

    @Override
    public String toString() {
        return "ZxZbData{" +
                "buildingSite=" + buildingSite +
                ", orderHouse=" + orderHouse +
                ", userDetail=" + userDetail +
                ", imageUrl='" + imageUrl + '\'' +
                ", latestTrackProgressId=" + latestTrackProgressId +
                '}';
    }
}
