package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data;

/**
 * Created by Administrator on 2017/1/5.
 */

public class ZxZbOrderHouse {

    private String orderId;

    private String layout;

    private String area;

    private String doorplate;

    private String community;

    private String address;

    private String newHouse;

    private String deliveryHouse;

    private String lng;

    private String lat;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDoorplate() {
        return doorplate;
    }

    public void setDoorplate(String doorplate) {
        this.doorplate = doorplate;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryHouse() {
        return deliveryHouse;
    }

    public void setDeliveryHouse(String deliveryHouse) {
        this.deliveryHouse = deliveryHouse;
    }

    public String getNewHouse() {
        return newHouse;
    }

    public void setNewHouse(String newHouse) {
        this.newHouse = newHouse;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "ZxZbOrderHouse{" +
                "orderId='" + orderId + '\'' +
                ", layout='" + layout + '\'' +
                ", area='" + area + '\'' +
                ", doorplate='" + doorplate + '\'' +
                ", community='" + community + '\'' +
                ", address='" + address + '\'' +
                ", newHouse='" + newHouse + '\'' +
                ", deliveryHouse='" + deliveryHouse + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
