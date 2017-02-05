package com.aiyiqi.aiyiqi_project.assets;


import java.util.List;
public class Message
{
    private int msgType;

    private String msg;

    private int imgType;

    private List<String> layout;

    private int width;

    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMsgType(int msgType){
        this.msgType = msgType;
    }
    public int getMsgType(){
        return this.msgType;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setImgType(int imgType){
        this.imgType = imgType;
    }
    public int getImgType(){
        return this.imgType;
    }
    public void setLayout(List<String> layout){
        this.layout = layout;
    }
    public List<String> getLayout(){
        return this.layout;
    }

    @Override
    public String toString() {
        return "Messa{" +
                "msgType=" + msgType +
                ", msg='" + msg + '\'' +
                ", imgType=" + imgType +
                ", layout=" + layout +
                '}';
    }
}

