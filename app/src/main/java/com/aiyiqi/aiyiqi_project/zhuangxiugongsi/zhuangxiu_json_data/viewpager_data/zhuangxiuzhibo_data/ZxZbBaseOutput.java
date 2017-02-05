package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data;

/**
 * 装修直播第二层
 * Created by Administrator on 2017/1/5.
 */

public class ZxZbBaseOutput {
    private String code;

    private String message;

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }


    @Override
    public String toString() {
        return "ZxZbBaseOutput{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
