package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data;

/**
 * Created by Administrator on 2017/1/5.
 */

public class ZxZbUserDetail {
    private String userId;

    private String realName;

    private String gender;

    private String emailVerified;

    private String provinceId;

    private String cityId;

    private String districtId;

    private String userPoint;

    private String userLevel;

    private String hasOrder;

    private String updateTime;

    private String userPointIncrement;

    private String userPointDate;

    private String mobile;

    private String userType;

    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return this.realName;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setEmailVerified(String emailVerified){
        this.emailVerified = emailVerified;
    }
    public String getEmailVerified(){
        return this.emailVerified;
    }
    public void setProvinceId(String provinceId){
        this.provinceId = provinceId;
    }
    public String getProvinceId(){
        return this.provinceId;
    }
    public void setCityId(String cityId){
        this.cityId = cityId;
    }
    public String getCityId(){
        return this.cityId;
    }
    public void setDistrictId(String districtId){
        this.districtId = districtId;
    }
    public String getDistrictId(){
        return this.districtId;
    }
    public void setUserPoint(String userPoint){
        this.userPoint = userPoint;
    }
    public String getUserPoint(){
        return this.userPoint;
    }
    public void setUserLevel(String userLevel){
        this.userLevel = userLevel;
    }
    public String getUserLevel(){
        return this.userLevel;
    }
    public void setHasOrder(String hasOrder){
        this.hasOrder = hasOrder;
    }
    public String getHasOrder(){
        return this.hasOrder;
    }
    public void setUpdateTime(String updateTime){
        this.updateTime = updateTime;
    }
    public String getUpdateTime(){
        return this.updateTime;
    }
    public void setUserPointIncrement(String userPointIncrement){
        this.userPointIncrement = userPointIncrement;
    }
    public String getUserPointIncrement(){
        return this.userPointIncrement;
    }
    public void setUserPointDate(String userPointDate){
        this.userPointDate = userPointDate;
    }
    public String getUserPointDate(){
        return this.userPointDate;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return this.mobile;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }
    public String getUserType(){
        return this.userType;
    }

    @Override
    public String toString() {
        return "ZxZbUserDetail{" +
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
                ", userType=" + userType +
                '}';
    }
}
