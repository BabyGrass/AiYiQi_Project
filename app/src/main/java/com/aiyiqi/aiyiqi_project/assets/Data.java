package com.aiyiqi.aiyiqi_project.assets;

import java.util.List;

public class Data
{
   private String tid;

   private String pid;

   private String author;

   private String authorid;

   private String avtUrl;

   private String userSpaceUrl;

   private String dateline;

   private String replyUrl;

   private String nofollowUrl;

   private String block;

   private List<Message> message;

   private String floor;

   private String title;

   private String urls;

   private int locationFloor;

   private List<String> atlist;

   private String address;

   private String fid;

   private String fname;

   private String fstatus;

   private List<String> attachments;

   private HouseInfo houseInfo;

   private List<Tags> tags;

   private String h5Url;

   private List<String> activitydata;

   private int isfollow;

   public void setTid(String tid){
       this.tid = tid;
   }
   public String getTid(){
       return this.tid;
   }
   public void setPid(String pid){
       this.pid = pid;
   }
   public String getPid(){
       return this.pid;
   }
   public void setAuthor(String author){
       this.author = author;
   }
   public String getAuthor(){
       return this.author;
   }
   public void setAuthorid(String authorid){
       this.authorid = authorid;
   }
   public String getAuthorid(){
       return this.authorid;
   }
   public void setAvtUrl(String avtUrl){
       this.avtUrl = avtUrl;
   }
   public String getAvtUrl(){
       return this.avtUrl;
   }
   public void setUserSpaceUrl(String userSpaceUrl){
       this.userSpaceUrl = userSpaceUrl;
   }
   public String getUserSpaceUrl(){
       return this.userSpaceUrl;
   }
   public void setDateline(String dateline){
       this.dateline = dateline;
   }
   public String getDateline(){
       return this.dateline;
   }
   public void setReplyUrl(String replyUrl){
       this.replyUrl = replyUrl;
   }
   public String getReplyUrl(){
       return this.replyUrl;
   }
   public void setNofollowUrl(String nofollowUrl){
       this.nofollowUrl = nofollowUrl;
   }
   public String getNofollowUrl(){
       return this.nofollowUrl;
   }
   public void setBlock(String block){
       this.block = block;
   }
   public String getBlock(){
       return this.block;
   }
   public void setMessage(List<Message> message){
       this.message = message;
   }
   public List<Message> getMessage(){
       return this.message;
   }
   public void setFloor(String floor){
       this.floor = floor;
   }
   public String getFloor(){
       return this.floor;
   }
   public void setTitle(String title){
       this.title = title;
   }
   public String getTitle(){
       return this.title;
   }
   public void setUrls(String urls){
       this.urls = urls;
   }
   public String getUrls(){
       return this.urls;
   }
   public void setLocationFloor(int locationFloor){
       this.locationFloor = locationFloor;
   }
   public int getLocationFloor(){
       return this.locationFloor;
   }
   public void setAtlist(List<String> atlist){
       this.atlist = atlist;
   }
   public List<String> getAtlist(){
       return this.atlist;
   }
   public void setAddress(String address){
       this.address = address;
   }
   public String getAddress(){
       return this.address;
   }
   public void setFid(String fid){
       this.fid = fid;
   }
   public String getFid(){
       return this.fid;
   }
   public void setFname(String fname){
       this.fname = fname;
   }
   public String getFname(){
       return this.fname;
   }
   public void setFstatus(String fstatus){
       this.fstatus = fstatus;
   }
   public String getFstatus(){
       return this.fstatus;
   }
   public void setAttachments(List<String> attachments){
       this.attachments = attachments;
   }
   public List<String> getAttachments(){
       return this.attachments;
   }
   public void setHouseInfo(HouseInfo houseInfo){
       this.houseInfo = houseInfo;
   }
   public HouseInfo getHouseInfo(){
       return this.houseInfo;
   }
   public void setTags(List<Tags> tags){
       this.tags = tags;
   }
   public List<Tags> getTags(){
       return this.tags;
   }
   public void setH5Url(String h5Url){
       this.h5Url = h5Url;
   }
   public String getH5Url(){
       return this.h5Url;
   }
   public void setActivitydata(List<String> activitydata){
       this.activitydata = activitydata;
   }
   public List<String> getActivitydata(){
       return this.activitydata;
   }
   public void setIsfollow(int isfollow){
       this.isfollow = isfollow;
   }
   public int getIsfollow(){
       return this.isfollow;
   }

    @Override
    public String toString() {
        return "Data{" +
                "tid='" + tid + '\'' +
                ", pid='" + pid + '\'' +
                ", author='" + author + '\'' +
                ", authorid='" + authorid + '\'' +
                ", avtUrl='" + avtUrl + '\'' +
                ", userSpaceUrl='" + userSpaceUrl + '\'' +
                ", dateline='" + dateline + '\'' +
                ", replyUrl='" + replyUrl + '\'' +
                ", nofollowUrl='" + nofollowUrl + '\'' +
                ", block='" + block + '\'' +
                ", message=" + message +
                ", floor='" + floor + '\'' +
                ", title='" + title + '\'' +
                ", urls='" + urls + '\'' +
                ", locationFloor=" + locationFloor +
                ", atlist=" + atlist +
                ", address='" + address + '\'' +
                ", fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", fstatus='" + fstatus + '\'' +
                ", attachments=" + attachments +
                ", houseInfo=" + houseInfo +
                ", tags=" + tags +
                ", h5Url='" + h5Url + '\'' +
                ", activitydata=" + activitydata +
                ", isfollow=" + isfollow +
                '}';
    }
}
