package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class Root {

        public int error;

        public String message;

        public List<Data> data ;

        public void setError(int error){
            this.error = error;
        }
        public int getError(){
            return this.error;
        }
        public void setMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return this.message;
        }
        public void setData(List<Data> data){
            this.data = data;
        }
        public List<Data> getData(){
            return this.data;
        }

    @Override
    public String toString() {
        return "Root{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
