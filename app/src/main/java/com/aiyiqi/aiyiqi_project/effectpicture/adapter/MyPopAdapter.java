package com.aiyiqi.aiyiqi_project.effectpicture.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class MyPopAdapter extends RecyclerView.Adapter<MyPopAdapter.ViewHolder> {
    private List<String> list;

    public MyPopAdapter(List<String> list) {
        this.list = list;
    }
    public void addData(List<String> list1){
        list.addAll(list1);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),R.layout.pop_item,null);
        final ViewHolder holder = new ViewHolder(view);
//        holder.pop_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                String data = list.get(position);
//                if (){
//                    holder.pop_tv.setTextColor(Color.WHITE);
//                    holder.pop_tv.setBackgroundColor(Color.parseColor("#00CC00"));
//                }else {
//                    holder.pop_tv.setTextColor(Color.BLACK);
//                    holder.pop_tv.setBackgroundColor(Color.parseColor("#ffffff"));
//                }
//
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String data = list.get(position);
        holder.pop_tv.setText(data);
        //设置标签
        holder.pop_tv.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView pop_tv;
        ImageView pop_yanse;
        public ViewHolder(View itemView) {
            super(itemView);
            pop_tv = (TextView) itemView.findViewById(R.id.pop_tv);
            pop_yanse = (ImageView) itemView.findViewById(R.id.pop_yanse);


            //监听控件
            pop_tv.setOnClickListener(clickListener);
        }
    }




    //设置监听
    public View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            if (listener != null){
                listener.itemClickListener(position,v);
            }
        }
    };




    //回调方法
    public OnItemClickListener listener;
    public void setClickListener(OnItemClickListener clickListener){
        this.listener = clickListener;
    }
    public interface OnItemClickListener{
        void itemClickListener(int position, View view);
    }
}
