package com.aiyiqi.aiyiqi_project.decorateSchool.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
    private List<String> tags;

    public TagAdapter(List<String> tags) {
        this.tags = tags;
    }
    public TagAdapter(){}
    public void addData(List<String> tags) {
        this.tags = tags;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),R.layout.decorate_school_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String tag = tags.get(position);
        holder.decorate_school_tv.setText(tag.toString());
    }

    @Override
    public int getItemCount() {
        return tags == null ? 0 : tags.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        TextView decorate_school_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            this.decorate_school_tv = (TextView) itemView.findViewById(R.id.decorate_tag_item);
        }
    }
}
