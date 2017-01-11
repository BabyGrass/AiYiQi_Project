package com.aiyiqi.aiyiqi_project.assets;

public class Tags
{
    private String tagid;

    private String tagname;

    public void setTagid(String tagid){
        this.tagid = tagid;
    }
    public String getTagid(){
        return this.tagid;
    }
    public void setTagname(String tagname){
        this.tagname = tagname;
    }
    public String getTagname(){
        return this.tagname;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tagid='" + tagid + '\'' +
                ", tagname='" + tagname + '\'' +
                '}';
    }
}
