package com.aiyiqi.aiyiqi_project.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.YeZhuJinghuaResultBean;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.List;


/**
 * Created by Administrator on 2017/1/7.
 */

public class YeZheFragmentAdapter extends BaseAdapter {
    private Context context;
    private List<YeZhuJinghuaResultBean.DataBean> dataBeanList;

    public YeZheFragmentAdapter(Context context, List<YeZhuJinghuaResultBean.DataBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
    }
    public void setData(List<YeZhuJinghuaResultBean.DataBean> dataBeanList){
        this.dataBeanList.addAll(dataBeanList);
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
        ViewHolder holder = null;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.yezhu_new_item_layout,null);
            holder = new ViewHolder();
            holder.yezhu_new_msg = (TextView) convertView.findViewById(R.id.yezhu_new_msg);
            holder.yezhu_new_nameandtime_tv = (TextView) convertView.findViewById(R.id.yezhu_new_nameandtime_tv);
            holder.yezhu_new_tezi_renshu = (TextView) convertView.findViewById(R.id.yezhu_new_tezi_renshu);
            holder.yezhu_new_tiezi_message = (TextView) convertView.findViewById(R.id.yezhu_new_tiezi_message);
            holder.yezhu_new_iamge_head = convertView.findViewById(R.id.yezhu_new_iamge_head);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        YeZhuJinghuaResultBean.DataBean dataBean = dataBeanList.get(position);
        holder.yezhu_new_msg.setText(dataBean.getSubject());
        holder.yezhu_new_nameandtime_tv.setText(dataBean.getAuthor()+" "+dataBean.getDateline());
        holder.yezhu_new_tezi_renshu.setText(dataBean.getViews());
        holder.yezhu_new_tiezi_message.setText(dataBean.getReplies());
        ImageLoader.getInstance().disPlayImage((SimpleDraweeView) holder.yezhu_new_iamge_head,dataBean.getAvtUrl());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(50)
                .setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
        ((SimpleDraweeView) holder.yezhu_new_iamge_head).getHierarchy().setRoundingParams(roundingParams);
        return convertView;
    }
    class ViewHolder{
        private TextView yezhu_new_msg,yezhu_new_nameandtime_tv,yezhu_new_tezi_renshu,yezhu_new_tiezi_message;
        private View yezhu_new_iamge_head;
    }

}
