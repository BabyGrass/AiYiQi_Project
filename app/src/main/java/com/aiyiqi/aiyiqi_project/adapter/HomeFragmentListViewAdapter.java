package com.aiyiqi.aiyiqi_project.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.LoginActivity;
import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.assets.HomeFragmnetResultBean;
import com.aiyiqi.aiyiqi_project.view.detailactivity.ArticleDetailActivity;
import com.aiyiqi.aiyiqi_project.view.detailactivity.AuthodActivity;
import com.aiyiqi.aiyiqi_project.view.detailactivity.TieZiDetailActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.List;

public class HomeFragmentListViewAdapter extends BaseAdapter implements View.OnClickListener{
    private Context context;
    private List<HomeFragmnetResultBean.DataBean> dataBeen;

    public HomeFragmentListViewAdapter(Context context, List<HomeFragmnetResultBean.DataBean> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;
    }

    public void addDataThree(List<HomeFragmnetResultBean.DataBean> dataBeenThree) {
        this.dataBeen.addAll(dataBeenThree);
    }

    @Override
    public int getCount() {
        return dataBeen == null ? null : dataBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        ViewHolderTwo viewHolderTwo = null;
        if (convertView == null) {
            if (dataBeen.get(position).getType().equals("1")) {//装修学堂
                viewHolder = new ViewHolder();
                convertView= View.inflate(context, R.layout.decoration_school_image, null);
                viewHolder.schoolTitleTextview = (TextView) convertView.findViewById(R.id.school_title_textview);
                viewHolder.schoolTeziTime = (TextView) convertView.findViewById(R.id.school_tezi_time);
                viewHolder.schoolTeziRenshu = (TextView) convertView.findViewById(R.id.school_tezi_renshu);
                viewHolder.schoolTieziMessage = (TextView) convertView.findViewById(R.id.school_tiezi_message);
                viewHolder.schoolIamge = (SimpleDraweeView) convertView.findViewById(R.id.school_iamge);
                viewHolder.zhungxiu_school_rl = (RelativeLayout) convertView.findViewById(R.id.zhungxiu_school_rl);
                /**
                 * 点击装修学堂跳转到文章详情界面
                 */
                viewHolder.zhungxiu_school_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent intent1 = new Intent(context, ArticleDetailActivity.class);
                        intent1.putExtra("article",dataBeen.get(position));
                        context.startActivity(intent1);
                    }
                });
                /**
                 * 点击业主帖子详情
                 */




                convertView.setTag(viewHolder);
            }
            if (dataBeen.get(position).getType().equals("3")) {//帖子
                viewHolderTwo = new ViewHolderTwo();
                convertView = View.inflate(context, R.layout.yezhu_image_layout, null);
                viewHolderTwo.yezhuName = (TextView) convertView.findViewById(R.id.yezhu_name);
                viewHolderTwo.yezhuTime = (TextView) convertView.findViewById(R.id.yezhu_time);
                //关注
                viewHolderTwo.addGuanzhuTextview = (TextView) convertView.findViewById(R.id.add_guanzhu_textview);
                viewHolderTwo.addGuanzhuTextview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, LoginActivity.class));
                    }
                });
                viewHolderTwo.yezhuMediumTextview = (TextView) convertView.findViewById(R.id.yezhu_medium_textview);
                viewHolderTwo.yezhuLuntanTextview = (TextView) convertView.findViewById(R.id.yezhu_luntan_textview);
                viewHolderTwo.yezhuTeziRenshu = (TextView) convertView.findViewById(R.id.yezhu_tezi_renshu);
                viewHolderTwo.yezhuTieziMessage = (TextView) convertView.findViewById(R.id.yezhu_tiezi_message);
                //头像
                viewHolderTwo.yezhuIamgeHead = (SimpleDraweeView) convertView.findViewById(R.id.yezhu_iamge_head);
                viewHolderTwo.yezhuIamgeHead.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, AuthodActivity.class));
                    }
                });
                viewHolderTwo.yezhuMediumImage = (SimpleDraweeView) convertView.findViewById(R.id.yezhu_medium_image);
                viewHolderTwo.yezhuNameandtimeLl = (LinearLayout) convertView.findViewById(R.id.yezhu_nameandtime_ll);
                viewHolderTwo.yezhuMdeiumLl = (LinearLayout) convertView.findViewById(R.id.yezhu_mdeium_ll);
                viewHolderTwo.yezhuLuntanRl = (RelativeLayout) convertView.findViewById(R.id.yezhu_luntan_rl);
                //帖子监听
                viewHolderTwo.yezhu_tiezi_rl = (RelativeLayout) convertView.findViewById(R.id.yezhu_tiezi_rl);
                viewHolderTwo.yezhu_tiezi_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,TieZiDetailActivity.class);
                        intent.putExtra("tiezi",dataBeen.get(position).getId());
                        Log.i("hhh",dataBeen.get(position)+" ");
                        context.startActivity(intent);
                    }
                });
                convertView.setTag(viewHolderTwo);
            }
        } else {
            if (dataBeen.get(position).getType().equals("1")) {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (dataBeen.get(position).getType().equals("3")) {
                viewHolderTwo = (ViewHolderTwo) convertView.getTag();
            }
        }
        HomeFragmnetResultBean.DataBean data = dataBeen.get(position);
        if (dataBeen.get(position).getType().equals("1")) {
            viewHolder.schoolTitleTextview.setText(data.getTitle());
            //图片
            ImageLoader.getInstance().disPlayImage((SimpleDraweeView) viewHolder.schoolIamge,data.getPath());
            viewHolder.schoolTeziTime.setText(data.getDateline());
            viewHolder.schoolTeziRenshu.setText(data.getViews());
            viewHolder.schoolTieziMessage.setText(data.getReplies());
        }
        if (dataBeen.get(position).getType().equals("3")){
            //图片
            ImageLoader.getInstance().disPlayImage(viewHolderTwo.yezhuIamgeHead,data.getAvtUrl());
            viewHolderTwo.yezhuName.setText(data.getAuthor());
            viewHolderTwo.yezhuTime.setText(data.getDateline());
            viewHolderTwo.yezhuMediumTextview.setText(data.getTitle());
            //图片
            ImageLoader.getInstance().disPlayImage(viewHolderTwo.yezhuMediumImage,data.getPath());
            viewHolderTwo.yezhuLuntanTextview.setText(data.getForum().getName());
            viewHolderTwo.yezhuTeziRenshu.setText(data.getViews());
            viewHolderTwo.yezhuTieziMessage.setText(data.getReplies());
        }
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder{
        private TextView schoolTitleTextview,schoolTeziTime,schoolTeziRenshu,schoolTieziMessage;
        private View schoolIamge;
        private RelativeLayout zhungxiu_school_rl;//装修学堂的布局
    }

    class ViewHolderTwo{
        //帖子
        private TextView yezhuName,yezhuTime,addGuanzhuTextview,yezhuMediumTextview,yezhuLuntanTextview,
                yezhuTeziRenshu,yezhuTieziMessage;
        private SimpleDraweeView yezhuIamgeHead,yezhuMediumImage;
        private LinearLayout yezhuNameandtimeLl,yezhuMdeiumLl;
        private RelativeLayout yezhuLuntanRl;
        private RelativeLayout yezhu_tiezi_rl;
    }

}
