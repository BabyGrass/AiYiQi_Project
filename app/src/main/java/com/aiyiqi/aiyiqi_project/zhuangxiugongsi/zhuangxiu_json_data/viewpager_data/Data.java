package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data;

/**
 * Created by Administrator on 2017/1/4.
 */

public class Data {
    public String imagesrc;

    public String imagesrc2;

    public String banner_url;

    public void setImagesrc(String imagesrc){
        this.imagesrc = imagesrc;
    }
    public String getImagesrc(){
        return this.imagesrc;
    }
    public void setImagesrc2(String imagesrc2){
        this.imagesrc2 = imagesrc2;
    }
    public String getImagesrc2(){
        return this.imagesrc2;
    }
    public void setBanner_url(String banner_url){
        this.banner_url = banner_url;
    }
    public String getBanner_url(){
        return this.banner_url;
    }

    @Override
    public String toString() {
        return "Data{" +
                "imagesrc='" + imagesrc + '\'' +
                ", imagesrc2='" + imagesrc2 + '\'' +
                ", banner_url='" + banner_url + '\'' +
                '}';
    }
}