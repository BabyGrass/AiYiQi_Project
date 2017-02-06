package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */

public class GdZb_ZxJdRoot {

    private GdZb_ZxJdBaseOutput baseOutput;

    private List<GdZb_ZxJdData> data ;

    private GdZb_ZxJdPageInfo pageInfo;

    public void setBaseOutput(GdZb_ZxJdBaseOutput baseOutput){
        this.baseOutput = baseOutput;
    }
    public GdZb_ZxJdBaseOutput getBaseOutput(){
        return this.baseOutput;
    }
    public void setData(List<GdZb_ZxJdData> data){
        this.data = data;
    }
    public List<GdZb_ZxJdData> getData(){
        return this.data;
    }
    public void setPageInfo(GdZb_ZxJdPageInfo pageInfo){
        this.pageInfo = pageInfo;
    }
    public GdZb_ZxJdPageInfo getPageInfo(){
        return this.pageInfo;
    }

    @Override
    public String toString() {
        return "GdZb_ZxJdRoot{" +
                "baseOutput=" + baseOutput +
                ", data=" + data +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
