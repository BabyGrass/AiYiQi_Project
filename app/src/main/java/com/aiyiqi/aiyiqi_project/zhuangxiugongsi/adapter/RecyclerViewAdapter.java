package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aiyiqi.aiyiqi_project.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private List<String> data;//内部有图片数据

    public RecyclerViewAdapter(Context context ,List<String> data ){
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = View.inflate(context, R.layout.recyclerviewitem,null);
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.simpleDraweeView = (SimpleDraweeView) v.findViewById(R.id.recyclerview_item_sdv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        ImageLoader.getInstance().disPlayImage(holder.simpleDraweeView,data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView;//图片控件
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
