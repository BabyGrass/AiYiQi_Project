package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing;

/**
 * Created by Administrator on 2017/1/10.
 */

public class GdZb_ZxJdWeiXinShare {
    private String title;

    private String content;

    private String news;

    private String imageUrl;

    private String linkUrl;

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setNews(String news){
        this.news = news;
    }
    public String getNews(){
        return this.news;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setLinkUrl(String linkUrl){
        this.linkUrl = linkUrl;
    }
    public String getLinkUrl(){
        return this.linkUrl;
    }

    @Override
    public String toString() {
        return "GdZb_ZxJdWeiXinShare{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", news='" + news + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                '}';
    }
}
