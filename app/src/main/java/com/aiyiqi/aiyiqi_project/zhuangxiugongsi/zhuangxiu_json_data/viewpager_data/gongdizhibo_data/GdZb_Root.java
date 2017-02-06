package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data;



/**
 * 工地直播Json数据 最外层
 * Created by Administrator on 2017/1/9.
 */

public class GdZb_Root {
    public GdZb_BaseOutput baseOutput;

    public GdZb_Data data;

    public void setBaseOutput(GdZb_BaseOutput baseOutput){
        this.baseOutput = baseOutput;
    }
    public GdZb_BaseOutput getBaseOutput(){
        return this.baseOutput;
    }
    public void setData(GdZb_Data data){
        this.data = data;
    }
    public GdZb_Data getData(){
        return this.data;
    }

    @Override
    public String toString() {
        return "GdZb_Root{" +
                "baseOutput=" + baseOutput +
                ", data=" + data +
                '}';
    }
}
