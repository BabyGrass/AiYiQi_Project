package com.aiyiqi.aiyiqi_project.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.YeZhuBankuaiResultBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/8.
 */

public class BanKuaiAdapter extends BaseAdapter {
    private RecyclerViewAdapter adapter;
    private Context context;
    //数据源
    private List<List<YeZhuBankuaiResultBean.DataBean>> dataBeanList;
    //构造函数
    public BanKuaiAdapter(Context context, List<List<YeZhuBankuaiResultBean.DataBean>> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public int getCount() {
        return dataBeanList == null?0:dataBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeanList == null?null:dataBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.recyclerview_title_item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.recycler_title_textview = (TextView) convertView.findViewById(R.id.recycler_title_textview);
            viewHolder.listview_recycler = (RecyclerView) convertView.findViewById(R.id.listview_recycler);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        List<YeZhuBankuaiResultBean.DataBean> dataBean = dataBeanList.get(position);
        if(dataBean != null){
            viewHolder.recycler_title_textview.setText(gettitle(position));
            adapter = new RecyclerViewAdapter(context,dataBeanList.get(position));
            viewHolder.listview_recycler.setAdapter(adapter);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
            viewHolder.listview_recycler.setLayoutManager(gridLayoutManager);
        }
        return convertView;
    }

    class ViewHolder{
        private TextView recycler_title_textview;
        private RecyclerView listview_recycler;
    }

    public String gettitle(int index) {
        switch (index) {
            case 0:
                return "成都装修论坛";
            case 1:
                return "装修选购区";
            case 2:
                return "品牌热议区";
            case 3:
                return "其他";
        }
        return null;
    }

}
