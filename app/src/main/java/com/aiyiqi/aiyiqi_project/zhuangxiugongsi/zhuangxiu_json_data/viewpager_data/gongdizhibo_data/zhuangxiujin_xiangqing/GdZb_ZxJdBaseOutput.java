package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing;

/**
 * Created by Administrator on 2017/1/10.
 */

public class GdZb_ZxJdBaseOutput {
    private int code;

    private String message;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
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
        return "GdZb_ZxJdBaseOutput{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
