package com.aiyiqi.aiyiqi_project.decorateSchool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.decorateSchool.entity.DecorateSchoolDetail;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;
import com.finesdk.util.common.LogUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/1/17.
 */

public class ArticlesAdapter extends BaseAdapter {
    private List<DecorateSchoolDetail.DataBean.RelatedNewsBean> relatedNewsBean;
    private Context context;
    private ImageLoader imageLoader;

    public ArticlesAdapter(Context context) {
        this.context = context;
    }

    public ArticlesAdapter(List<DecorateSchoolDetail.DataBean.RelatedNewsBean> relatedNewsBean, Context context) {
        this.relatedNewsBean = relatedNewsBean;
        this.context = context;
    }

    public void addData(List<DecorateSchoolDetail.DataBean.RelatedNewsBean> relatedNewsBean1){
        relatedNewsBean.addAll(relatedNewsBean1);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        LogUtil.i("msg","relatedNewsBean.size:"+relatedNewsBean.size());
        return relatedNewsBean == null ? 0 : relatedNewsBean.size();
    }

    @Override
    public Object getItem(int position) {
        return relatedNewsBean == null ? null : relatedNewsBean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.decorate_school_list_item,parent,false);
            holder = new ViewHolder();
            holder.content_tv = (TextView) convertView.findViewById(R.id.content_tv);
            holder.content_look = (TextView) convertView.findViewById(R.id.content_tv_look);
            holder.content_shoucang = (TextView) convertView.findViewById(R.id.content_tv_shoucang);
            holder.content_pinglun = (TextView) convertView.findViewById(R.id.content_tv_pinglun);
            holder.content_Img = (SimpleDraweeView) convertView.findViewById(R.id.content_img);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        DecorateSchoolDetail.DataBean.RelatedNewsBean relatedNewsbean = relatedNewsBean.get(position);
        holder.content_tv.setText(relatedNewsbean.getTitle());
        holder.content_look.setText(String.valueOf(relatedNewsbean.getClick()));
        holder.content_pinglun.setText(relatedNewsbean.getComment_count());
        holder.content_shoucang.setText(String.valueOf(relatedNewsbean.getFavNums()));
        imageLoader = ImageLoader.getInstance();
        imageLoader.disPlayImage(holder.content_Img,relatedNewsbean.getThumb());
        return convertView;
    }

    class ViewHolder {
        TextView content_tv,content_look,content_shoucang,content_pinglun;
        SimpleDraweeView content_Img;
    }
}
