package com.aiyiqi.aiyiqi_project.decorateSchool.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */

public class DecorateSchoolTag implements Serializable {

    /**
     * error : 0
     * message : ok
     * data : {"61":"门窗","305":"暖气","517":"验房","899":"收房","8039":"交房","8153":"验房工具","8154":"墙顶验收","8159":"地面验收","8161":"上水","8163":"下水","8164":"强电","8165":"弱电","8166":"燃气","8667":"防水"}
     */

    private int error;
    private String message;
    public List<String> tags;
    /**
     * 61 : 门窗
     * 305 : 暖气
     * 517 : 验房
     * 899 : 收房
     * 8039 : 交房
     * 8153 : 验房工具
     * 8154 : 墙顶验收
     * 8159 : 地面验收
     * 8161 : 上水
     * 8163 : 下水
     * 8164 : 强电
     * 8165 : 弱电
     * 8166 : 燃气
     * 8667 : 防水
     */


    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
