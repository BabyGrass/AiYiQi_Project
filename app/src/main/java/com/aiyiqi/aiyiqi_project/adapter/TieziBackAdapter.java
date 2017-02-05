package com.aiyiqi.aiyiqi_project.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.TieziBackBean;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.List;


public class TieziBackAdapter extends BaseAdapter{
    private Context context;
    private List<TieziBackBean.DataBean> dataBeanList;

    public TieziBackAdapter(Context context,List<TieziBackBean.DataBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    public void setData(List<TieziBackBean.DataBean> dataBeanList){
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
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.tiezi_comment_item_layout,null);
            holder = new ViewHolder();
            holder.tiezi_iamge_head = (SimpleDraweeView) convertView.findViewById(R.id.tiezi_iamge_head);
            holder.tiezi_detwail_huifuname = (TextView) convertView.findViewById(R.id.tiezi_detwail_huifuname);
            holder.tiezi_comment_contnet = (TextView) convertView.findViewById(R.id.tiezi_comment_contnet);
            holder.tiezi_huifu_time = (TextView) convertView.findViewById(R.id.tiezi_huifu_time);
            holder.tiezi_more_comment = (ImageView) convertView.findViewById(R.id.tiezi_more_comment);
            /**
             * 点击弹出评论
             */
            holder.tiezi_more_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        TieziBackBean.DataBean data = this.dataBeanList.get(position);
        //头像图片
        ImageLoader.getInstance().disPlayImage(holder.tiezi_iamge_head,data.getAvtUrl());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(50)
                .setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
        holder.tiezi_iamge_head.getHierarchy().setRoundingParams(roundingParams);
        holder.tiezi_detwail_huifuname.setText(data.getAuthor());
        if(data.getMessage().get(position).getImgType() ==0){
            holder.tiezi_comment_contnet.setText(data.getMessage().get(position).getMsg());
        }
        holder.tiezi_huifu_time.setText(data.getDateline());
        return convertView;
    }
    private class ViewHolder{
        private SimpleDraweeView tiezi_iamge_head;
        private TextView tiezi_detwail_huifuname,tiezi_comment_contnet,tiezi_huifu_time;
        private ImageView tiezi_more_comment;
    }
}
