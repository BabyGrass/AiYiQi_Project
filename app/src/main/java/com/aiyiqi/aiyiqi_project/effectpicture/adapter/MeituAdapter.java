package com.aiyiqi.aiyiqi_project.effectpicture.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.entity.Meitu;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */

public class MeituAdapter extends RecyclerView.Adapter<MeituAdapter.ViewHolder> {
    private List<Meitu.DataBean.ListBean> listBeen;

    public MeituAdapter(List<Meitu.DataBean.ListBean> listBeen) {
        this.listBeen = listBeen;
    }

    public void addDatas(List<Meitu.DataBean.ListBean> beanList){
        listBeen.addAll(beanList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meitu_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Meitu.DataBean.ListBean listBean = listBeen.get(position);
        ImageLoader loader = ImageLoader.getInstance();
        loader.disPlayImage(holder.meitu_item_img,listBean.getUrl());
        holder.mei_item_look.setText("  "+listBean.getCollected()+"   ");
        holder.mei_item_like.setText("  "+listBean.getLike_num());
    }

    @Override
    public int getItemCount() {
        return listBeen == null ? 0 :listBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
       private SimpleDraweeView meitu_item_img;
       private TextView mei_item_look;
       private TextView mei_item_like;
       public ViewHolder(View itemView) {
           super(itemView);
           this.meitu_item_img = (SimpleDraweeView) itemView.findViewById(R.id.meitu_item_img);
           this.mei_item_look = (TextView) itemView.findViewById(R.id.meitu_item_look);
           this.mei_item_like = (TextView) itemView.findViewById(R.id.meitu_item_like);
       }
   }
}
