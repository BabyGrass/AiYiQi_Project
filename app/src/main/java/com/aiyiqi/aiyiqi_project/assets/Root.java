package com.aiyiqi.aiyiqi_project.assets;

public class Root
{
    private Data data;

    private String error;

    private String message;

    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
    public void setError(String error){
        this.error = error;
    }
    public String getError(){
        return this.error;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }

    @Override
    public String toString() {
        return "Root{" +
                "data=" + data +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
