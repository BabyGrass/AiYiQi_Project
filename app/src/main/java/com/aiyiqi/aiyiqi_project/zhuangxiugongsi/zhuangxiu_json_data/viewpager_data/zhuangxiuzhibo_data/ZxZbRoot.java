package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data;

import java.util.List;

/**
 * 装修直播data最外层类
 * Created by Administrator on 2017/1/5.
 */

public class ZxZbRoot {
    private ZxZbBaseOutput baseOutput;

    private List<ZxZbData> data ;

    public void setBaseOutput(ZxZbBaseOutput baseOutput){
        this.baseOutput = baseOutput;
    }
    public ZxZbBaseOutput getBaseOutput(){
        return this.baseOutput;
    }
    public void setData(List<ZxZbData> data){
        this.data = data;
    }
    public List<ZxZbData> getData(){
        return this.data;
    }

    @Override
    public String toString() {
        return "ZxZbRoot{" +
                "baseOutput=" + baseOutput +
                ", data=" + data +
                '}';
    }
}
