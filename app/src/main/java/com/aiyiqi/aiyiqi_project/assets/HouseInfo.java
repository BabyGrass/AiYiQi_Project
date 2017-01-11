package com.aiyiqi.aiyiqi_project.assets;

class HouseInfo
{
    private int stage;

    private String community;

    private int layout;

    private int area;

    private int budget;

    private int style;

    public void setStage(int stage){
        this.stage = stage;
    }
    public int getStage(){
        return this.stage;
    }
    public void setCommunity(String community){
        this.community = community;
    }
    public String getCommunity(){
        return this.community;
    }
    public void setLayout(int layout){
        this.layout = layout;
    }
    public int getLayout(){
        return this.layout;
    }
    public void setArea(int area){
        this.area = area;
    }
    public int getArea(){
        return this.area;
    }
    public void setBudget(int budget){
        this.budget = budget;
    }
    public int getBudget(){
        return this.budget;
    }
    public void setStyle(int style){
        this.style = style;
    }
    public int getStyle(){
        return this.style;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "stage=" + stage +
                ", community='" + community + '\'' +
                ", layout=" + layout +
                ", area=" + area +
                ", budget=" + budget +
                ", style=" + style +
                '}';
    }
}
