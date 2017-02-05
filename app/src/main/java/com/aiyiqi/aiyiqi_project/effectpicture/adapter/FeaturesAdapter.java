package com.aiyiqi.aiyiqi_project.effectpicture.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.entity.XiaoGuotu;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */

public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesAdapter.ViewHolder> {
    private List<XiaoGuotu.DataBean.ListBean> mlistBeen;


    public FeaturesAdapter(List<XiaoGuotu.DataBean.ListBean> mlistBeen) {
        this.mlistBeen = mlistBeen;
    }
    //添加数据刷新适配器
    public void addDatas(List<XiaoGuotu.DataBean.ListBean> datas,boolean isLoadMore){
        if (isLoadMore == false){
            if (mlistBeen != null){
                mlistBeen.clear();
            }
        }
        mlistBeen.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zhuanti_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 绑定控件设置内容
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        XiaoGuotu.DataBean.ListBean listBean = mlistBeen.get(position);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.setSize(640,120);
        imageLoader.disPlayImage(holder.features_item_img,listBean.getUrl());
        holder.features_item_img_tv.setText(listBean.getTitle());
        holder.features_item_img_look.setText(listBean.getLike_num());
        holder.features_item_img_zan.setText(listBean.getCollected());
        holder.features_item_tv.setText(listBean.getDesc());
    }

    @Override
    public int getItemCount() {
        return mlistBeen == null ? 0 : mlistBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView features_item_img;
        TextView features_item_img_tv;
        TextView features_item_img_look;
        TextView features_item_img_zan;
        TextView features_item_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            this.features_item_img = (SimpleDraweeView) itemView.findViewById(R.id.features_item_img);
            this.features_item_img_look = (TextView) itemView.findViewById(R.id.features_item_img_look);
            this.features_item_img_tv = (TextView) itemView.findViewById(R.id.features_item_img_tv);
            this.features_item_tv = (TextView) itemView.findViewById(R.id.features_item_tv);
            this.features_item_img_zan = (TextView) itemView.findViewById(R.id.features_item_img_zan);
        }
    }


}
