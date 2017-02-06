package com.aiyiqi.aiyiqi_project.zhuangxiugongsi.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.GdZb_Data;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing.GdZb_ZxJdData;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing.GdZb_ZxJdRoot;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 工地直播listview的适配器
 * Created by Administrator on 2017/1/9.
 */

public class GdZbAdapter extends BaseAdapter {
    private Context mcontext;
    private GdZb_Data gdZb_data;//第一个Item的数据
    private List<GdZb_ZxJdData> data;//第二个以后的数据

    public GdZbAdapter(Activity activity) {
        this.mcontext = activity.getBaseContext();
        data = new ArrayList<>();
    }
//    private GdZb_OrderHouse orderHouse;//里面存有图片上地址和名称还有户型
//
//    private GdZb_UserDetail userDetail;
//
//    private String imageUrl;//工地直播 图片url
//
//    private List<GdZb_Members> members ;//参与工地直播的人员及人员工作岗位
//
//    private List<GdZb_Progress> progress ;//工程进度 2、已完成 1、进行中 、0、未完成

    /**
     * 添加人员基本信息数据
     *
     * @param gdZb_data
     */
    public void setFirstData(GdZb_Data gdZb_data) {
        this.gdZb_data = gdZb_data;
    }

    /**
     * 工程嗮图的数据
     */
    public void setGdZb_data(GdZb_ZxJdRoot gdZb_zxJdRoot) {
        this.data = gdZb_zxJdRoot.getData();
    }
    /**
     * 增加工程晒图的数据
     */
    public void addGdZb_data(GdZb_ZxJdRoot gdZb_zxJdRoot){
        this.data.addAll(gdZb_zxJdRoot.getData());
    }
    /**
     * Listview item有几种样式
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;//第一个item数据
        } else {
            return 1;//第二个
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return data == null ? 1 : data.size()+1 ;

    }

    @Override
    public Object getItem(int position) {
        return data == null ? null : data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoulder viewHoulder = null;
        ViewHoulder1 viewHoulder1 = null;
        if (convertView == null) {
            if (getItemViewType(position) == 0) {
                viewHoulder = new ViewHoulder();
                convertView = View.inflate(mcontext, R.layout.layout_gongdizhibo_item, null);
                viewHoulder.simpleDraweeView = (SimpleDraweeView) convertView.findViewById(R.id.zx_listview_sdv1);
                viewHoulder.zx_listview_tv1 = (TextView) convertView.findViewById(R.id.zx_listview_tv1);
                viewHoulder.zx_listview_tv2 = (TextView) convertView.findViewById(R.id.zx_listview_tv2);
                viewHoulder.gdzb_ll_details = (LinearLayout) convertView.findViewById(R.id.gdzb_ll_details);
                viewHoulder.ll_zx_zhuangxiujindu = (LinearLayout) convertView.findViewById(R.id.ll_zx_zhuangxiujindu);
                convertView.setTag(viewHoulder);
            } else  {
                viewHoulder1 = new ViewHoulder1();
                convertView = View.inflate(mcontext, R.layout.layout_gongdizhibo_item1,null);
                viewHoulder1.item1_sdv = (SimpleDraweeView) convertView.findViewById(R.id.item1_sdv);
                viewHoulder1.item1_tv_name = (TextView) convertView.findViewById(R.id.item1_tv_name);
                viewHoulder1.item1_tv_gongzuojidu = (TextView) convertView.findViewById(R.id.item1_gongzuojindu);
                viewHoulder1.item1_recyclerview = (RecyclerView) convertView.findViewById(R.id.item1_recyclerview);
                viewHoulder1.item1_tv_time = (TextView) convertView.findViewById(R.id.item1_tv_time);
                convertView.setTag(viewHoulder1);
            }

        } else {
            if (getItemViewType(position) == 0) {
                viewHoulder = (ViewHoulder) convertView.getTag();
            }else  {
                viewHoulder1 = (ViewHoulder1) convertView.getTag();
            }
        }

        GdZb_Data data1 = gdZb_data;//第一个数据
        //设置数据
        if(getItemViewType(position) == 0){
            //第一个Item的数据
            ImageLoader.getInstance().disPlayImage(viewHoulder.simpleDraweeView,data1.getImageUrl());//房屋图片
            viewHoulder.zx_listview_tv1.setText(data1.getOrderHouse().getCommunity());//房屋名称
            viewHoulder.zx_listview_tv2.setText(data1.getOrderHouse().getLayout());//房屋规格
            addView(viewHoulder.gdzb_ll_details);//此方法里面写有生成控件及设置数据的代码
            addView(viewHoulder.ll_zx_zhuangxiujindu);
        }

        if(getItemViewType(position) >0){
            GdZb_ZxJdData data2=  data.get(position-1);//晒图的数据
            ImageLoader.getInstance().disPlayImage(viewHoulder1.item1_sdv,data2.getAvatar());
            viewHoulder1.item1_tv_name.setText(data2.getCreatorName()+"("+data2.getCreatorRole()+")");
            viewHoulder1.item1_tv_gongzuojidu.setText(data2.getMessage());
            viewHoulder1.item1_tv_time.setText(getFormatedDateTime(data2.getCreateTime()));
            getRecyclerView(viewHoulder1.item1_recyclerview,data2);//生成recyclerview布局，并且设置里面控件数据
        }


        return convertView;
    }

    /**
     * 添加人员信息及装修进度的View
     * @param linearLayout
     */
    public void addView(LinearLayout linearLayout) {

        if (linearLayout.getId() == R.id.gdzb_ll_details) {
            int size = gdZb_data.getMembers().size();

            for (int i = 0; i < size; i++) {
                View v = View.inflate(mcontext, R.layout.layout_gongdizhibo_item2,null);
                v.setPadding(50,10,10,10);
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) v.findViewById(R.id.sd_renyuantupian);
                RoundingParams bitmapOnlyParams = RoundingParams.fromCornersRadius(50) .setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                simpleDraweeView.getHierarchy().setRoundingParams(bitmapOnlyParams);
                TextView textView = (TextView) v.findViewById(R.id.tv_renyuanxingming);
                TextView textView1 = (TextView) v.findViewById(R.id.tv_renyuanxinxi);
                ImageLoader.getInstance().disPlayImage(simpleDraweeView,gdZb_data.getMembers().get(i).getAvatar());
                textView.setText(gdZb_data.getMembers().get(i).getRealName());
                textView1.setText(getName(gdZb_data.getMembers().get(i).getBossId()));
                linearLayout.addView(v);
            }

        } else if (linearLayout.getId() == R.id.ll_zx_zhuangxiujindu) {
               int size = gdZb_data.getProgress().size();

                 for(int i = 0 ; i<size;i ++){
                     View  view = View.inflate(mcontext, R.layout.layout_gongdizhibo_item3,null);
                     TextView tx = (TextView) view.findViewById(R.id.tv_title);
                     TextView tx1 = (TextView) view.findViewById(R.id.tv_jinduneirong);
                     ImageView iv = (ImageView) view.findViewById(R.id.iv_dagou);
                     View  xian = view.findViewById(R.id.view_w);
                     setGdZbJinDu(i,tx,tx1,iv,xian);
                     linearLayout.addView(view);
                }

        }
    }


    /**
     * 判断装修进度
     * 工程进度 2、已完成 1、进行中 、0、未完成
     */

    public void setGdZbJinDu(int a,TextView tv,TextView tv1,ImageView iv,View v) {//
        switch (gdZb_data.getProgress().get(a).getProgressId()) {
            case 1://开工
                switch (gdZb_data.getProgress().get(a).getProgressStatus()) {
                    case 0://未完成
                        tv.setText("未完成");
                        tv.setBackgroundResource(R.color.weiwancheng);
                        iv.setImageResource(R.mipmap.not_finish_icon);
                        tv1.setText("开工");
                        break;
                    case 1://进行中
                        tv.setText("进行中");
                        tv.setBackgroundResource(R.color.jinxingzhong);
                        iv.setImageResource(R.mipmap.working_icon);
                        tv1.setText("开工");
                        break;
                    case 2://已完成
                        tv.setText("已完成");
                        tv.setBackgroundResource(R.color.yiwancheng);
                        iv.setImageResource(R.mipmap.finish_icon);
                        tv1.setText("开工");
                        break;
                }
                break;
            case 2://拆改
                switch (gdZb_data.getProgress().get(a).getProgressStatus()) {
                    case 0://未完成
                        tv.setText("未完成");
                        tv.setBackgroundResource(R.color.weiwancheng);
                        iv.setImageResource(R.mipmap.not_finish_icon);
                        tv1.setText("拆改");
                        break;
                    case 1://进行中
                        tv.setText("进行中");
                        tv.setBackgroundResource(R.color.jinxingzhong);
                        iv.setImageResource(R.mipmap.working_icon);
                        tv1.setText("拆改");
                        break;
                    case 2://已完成
                        tv.setText("已完成");
                        tv.setBackgroundResource(R.color.yiwancheng);
                        iv.setImageResource(R.mipmap.finish_icon);
                        tv1.setText("拆改");
                        break;
                }
                break;
            case 3://水电
                switch (gdZb_data.getProgress().get(a).getProgressStatus()) {
                    case 0://未完成
                        tv.setText("未完成");
                        tv.setBackgroundResource(R.color.weiwancheng);
                        iv.setImageResource(R.mipmap.not_finish_icon);
                        tv1.setText("水电");
                        break;
                    case 1://进行中
                        tv.setText("进行中");
                        tv.setBackgroundResource(R.color.jinxingzhong);
                        iv.setImageResource(R.mipmap.working_icon);
                        tv1.setText("水电");
                        break;
                    case 2://已完成
                        tv.setText("已完成");
                        tv.setBackgroundResource(R.color.yiwancheng);
                        iv.setImageResource(R.mipmap.finish_icon);
                        tv1.setText("水电");
                        break;
                }
                break;
            case 4://泥木
                switch (gdZb_data.getProgress().get(a).getProgressStatus()) {
                    case 0://未完成
                        tv.setText("未完成");
                        tv.setBackgroundResource(R.color.weiwancheng);
                        iv.setImageResource(R.mipmap.not_finish_icon);
                        tv1.setText("泥木");
                        break;
                    case 1://进行中
                        tv.setText("进行中");
                        tv.setBackgroundResource(R.color.jinxingzhong);
                        iv.setImageResource(R.mipmap.working_icon);
                        tv1.setText("泥木");
                        break;
                    case 2://已完成
                        tv.setText("已完成");
                        tv.setBackgroundResource(R.color.yiwancheng);
                        iv.setImageResource(R.mipmap.finish_icon);
                        tv1.setText("泥木");
                        break;
                }
                break;
            case 5://油漆
                switch (gdZb_data.getProgress().get(a).getProgressStatus()) {
                    case 0://未完成
                        tv.setText("未完成");
                        tv.setBackgroundResource(R.color.weiwancheng);
                        iv.setImageResource(R.mipmap.not_finish_icon);
                        tv1.setText("油漆");
                        break;
                    case 1://进行中
                        tv.setText("进行中");
                        tv.setBackgroundResource(R.color.jinxingzhong);
                        iv.setImageResource(R.mipmap.working_icon);
                        tv1.setText("油漆");
                        break;
                    case 2://已完成
                        tv.setText("已完成");
                        tv.setBackgroundResource(R.color.yiwancheng);
                        iv.setImageResource(R.mipmap.finish_icon);
                        tv1.setText("油漆");
                        break;
                }
                    break;
                    case 6://安装
                        switch (gdZb_data.getProgress().get(a).getProgressStatus()) {
                            case 0://未完成
                                tv.setText("未完成");
                                tv.setBackgroundResource(R.color.weiwancheng);
                                iv.setImageResource(R.mipmap.not_finish_icon);
                                tv1.setText("安装");
                                break;
                            case 1://进行中
                                tv.setText("进行中");
                                tv.setBackgroundResource(R.color.jinxingzhong);
                                iv.setImageResource(R.mipmap.working_icon);
                                tv1.setText("安装");
                                break;
                            case 2://已完成
                                tv.setText("已完成");
                                tv.setBackgroundResource(R.color.yiwancheng);
                                iv.setImageResource(R.mipmap.finish_icon);
                                tv1.setText("安装");
                                break;
                        }
                        break;
                    case 7://竣工
                        switch (gdZb_data.getProgress().get(a).getProgressStatus()) {
                            case 0://未完成
                                tv.setText("未完成");
                                tv.setBackgroundResource(R.color.weiwancheng);
                                iv.setImageResource(R.mipmap.not_finish_icon);
                                tv1.setText("竣工");
                                v.setVisibility(View.GONE);
                                break;
                            case 1://进行中
                                tv.setText("进行中");
                                tv.setBackgroundResource(R.color.jinxingzhong);
                                iv.setImageResource(R.mipmap.working_icon);
                                tv1.setText("竣工");
                                v.setVisibility(View.GONE);
                                break;
                            case 2://已完成
                                tv.setText("已完成");
                                tv.setBackgroundResource(R.color.yiwancheng);
                                iv.setImageResource(R.mipmap.finish_icon);
                                tv1.setText("竣工");
                                v.setVisibility(View.GONE);
                                break;
                        }
                        break;
                }
        }

    /**
     * 人员信息
     * @param id
     * @return
     */

    public String getName(Long id) {
        if (id == 1701) {
            return "设计师";
        } else if (id == 1702) {
            return "监理";
        } else if (id == 1703) {
            return "工长";
        } else if (id == 1705) {
            return "材料顾问";
        }
        return "";
    }

