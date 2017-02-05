package com.aiyiqi.aiyiqi_project.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.YeZhuBankuaiResultBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context context;
    private List<YeZhuBankuaiResultBean.DataBean> dataBeanList;

    public RecyclerViewAdapter(Context context,List<YeZhuBankuaiResultBean.DataBean> dataBeanList) {
        super();
        this.context = context;
        this.dataBeanList = dataBeanList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.recyclerview_body_item_layout,null);
        MyViewHolder  holder = new MyViewHolder(view);
        holder.simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.recycler_imageview);
        holder.tv1 = (TextView) view.findViewById(R.id.name_textview);
        holder.tv2 = (TextView) view.findViewById(R.id.zongtie_textview);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //图片
        ImageLoader.getInstance().disPlayImage(holder.simpleDraweeView,dataBeanList.get(position).getIcon());
        holder.tv1.setText(dataBeanList.get(position).getTitle());
        holder.tv2.setText(dataBeanList.get(position).getThreadsnum());
    }

    @Override
    public int getItemCount() {
        return dataBeanList == null?0:dataBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView tv1,tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
