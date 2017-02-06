package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data;

/**
 * 工程进度
 * Created by Administrator on 2017/1/9.
 */

public class GdZb_Progress {
    private int progressId;

    private String progressName;

    private int progressStatus;

    private Long createTime;

    public void setProgressId(int progressId){
        this.progressId = progressId;
    }
    public int getProgressId(){
        return this.progressId;
    }
    public void setProgressName(String progressName){
        this.progressName = progressName;
    }
    public String getProgressName(){
        return this.progressName;
    }
    public void setProgressStatus(int progressStatus){
        this.progressStatus = progressStatus;
    }
    public int getProgressStatus(){
        return this.progressStatus;
    }
    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }
    public Long getCreateTime(){
        return this.createTime;
    }

    @Override
    public String toString() {
        return "GdZb_Progress{" +
                "progressId=" + progressId +
                ", progressName='" + progressName + '\'' +
                ", progressStatus=" + progressStatus +
                ", createTime=" + createTime +
                '}';
    }
}
