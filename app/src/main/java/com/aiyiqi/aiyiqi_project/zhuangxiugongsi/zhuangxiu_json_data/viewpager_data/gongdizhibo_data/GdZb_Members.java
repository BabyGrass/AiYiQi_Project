package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data;

/**
 * 参与施工的人员信息
 * Created by Administrator on 2017/1/9.
 */

public class GdZb_Members {
    private Long vendorId;

    private String vendorName;

    private String realName;//真实姓名

    private String nickName;

    private String avatar;

    private String lifePhoto;

    private String signature;

    private Long provinceId;

    private Long workYear;

    private Long updateTime;

    private Long bossId;// 1701 设计师 1702 监理 1703 工长 1705 材料顾问 1707 无

    public void setVendorId(Long vendorId){
        this.vendorId = vendorId;
    }
    public Long getVendorId(){
        return this.vendorId;
    }
    public void setVendorName(String vendorName){
        this.vendorName = vendorName;
    }
    public String getVendorName(){
        return this.vendorName;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public String getRealName(){
        return this.realName;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public String getNickName(){
        return this.nickName;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatar(){
        return this.avatar;
    }
    public void setLifePhoto(String lifePhoto){
        this.lifePhoto = lifePhoto;
    }
    public String getLifePhoto(){
        return this.lifePhoto;
    }
    public void setSignature(String signature){
        this.signature = signature;
    }
    public String getSignature(){
        return this.signature;
    }
    public void setProvinceId(Long provinceId){
        this.provinceId = provinceId;
    }
    public Long getProvinceId(){
        return this.provinceId;
    }
    public void setWorkYear(Long workYear){
        this.workYear = workYear;
    }
    public Long getWorkYear(){
        return this.workYear;
    }
    public void setUpdateTime(Long updateTime){
        this.updateTime = updateTime;
    }
    public Long getUpdateTime(){
        return this.updateTime;
    }
    public void setBossId(Long bossId){
        this.bossId = bossId;
    }
    public Long getBossId(){
        return this.bossId;
    }

    @Override
    public String toString() {
        return "GdZb_Members{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", lifePhoto='" + lifePhoto + '\'' +
                ", signature='" + signature + '\'' +
                ", provinceId=" + provinceId +
                ", workYear=" + workYear +
                ", updateTime=" + updateTime +
                ", bossId=" + bossId +
                '}';
    }
}
