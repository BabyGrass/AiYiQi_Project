package com.aiyiqi.aiyiqi_project.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.YeZhuJinghuaResultBean;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/1/7.
 */

public class YeZheJinghuaFragmentAdapter extends BaseAdapter {
    private Context context;
    private List<YeZhuJinghuaResultBean.DataBean> dataBeanList;

    public YeZheJinghuaFragmentAdapter(Context context){
        this.context = context;
        dataBeanList = new ArrayList<>();
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
            convertView = View.inflate(context, R.layout.yezhu_jinghua_item_layout,null);
            holder = new ViewHolder();
            holder.yezhu_jainghua_name = (TextView) convertView.findViewById(R.id.yezhu_jainghua_name);
            holder.yezhu_jianghua_detail = (TextView) convertView.findViewById(R.id.yezhu_jianghua_detail);
            holder.yezhu_jignhua_medium_textview = (TextView) convertView.findViewById(R.id.yezhu_jignhua_medium_textview);
            holder.yezhu_jinghua_button1 = (TextView) convertView.findViewById(R.id.yezhu_jinghua_button1);
            holder.yezhu_jinghua_button2 = (TextView) convertView.findViewById(R.id.yezhu_jinghua_button2);
            holder.yezhu_jinghua_button3 = (TextView) convertView.findViewById(R.id.yezhu_jinghua_button3);
            holder.yezhu_jinghua_luntan_textview = (TextView) convertView.findViewById(R.id.yezhu_jinghua_luntan_textview);
            holder.yezhu_jignhua_time = (TextView) convertView.findViewById(R.id.yezhu_jignhua_time);
            holder.yezhu_jinghua_tezi_msg = (TextView) convertView.findViewById(R.id.yezhu_jinghua_tezi_msg);
            holder.yezhu_jinghua_iamge_head = (SimpleDraweeView) convertView.findViewById(R.id.yezhu_jinghua_iamge_head);
            holder.yezhu_jinghua_medium_image = (SimpleDraweeView) convertView.findViewById(R.id.yezhu_jinghua_medium_image);
            holder.yezhu_jignhua_button_ll = (LinearLayout) convertView.findViewById(R.id.yezhu_jignhua_button_ll);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        YeZhuJinghuaResultBean.DataBean dataBean = dataBeanList.get(position);
        if(dataBean != null){
            holder.yezhu_jainghua_name.setText(dataBean.getAuthor());
            if(dataBean.getHouseInfo() != null){
                holder.yezhu_jianghua_detail.setText(dataBean.getHouseInfo().getArea()+"平米 "+
                        dataBean.getHouseInfo().getBudget()+"万");
            }
            holder.yezhu_jignhua_medium_textview.setText(dataBean.getSubject());
            showLable(holder,dataBean);
            holder.yezhu_jinghua_luntan_textview.setText(dataBean.getFname());
            holder.yezhu_jignhua_time.setText(dataBean.getDateline());
            holder.yezhu_jinghua_tezi_msg.setText(dataBean.getReplies());
            //图片
            ImageLoader.getInstance().disPlayImage(holder.yezhu_jinghua_iamge_head,dataBean.getAvtUrl());
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(50)
                    .setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
            holder.yezhu_jinghua_iamge_head.getHierarchy().setRoundingParams(roundingParams);
            if(dataBean.getAttachments()!= null){
                ImageLoader.getInstance().disPlayImage(holder.yezhu_jinghua_medium_image,dataBean.getAttachments().get(0));
                holder.yezhu_jinghua_medium_image.setVisibility(View.VISIBLE);
            }
            else{
                holder.yezhu_jinghua_medium_image.setVisibility(View.GONE);
            }
        }

        return convertView;
    }
    class ViewHolder{
        private TextView yezhu_jainghua_name,yezhu_jianghua_detail,yezhu_jignhua_medium_textview,
                yezhu_jinghua_button1,yezhu_jinghua_button2,yezhu_jinghua_button3,yezhu_jinghua_luntan_textview,
                yezhu_jignhua_time,yezhu_jinghua_tezi_msg;
        private SimpleDraweeView yezhu_jinghua_iamge_head,yezhu_jinghua_medium_image;
        private LinearLayout yezhu_jignhua_button_ll;
    }

    /**
     * 三个标签的显示方法
     */
    public void showLable(ViewHolder holder,YeZhuJinghuaResultBean.DataBean dataBean){
        if(dataBean.getTags().size() == 0){
            holder.yezhu_jignhua_button_ll.setVisibility(View.GONE);
        }
        if(dataBean.getTags().size() == 1){
            holder.yezhu_jignhua_button_ll.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setText(dataBean.getTags().get(0).getTagname());
        }
        if(dataBean.getTags().size() == 2){
            holder.yezhu_jignhua_button_ll.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setText(dataBean.getTags().get(0).getTagname());
            holder.yezhu_jinghua_button2.setText(dataBean.getTags().get(1).getTagname());
        }
        if(dataBean.getTags().size() >= 3){
            holder.yezhu_jignhua_button_ll.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button3.setVisibility(View.VISIBLE);
            holder.yezhu_jinghua_button1.setText(dataBean.getTags().get(0).getTagname());
            holder.yezhu_jinghua_button2.setText(dataBean.getTags().get(1).getTagname());
            holder.yezhu_jinghua_button3.setText(dataBean.getTags().get(2).getTagname());
        }
    }

}