/**
 * 毫秒值转换成日期
 */
public static String getFormatedDateTime(long dateTime) {
    String pattern = "yy-MM-dd HH:mm";
    SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
    return sDateFormat.format(new Date(dateTime + 0));
}

    /**
     * 生成RecyclerView的布局
     */
    public void getRecyclerView(RecyclerView recyclerView, GdZb_ZxJdData gdata){
        //设置网格布局
        GridLayoutManager manager = new GridLayoutManager(mcontext,3);
        recyclerView.setLayoutManager(manager);//将网格布局管理加载到recyclerView上

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mcontext,getRecyclerViewData(gdata.getImgSrc()));
        recyclerView.setAdapter(adapter);
    }
    private List<String> getRecyclerViewData(String string){
        List<String> list = new ArrayList<>();
        if (string==null||string.equals("")){

        }else {
            String[]  urls = string.split(",");
            for (int i = 0;i<urls.length;i++){
                list.add(urls[i]);
            }
        }
        return list;
    }
}


/**
 * 人员基本信息
 */
class ViewHoulder {
    public SimpleDraweeView simpleDraweeView;
    public TextView zx_listview_tv1;//图片上面的TextView
    public TextView zx_listview_tv2;//图片下面的TextView
    public LinearLayout gdzb_ll_details;//人员基本信息的线性布局（动态加载控件）
    public LinearLayout ll_zx_zhuangxiujindu;//装修进度的线性布局（动态加载控件）
}

/**
 * 装修进度晒图评价列表
 */

class ViewHoulder1{
    public SimpleDraweeView item1_sdv;//头像
    public TextView item1_tv_name;//姓名+（职位）
    public TextView item1_tv_gongzuojidu;//工作进度内容
    public TextView item1_tv_time;//上传时间
    public RecyclerView item1_recyclerview;//装修进度晒图
}

