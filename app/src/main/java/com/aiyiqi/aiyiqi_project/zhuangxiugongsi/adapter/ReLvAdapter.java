package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.Data;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data.ZxZbData;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;
import com.finesdk.util.ConvenientBannerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/1/4.
 */

public class ReLvAdapter extends BaseAdapter implements View.OnClickListener{
    private Context mcontext ;
    private List<ZxZbData> list;//装修直播的数据集合
    private List<String> list1;//convenientBanner的Url数据集合
    private ConvenientBannerUtil convenientBannerUtil;
    private int[] selects;//接收Acivity传过来显示在convenientBanner上的数据点数组

//    private List<>
    public ReLvAdapter(Context context) {
        this.mcontext= context;
        list = new ArrayList<>();
    }

    /**
     *第一个Item的数据  convenientBanner
     */
    public void  setFirstItemData(Context context,List<String> list2,int[] selects){
          this.mcontext = context;
         this.list1 = list2;
        this.selects = selects;
    }


    /**
     * 刷新一次数据
     * @param list
     */
    public void settList(List<ZxZbData> list) {
        this.list = list;
        Log.i("mssssssssssssssssssss","-------------"+this.list.size());
    }

    //添加数据
    public void addTotalList(List<ZxZbData> list) {
        this.list.addAll(list);
    }

    @Override
    public int getCount() {
        return list == null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null?null:list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 0;
        }else if(position == 1){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder = null;//装修直播
        MyViewHolder1 myViewHolder1 = null;//轮播
        MyViewHolder2 myViewHolder2 = null;//新房，旧房
        if(convertView == null){
            if(getItemViewType(position) == 0){//轮播广告
                myViewHolder1 = new MyViewHolder1();
                convertView = View.inflate(mcontext,R.layout.layout_zhuangxiugongsi_01item,null);
                myViewHolder1.convenientBanner = (ConvenientBanner)convertView .findViewById(R.id.convenientBanner);
                convenientBannerUtil  = new ConvenientBannerUtil(mcontext,myViewHolder1.convenientBanner,list1,selects);
                convertView.setTag(myViewHolder1);
            }else if(getItemViewType(position) == 1){//新房，旧房
                myViewHolder2 = new MyViewHolder2();
                convertView = View.inflate(mcontext,R.layout.layout_zhuangxiugongsi_02item,null);
                myViewHolder2.zx_ll_xinfangzx = (LinearLayout) convertView.findViewById(R.id.zx_ll_xinfangzx);
                myViewHolder2.zx_ll2_laofangzx = (LinearLayout) convertView.findViewById(R.id.zx_ll2_laofangzx);
                myViewHolder2.zx_rl2_kanxianchang = (RelativeLayout) convertView.findViewById(R.id.zx_rl2_kanxianchang);
                myViewHolder2.zx_rl2_gongdizhibo = (RelativeLayout) convertView.findViewById(R.id.zx_rl2_gongdizhibo);
                myViewHolder2.zx_rl2_yiqituandui = (RelativeLayout) convertView.findViewById(R.id.zx_rl2_yiqituandui);
                //给他们设置监听
                myViewHolder2.zx_ll_xinfangzx.setOnClickListener(this);
                myViewHolder2.zx_ll2_laofangzx.setOnClickListener(this);
                myViewHolder2.zx_rl2_kanxianchang.setOnClickListener(this);
                myViewHolder2.zx_rl2_gongdizhibo.setOnClickListener(this);
                myViewHolder2.zx_rl2_yiqituandui.setOnClickListener(this);
                convertView.setTag(myViewHolder2);
            }
        else if(getItemViewType(position) == 2){//装修直播
            myViewHolder = new MyViewHolder();
            convertView = View.inflate(mcontext,R.layout.layout_zhuangxiugongsi_item,null);
            myViewHolder.zx_listview_sdv = (SimpleDraweeView) convertView.findViewById(R.id.zx_listview_sdv);
            myViewHolder.zx_listview_tv1 = (TextView) convertView.findViewById(R.id.zx_listview_tv1);
            myViewHolder.zx_listview_tv2 = (TextView) convertView.findViewById(R.id.zx_listview_tv2);
            convertView.setTag(myViewHolder);
        }
        }else{
            if(getItemViewType(position) == 0){
                myViewHolder1 = (MyViewHolder1) convertView.getTag();
            }else if(getItemViewType(position) == 1){
                myViewHolder2 = (MyViewHolder2) convertView.getTag();
            }else{
                myViewHolder = (MyViewHolder) convertView.getTag();
            }
        }


        //设置数据
        if(getItemViewType(position) == 2){
            ZxZbData zxZbOrderHouse = list.get(position);
            ImageLoader.getInstance().disPlayImage(myViewHolder.zx_listview_sdv,zxZbOrderHouse.getImageUrl());
            myViewHolder.zx_listview_tv1.setText(zxZbOrderHouse.getOrderHouse().getCommunity());
            myViewHolder.zx_listview_tv2.setText(zxZbOrderHouse.getOrderHouse().getLayout());
        }

        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zx_ll_xinfangzx://新房整装

                break;
            case R.id.zx_ll2_laofangzx://老房整修
                break;
            case R.id.zx_rl2_kanxianchang://看现场
                break;
            case R.id.zx_rl2_gongdizhibo://工地直播
                break;
            case R.id.zx_rl2_yiqituandui://一起团队
                break;
        }
    }


    class MyViewHolder {//装修直播
        public SimpleDraweeView zx_listview_sdv;
        public TextView zx_listview_tv1;
        public TextView zx_listview_tv2;


    }

    class MyViewHolder1{//轮播
        public ConvenientBanner convenientBanner;//广播伦芳控件
    }

    class MyViewHolder2{//新房整修，旧房整修
        public LinearLayout zx_ll_xinfangzx;//新房整修
        public LinearLayout zx_ll2_laofangzx;//旧房整修
        public RelativeLayout zx_rl2_kanxianchang; //看现场
        public RelativeLayout zx_rl2_gongdizhibo;//工地直播
        public RelativeLayout zx_rl2_yiqituandui;//一起团队
    }
}

