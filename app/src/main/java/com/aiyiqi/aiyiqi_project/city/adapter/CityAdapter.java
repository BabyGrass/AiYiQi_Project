package com.aiyiqi.aiyiqi_project.city.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.city.entity.CityEntity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private List<CityEntity.DataBean.ForumlistBean> forumlistBeanList;
    private Context context;
    private LayoutInflater inflater;

    public CityAdapter(Context context) {
        this.forumlistBeanList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    //添加数据到集合中
    public void addDatas(List<CityEntity.DataBean.ForumlistBean> datas){
        forumlistBeanList.addAll(datas);
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        CityEntity.DataBean.ForumlistBean forumlistBean = forumlistBeanList.get(position);
//        holder.city_item_BImg.setImageURI(Uri.parse(forumlistBean.getAttachments()));
        //图片框架加载
        ImageLoader loader = ImageLoader.getInstance();
        loader.setSize(640,120);
        //展示图片
        loader.disPlayImage(holder.city_item_BImg,forumlistBean.getAttachments());
        holder.city_item_day.setText(" 报名截止时间 : "+forumlistBean.getLastpost());
        if (forumlistBean.getActivityclose().equals("1")){
            holder.city_item_tvImg.setImageResource(R.mipmap.activity_end_sign);
            holder.city_item_tv.setText("活动已结束...");
        }else if (forumlistBean.getActivityclose().equals("0")){
            holder.city_item_tvImg.setImageResource(R.mipmap.activity_hot_sign);
            holder.city_item_tv.setText("火热进行中...");
        }
        //对点击的position设置标签
        holder.rl_city_item.setTag(position);
    }

    @Override
    public int getItemCount() {
        return forumlistBeanList == null ? 0 : forumlistBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView city_item_BImg;
        TextView city_item_day;
        TextView city_item_tv;
        ImageView city_item_tvImg;
        RelativeLayout rl_city_item;
        public ViewHolder(View itemView) {
            super(itemView);
            city_item_BImg = (SimpleDraweeView) itemView.findViewById(R.id.city_item_BImg);
            city_item_day = (TextView) itemView.findViewById(R.id.city_item_day);
            city_item_tv = (TextView) itemView.findViewById(R.id.city_item_tv);
            city_item_tvImg = (ImageView) itemView.findViewById(R.id.city_item_tvImg);
            rl_city_item = (RelativeLayout) itemView.findViewById(R.id.rl_city_item);
            rl_city_item.setOnClickListener(clickListener);
        }
    }
    //监听
    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //得到的position值赋值给对象
            int positon = (int) v.getTag();
            if (listener != null){
                listener.onItemClick(positon,v);
            }
        }
    };

    /**
     * 回调监听Item
     */
    private OnItemClickListener listener;
    public void setOnItemClickListener( OnItemClickListener listener){
        this.listener = listener;
    }
    public interface OnItemClickListener{
        void onItemClick(int position, View view);
    }
}
