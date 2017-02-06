package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class GdZb_Data {
    private GdZb_BuildingSite buildingSite;

    private GdZb_OrderHouse orderHouse;//里面存有图片上地址和名称还有户型

    private GdZb_UserDetail userDetail;

    private String imageUrl;//工地直播 图片url

    private List<GdZb_Members> members ;//参与工地直播的人员及人员工作岗位

    private List<GdZb_Progress> progress ;//工程进度 2、已完成 1、进行中 、0、未完成

    private int latestTrackProgressId;

    public GdZb_BuildingSite getBuildingSite() {
        return buildingSite;
    }

    public void setBuildingSite(GdZb_BuildingSite buildingSite) {
        this.buildingSite = buildingSite;
    }

    public GdZb_OrderHouse getOrderHouse() {
        return orderHouse;
    }

    public void setOrderHouse(GdZb_OrderHouse orderHouse) {
        this.orderHouse = orderHouse;
    }

    public GdZb_UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(GdZb_UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<GdZb_Members> getMembers() {
        return members;
    }

    public void setMembers(List<GdZb_Members> members) {
        this.members = members;
    }

    public List<GdZb_Progress> getProgress() {
        return progress;
    }

    public void setProgress(List<GdZb_Progress> progress) {
        this.progress = progress;
    }

    public int getLatestTrackProgressId() {
        return latestTrackProgressId;
    }

    public void setLatestTrackProgressId(int latestTrackProgressId) {
        this.latestTrackProgressId = latestTrackProgressId;
    }

    @Override
    public String toString() {
        return "GdZb_Data{" +
                "buildingSite=" + buildingSite +
                ", orderHouse=" + orderHouse +
                ", userDetail=" + userDetail +
                ", imageUrl='" + imageUrl + '\'' +
                ", members=" + members +
                ", progress=" + progress +
                ", latestTrackProgressId=" + latestTrackProgressId +
                '}';
    }
}
