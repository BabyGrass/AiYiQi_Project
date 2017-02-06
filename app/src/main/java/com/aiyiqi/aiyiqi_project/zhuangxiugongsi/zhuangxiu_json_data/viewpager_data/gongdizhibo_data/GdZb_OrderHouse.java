package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data;

/**
 * 房源信息
 * Created by Administrator on 2017/1/9.
 */

public class GdZb_OrderHouse {

    private Long orderId;

    private String layout;//户型

    private String area;

    private String doorplate;

    private String community;//房源名称信息

    private String address;//地址

    private Long newHouse;

    private Long deliveryHouse;

    private double lng;

    private double lat;

    public void setOrderId(Long orderId){
        this.orderId = orderId;
    }
    public Long getOrderId(){
        return this.orderId;
    }
    public void setLayout(String layout){
        this.layout = layout;
    }
    public String getLayout(){
        return this.layout;
    }
    public void setArea(String area){
        this.area = area;
    }
    public String getArea(){
        return this.area;
    }
    public void setDoorplate(String doorplate){
        this.doorplate = doorplate;
    }
    public String getDoorplate(){
        return this.doorplate;
    }
    public void setCommunity(String community){
        this.community = community;
    }
    public String getCommunity(){
        return this.community;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setNewHouse(Long newHouse){
        this.newHouse = newHouse;
    }
    public Long getNewHouse(){
        return this.newHouse;
    }
    public void setDeliveryHouse(Long deliveryHouse){
        this.deliveryHouse = deliveryHouse;
    }
    public Long getDeliveryHouse(){
        return this.deliveryHouse;
    }
    public void setLng(double lng){
        this.lng = lng;
    }
    public double getLng(){
        return this.lng;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public double getLat(){
        return this.lat;
    }

    @Override
    public String toString() {
        return "GdZb_OrderHouse{" +
                "orderId=" + orderId +
                ", layout='" + layout + '\'' +
                ", area='" + area + '\'' +
                ", doorplate='" + doorplate + '\'' +
                ", community='" + community + '\'' +
                ", address='" + address + '\'' +
                ", newHouse=" + newHouse +
                ", deliveryHouse=" + deliveryHouse +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
