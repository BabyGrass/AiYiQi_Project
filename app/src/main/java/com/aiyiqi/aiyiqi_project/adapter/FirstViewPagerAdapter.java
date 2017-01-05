package com.aiyiqi.aiyiqi_project.adapter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aiyiqi.aiyiqi_project.assets.ViewPagerImageUrl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class FirstViewPagerAdapter extends PagerAdapter{
    //图片地址解析类
    private List<ViewPagerImageUrl.DataBean> dataBeen;
    private List<SimpleDraweeView> lunboIamge;

    public void setDataBeen(List<ViewPagerImageUrl.DataBean> dataBeen){
        this.dataBeen.addAll(dataBeen);
    }

    public FirstViewPagerAdapter(Context context,List<ViewPagerImageUrl.DataBean> dataBeen){
        this.lunboIamge = new ArrayList<>();
        this.dataBeen = dataBeen;

        //初始化ImageView
        if(dataBeen != null && dataBeen.size() != 0){
            for (ViewPagerImageUrl.DataBean imgUrlArrBean : this.dataBeen){
                SimpleDraweeView imageView = new SimpleDraweeView(context);
                lunboIamge.add(imageView);
            }
        }

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return lunboIamge.size() == 0?0:lunboIamge.size()*100;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= lunboIamge.size();
        if (position<0){
            position = lunboIamge.size()+position;
        }
        ImageView imageView = lunboIamge.get(position);
        //下载
       ImageLoader.getInstance().disPlayImage(lunboIamge.get(position),dataBeen.get(position).getImagesrc());

        ViewPager v =  (ViewPager)imageView.getParent();
        //没有被其他的Views使用这可以添加到新的View里面
        if(v != null){
            v.removeView(imageView);
        }
        container.addView(imageView);
        return imageView;

    }
}
