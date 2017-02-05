package com.aiyiqi.aiyiqi_project.decorateSchool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.decorateSchool.entity.DecorateSchoolContent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;
import com.finesdk.util.common.LogUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */

public class MyListAdapter extends BaseAdapter {
    private List<DecorateSchoolContent.Data.Lists> lists;
    private Context context;
    private LayoutInflater inflater;
    private ImageLoader imgLoader;
    private boolean isLoadMore = false;

    public MyListAdapter() {
    }

    public MyListAdapter(Context context, List<DecorateSchoolContent.Data.Lists> lists) {
        this.context = context;
        this.lists = lists;
        this.imgLoader = ImageLoader.getInstance();
    }

    public MyListAdapter(Context context, List<DecorateSchoolContent.Data.Lists> list,ImageLoader imgLoader) {
        this.lists = list;
        this.context = context;
        this.imgLoader = imgLoader;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 判断是否是加载更多 不是就更换数据，否则添加数据
     * @param list
     * @param isLoadMore
     */
    public void addData(List<DecorateSchoolContent.Data.Lists> list,boolean isLoadMore){
        LogUtil.d("msg","list:"+list.size());
        if (isLoadMore == false){
            if (lists != null) {
                lists.clear();
            }
        }
        lists.addAll(list);
        notifyDataSetChanged();
    }


    public void setData(List<DecorateSchoolContent.Data.Lists> list) {
            this.lists.clear();
            addData(list,false);
    }

    @Override
    public int getCount() {
        return lists == null ? 0 : lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists == null ? null : lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.decorate_school_list_item,null,false);
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
        DecorateSchoolContent.Data.Lists list = lists.get(position);
        holder.content_tv.setText(list.getTitles());
        holder.content_look.setText(list.getViewCount());
        holder.content_shoucang.setText(list.getFavNums());
        holder.content_pinglun.setText(list.getReplies());
//        holder.content_Img.setImageURI(Uri.parse(list.getImages()));
        LogUtil.d("msg","list.getImages():"+list.getImages());
        imgLoader.disPlayImage( holder.content_Img,list.getImages());
        return convertView;
    }


    class ViewHolder {
        TextView content_tv,content_look,content_shoucang,content_pinglun;
        SimpleDraweeView content_Img;
    }
}
