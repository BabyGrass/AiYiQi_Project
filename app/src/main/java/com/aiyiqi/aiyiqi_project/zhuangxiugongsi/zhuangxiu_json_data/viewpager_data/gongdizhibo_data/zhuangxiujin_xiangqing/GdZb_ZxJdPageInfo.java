package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing;

/**
 * Created by Administrator on 2017/1/10.
 */

public class GdZb_ZxJdPageInfo {
    private int pageNo;

    private int pageSize;

    private int pageTotalNum;

    public void setPageNo(int pageNo){
        this.pageNo = pageNo;
    }
    public int getPageNo(){
        return this.pageNo;
    }
    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }
    public int getPageSize(){
        return this.pageSize;
    }
    public void setPageTotalNum(int pageTotalNum){
        this.pageTotalNum = pageTotalNum;
    }
    public int getPageTotalNum(){
        return this.pageTotalNum;
    }

    @Override
    public String toString() {
        return "GdZb_ZxJdPageInfo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotalNum=" + pageTotalNum +
                '}';
    }
}
