package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing;


import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */

public class GdZb_ZxJdData {
    private String avatar;

    private Long trackId;

    private String message;

    private Long buildingId;

    private Long progressId;

    private Long acceptancePassed;

    private Long acceptanceId;

    private Long createTime;

    private Long dateInterval;

    private Long vendorId;

    private String atList;

    private Long userId;

    private String imgSrc;

    private int sponsorType;

    private String address;

    private String creatorName;

    private String creatorRole;

    private List replyList ;

    private GdZb_ZxJdWeiXinShare weiXinShare;


    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public Long getAcceptancePassed() {
        return acceptancePassed;
    }

    public void setAcceptancePassed(Long acceptancePassed) {
        this.acceptancePassed = acceptancePassed;
    }

    public Long getAcceptanceId() {
        return acceptanceId;
    }

    public void setAcceptanceId(Long acceptanceId) {
        this.acceptanceId = acceptanceId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getDateInterval() {
        return dateInterval;
    }

    public void setDateInterval(Long dateInterval) {
        this.dateInterval = dateInterval;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getAtList() {
        return atList;
    }

    public void setAtList(String atList) {
        this.atList = atList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(int sponsorType) {
        this.sponsorType = sponsorType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorRole() {
        return creatorRole;
    }

    public void setCreatorRole(String creatorRole) {
        this.creatorRole = creatorRole;
    }

    public List getReplyList() {
        return replyList;
    }

    public void setReplyList(List replyList) {
        this.replyList = replyList;
    }

    public GdZb_ZxJdWeiXinShare getWeiXinShare() {
        return weiXinShare;
    }

    public void setWeiXinShare(GdZb_ZxJdWeiXinShare weiXinShare) {
        this.weiXinShare = weiXinShare;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "GdZb_ZxJdData{" +
                "trackId=" + trackId +
                ", message='" + message + '\'' +
                ", buildingId=" + buildingId +
                ", progressId=" + progressId +
                ", acceptancePassed=" + acceptancePassed +
                ", acceptanceId=" + acceptanceId +
                ", createTime=" + createTime +
                ", dateInterval=" + dateInterval +
                ", vendorId=" + vendorId +
                ", atList='" + atList + '\'' +
                ", userId=" + userId +
                ", imgSrc='" + imgSrc + '\'' +
                ", sponsorType=" + sponsorType +
                ", address='" + address + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", creatorRole='" + creatorRole + '\'' +
                ", replyList=" + replyList +
                ", weiXinShare=" + weiXinShare +
                '}';
    }
}



