package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data;

/**
 * Created by Administrator on 2017/1/9.
 */

public class GdZb_UserDetail {
    private Long userId;

    private String realName;

    private Long gender;

    private Long emailVerified;

    private Long provinceId;

    private Long cityId;

    private Long districtId;

    private Long userPoint;

    private Long userLevel;

    private Long hasOrder;

    private Long updateTime;

    private Long userPointIncrement;

    private Long userPointDate;

    private String mobile;

    private String mobileLocation;

    private Long userType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Long getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Long emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Long userPoint) {
        this.userPoint = userPoint;
    }

    public Long getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Long userLevel) {
        this.userLevel = userLevel;
    }

    public Long getHasOrder() {
        return hasOrder;
    }

    public void setHasOrder(Long hasOrder) {
        this.hasOrder = hasOrder;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUserPointIncrement() {
        return userPointIncrement;
    }

    public void setUserPointIncrement(Long userPointIncrement) {
        this.userPointIncrement = userPointIncrement;
    }

    public Long getUserPointDate() {
        return userPointDate;
    }

    public void setUserPointDate(Long userPointDate) {
        this.userPointDate = userPointDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileLocation() {
        return mobileLocation;
    }

    public void setMobileLocation(String mobileLocation) {
        this.mobileLocation = mobileLocation;
    }

    @Override
    public String toString() {
        return "GdZb_UserDetail{" +
                "userId=" + userId +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                ", emailVerified=" + emailVerified +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", districtId=" + districtId +
                ", userPoint=" + userPoint +
                ", userLevel=" + userLevel +
                ", hasOrder=" + hasOrder +
                ", updateTime=" + updateTime +
                ", userPointIncrement=" + userPointIncrement +
                ", userPointDate=" + userPointDate +
                ", mobile='" + mobile + '\'' +
                ", mobileLocation='" + mobileLocation + '\'' +
                ", userType=" + userType +
                '}';
    }
}
