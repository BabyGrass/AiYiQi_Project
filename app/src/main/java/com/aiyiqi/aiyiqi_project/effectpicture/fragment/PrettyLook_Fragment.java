package com.aiyiqi.aiyiqi_project.effectpicture.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.entity.Meitu;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.imageload.ImageLoader;
import com.finesdk.util.display.DisplayUtil;

/**
 * Created by Administrator on 2017/1/18.
 */

public class PrettyLook_Fragment extends BaseFragment {

    private ViewPager view_pretty_look;
    private ImageLoader imgloader;
    private Meitu.DataBean.ListBean list;

    @Override
    protected int getResource() {
        return R.layout.frag_prettylook;
    }

    @Override
    protected void beforeInitView() {
//        list = (Meitu.DataBean.ListBean) getArguments().getSerializable("list");
    }

    @Override
    protected void initView(View rootView) {
        view_pretty_look = findViewByIdNoCast(R.id.view_pretty_look);

    }

    @Override
    protected void initData() {
//        showData(list);
    }

    @Override
    public void onClick(View v) {

    }
    public void showData(Meitu.DataBean.ListBean list){

        String url = list.getUrl();
        ImageLoader loader = ImageLoader.getInstance();
        int height = DisplayUtil.getDensity_Height(getContext());
        SimpleDraweeView img = new SimpleDraweeView(getContext());
        img.setMaxWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        img.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        img.setMaxHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        img.setMinimumHeight(height/2);
        loader.disPlayImage(img,url);
        view_pretty_look.addView(img);
    }
}
